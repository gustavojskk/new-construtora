package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Fornecedores;


public class FornecedoresDAO {
    
    PreparedStatement stmt;
    Connection con;
    ResultSet rst;

    public void Fornecedores(Fornecedores f) throws SQLException {

      con = ConnectionFactory.getConnection();
       
      String sql = "INSERT INTO fornecedores (empresa_nome,cidade,bairro,email,telefone,celular) values (?,?,?,?,?,?)";
     
      try {

            stmt = con.prepareStatement(sql);
   

            stmt.setString(1,f.getEmpresa_nome());        
            stmt.setString(2,f.getCidade());
            stmt.setString(3,f.getBairro());
            stmt.setString(4,f.getEmail());
            stmt.setString(5,f.getCelular());
            stmt.setString(6,f.getTelefone());
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "erro ao salvar " + error);
            System.out.println(error);

        }
    
    }
    
}
