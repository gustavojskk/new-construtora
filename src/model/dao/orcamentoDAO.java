
package model.dao;
import connection.ConnectionFactory;                                              
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.orcamento;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.List;
import model.bean.Materiais;
import model.bean.Tabelaclientes;

public class orcamentoDAO {
    
    PreparedStatement stmt;
    Connection con;
    ResultSet rst;

    public void Cadastrar_orcamento(orcamento o) throws SQLException {

      con = ConnectionFactory.getConnection();
       
      String sql = "INSERT INTO orcamento (materiais,quantidade,servico,prazodeobra,total,idclientes) VALUES (?,?,?,?,?,?)";
     
      try {

            stmt = con.prepareStatement(sql);
   

            stmt.setString(1,o.getMateriais());        
            stmt.setString(2,o.getQuantidade());
            stmt.setString(3,o.getServico());
            stmt.setString(4,o.getPrazodeobra());
            stmt.setString(5,o.getTotal());
            stmt.setString(6,o.getIdclientes());
      
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "erro ao salvar " + error);
            System.out.println(error);

        }
    
    }
    public List<orcamento> read() {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<orcamento> orcamentolist = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT produto FROM Materiais");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                orcamento tabela_clientes = new orcamento();

                tabela_clientes.setMateriais(rs.getString("produto"));
                
                orcamentolist.add(tabela_clientes);
            }

        } catch (SQLException ex) {
            Logger.getLogger(orcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return orcamentolist;

    }
    
     public void readpreco(String produto, Materiais m) {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
            stmt = con.prepareStatement("SELECT preco FROM Materiais WHERE produto = ?");
            stmt.setString(1, produto);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                int produtoBD = rs.getInt("preco");
                
                
                m.setPreco(produtoBD);
            }

        } catch (SQLException ex) {
            Logger.getLogger(orcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }


    }
    
    
}
