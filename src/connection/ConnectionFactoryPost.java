/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class ConnectionFactoryPost {
    //jdbc:postgresql:
    private static final String URL = "jdbc:postgresql://192.168.15.6:5432/dbescola";
 private static final String USER = "postgres";
    private static final String PASS =  "admin";
    private static final String DRIVER = "org.postgresql.Driver";
     
     

        public static Connection getConnection(){
        
        try {
            Class.forName(DRIVER);
            Connection con = null;
            
          
         
          return DriverManager.getConnection(URL, USER, PASS);
                    
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.print("Erro");
             JOptionPane.showMessageDialog(null, "Erro ao fazer busca no Banco de dados");
            throw new RuntimeException("Erro na conexao: ", ex);
           
        }
    
}
    
      public static void closeConnection(Connection con){
            
            
            
            try {
                
            if(con != null){
                
                    con.close();
                    
                    }
            
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        
        
        public static void closeConnection(Connection con, PreparedStatement stmt){
            
            closeConnection(con);
            
                 try {
                
            if(stmt != null){
                
                    stmt.close();
                    
                    }
            
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
         public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
            
            closeConnection(con, stmt);
            
                 try {
                
            if(rs != null){
                
                    rs.close();
                    
                    }
            
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
    
    
    
}
