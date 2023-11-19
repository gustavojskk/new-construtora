package model.dao;

import connection.ConnectionFactory;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Materiais;


public class MaterialDAO {
    
    PreparedStatement stmt;
    Connection con;
    ResultSet rst;
    public void Cadastrar_materiais(Materiais m) throws SQLException {

      con = ConnectionFactory.getConnection();
       
      String sql = "INSERT INTO Materiais (produto, preco, quantidade, loja, cidade, bairro ) values (?,?,?,?,?,?)";
     
      try {

            stmt = con.prepareStatement(sql);
   

            stmt.setString(1,m.getProduto());        
            stmt.setInt(2,m.getPreco());
            stmt.setString(3,m.getQuantidade());
            stmt.setString(4,m.getLoja());
            stmt.setString(5,m.getCidade());
            stmt.setString(6,m.getBairro());
      
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "erro ao salvar " + error);
            System.out.println(error);

        }
    
    }

    public void CadastrarMateriais(Materiais m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}



