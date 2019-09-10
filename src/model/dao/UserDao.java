/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.beans.Usuario;
import view.CadastroProfessor;

/**
 *
 * @author gabri
 */
public class UserDao {
    
    public Boolean verifyLogin(JTextField j, JTextField o) {
        
        Connection con = ConnectionFactory.getConnection();
         ResultSet rs = null;
         PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            while(rs.next()){
                
            return rs.getString("login").equals(j.getText()) && rs.getString("senha").equals(o.getText());
            
             }
           
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao fazer busca no Banco de dados");
        }
        
         return false;

        
        
        
        
        
    }
    

}
