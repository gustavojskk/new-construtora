package model.dao;

import connection.ConnectionFactory;                                              
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Tabelaclientes;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.List;


public class TabelaclientesDAO {

    PreparedStatement stmt;
    Connection con;
    ResultSet rst;

    public void Cadastrar_cliente(Tabelaclientes c) throws SQLException {

      con = ConnectionFactory.getConnection();
       
      String sql = "INSERT INTO tabelaclientes (nome,cpf,CNPJ,RG,Cel,Fixo,email,Rua,Numerocasa,CEP,Bairro,cidade,Complemento ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
     
      try {

            stmt = con.prepareStatement(sql);
   

            stmt.setString(1,c.getNome());        
            stmt.setString(2,c.getCpf());
            stmt.setString(3,c.getCNPJ());
            stmt.setString(4,c.getRG());
            stmt.setString(5,c.getCel());
            stmt.setString(6,c.getFixo());
            stmt.setString(7,c.getEmail());
            stmt.setString(8,c.getRua());
            stmt.setInt(9,c.getNumerocasa());
            stmt.setString(10,c.getCEP());
            stmt.setString(11,c.getBairro());
            stmt.setString(12,c.getCidade());
            stmt.setString(13,c.getComplemento());
      
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "erro ao salvar " + error);
            System.out.println(error);

        }
    
    }
    public List<Tabelaclientes> read() {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Tabelaclientes> tabelaclientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tabelaclientes");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Tabelaclientes tabela_clientes = new Tabelaclientes();

                tabela_clientes.setNome(rs.getString("nome"));
                tabela_clientes.setIdclientes(rs.getInt("idclientes"));
                tabela_clientes.setCpf(rs.getString("cpf"));
                tabela_clientes.setCNPJ(rs.getString("CNPJ"));
                tabela_clientes.setRG(rs.getString("RG"));
                tabela_clientes.setCel(rs.getString("Cel"));
                tabela_clientes.setFixo(rs.getString("Fixo"));
                tabela_clientes.setEmail(rs.getString("email"));
                tabela_clientes.setRua(rs.getString("Rua"));
                tabela_clientes.setNumerocasa(rs.getInt("Numerocasa"));
                tabela_clientes.setCEP(rs.getString("CEP"));
                tabela_clientes.setBairro(rs.getString("Bairro"));
                tabela_clientes.setCidade(rs.getString("cidade"));
                tabela_clientes.setComplemento(rs.getString("Complemento"));
                
                tabelaclientes.add(tabela_clientes);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TabelaclientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return tabelaclientes;

    }
    
    public List<Tabelaclientes> readbusca(String cpf) {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Tabelaclientes> tabelaclientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tabelaclientes WHERE cpf LIKE ?");
            stmt.setString(1, "%"+cpf+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Tabelaclientes tabela_clientes = new Tabelaclientes();

                tabela_clientes.setNome(rs.getString("nome"));
                tabela_clientes.setIdclientes(rs.getInt("idclientes"));
                tabela_clientes.setCpf(rs.getString("cpf"));
                tabela_clientes.setCNPJ(rs.getString("CNPJ"));
                tabela_clientes.setRG(rs.getString("RG"));
                tabela_clientes.setCel(rs.getString("Cel"));
                tabela_clientes.setFixo(rs.getString("Fixo"));
                tabela_clientes.setEmail(rs.getString("email"));
                tabela_clientes.setRua(rs.getString("Rua"));
                tabela_clientes.setNumerocasa(rs.getInt("Numerocasa"));
                tabela_clientes.setCEP(rs.getString("CEP"));
                tabela_clientes.setBairro(rs.getString("Bairro"));
                tabela_clientes.setCidade(rs.getString("cidade"));
                tabela_clientes.setComplemento(rs.getString("Complemento"));
                
                tabelaclientes.add(tabela_clientes);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TabelaclientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return tabelaclientes;

    }
    
    public void readEditar(Tabelaclientes ce) {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM tabelaclientes WHERE idclientes = ?");
            stmt.setInt(1,ce.getIdclientes());
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {


                ce.setNome(rs.getString("nome"));
                ce.setIdclientes(rs.getInt("idclientes"));
                ce.setCpf(rs.getString("cpf"));
                ce.setCNPJ(rs.getString("CNPJ"));
                ce.setRG(rs.getString("RG"));
                ce.setCel(rs.getString("Cel"));
                ce.setFixo(rs.getString("Fixo"));
                ce.setEmail(rs.getString("email"));
                ce.setRua(rs.getString("Rua"));
                ce.setNumerocasa(rs.getInt("Numerocasa"));
                ce.setCEP(rs.getString("CEP"));
                ce.setBairro(rs.getString("Bairro"));
                ce.setCidade(rs.getString("cidade"));
                ce.setComplemento(rs.getString("Complemento"));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(TabelaclientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }
    
    public void Atualizar_cliente(Tabelaclientes c) throws SQLException {

      con = ConnectionFactory.getConnection();
       
      String sql = "UPDATE tabelaclientes SET nome = ?,cpf = ?,CNPJ = ?,RG = ?,Cel = ?,Fixo = ?,email = ?,Rua = ?,Numerocasa = ?,CEP = ?,Bairro = ?,cidade = ?,Complemento = ? WHERE idclientes = ?";
     
      try {

            stmt = con.prepareStatement(sql);
   

            stmt.setString(1,c.getNome());        
            stmt.setString(2,c.getCpf());
            stmt.setString(3,c.getCNPJ());
            stmt.setString(4,c.getRG());
            stmt.setString(5,c.getCel());
            stmt.setString(6,c.getFixo());
            stmt.setString(7,c.getEmail());
            stmt.setString(8,c.getRua());
            stmt.setInt(9,c.getNumerocasa());
            stmt.setString(10,c.getCEP());
            stmt.setString(11,c.getBairro());
            stmt.setString(12,c.getCidade());
            stmt.setString(13,c.getComplemento());
            stmt.setInt(14,c.getIdclientes());
      
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "erro ao salvar " + error);
            System.out.println(error);

        }
    
    }
    
    public void Deletar_cliente(Tabelaclientes c) throws SQLException {

      con = ConnectionFactory.getConnection();
     
      try {

          String sql = "DELETE FROM Tabelaclientes WHERE idclientes = ?";  
          stmt = con.prepareStatement(sql);
      
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
            

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Erro ao Excluir " + error);
            System.out.println(error);

        }
    
    }
}
    
    
    

    