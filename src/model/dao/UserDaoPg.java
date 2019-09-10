/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import connection.ConnectionFactoryPost;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.beans.Usuario;

/**
 *
 * @author gabri
 */
public class UserDaoPg {
    
    public Boolean verifyLogin(JTextField j, JTextField o) {
        
        Connection con = ConnectionFactoryPost.getConnection();
         ResultSet rs = null;
         PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login LIKE ?");
             stmt.setString(1, j.getText());

            rs = stmt.executeQuery();
          
            while(rs.next()){
                  Usuario user = new Usuario();
                  user.setName(rs.getString("login"));
                  user.setSenha(rs.getString("pass"));
                  
                  return user.getName().equals(j.getText()) && user.getSenha().equals(o.getText());
            //return rs.getString("login").equals(j.getText()) && rs.getString("pass").equals(o.getText());
            
             }
           
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao fazer busca no Banco de dados");
        }
        
         return false;

        
        
        
        
        
    }
    
}
