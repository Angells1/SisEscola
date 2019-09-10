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
 * @author Gabriel 2
 */
public class ConnectionFactory {

  // 
    public ResultSet rs;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.15.6/dbescola";
    private static final String USER = "root";
    private static final String PASS =  "123";
    
    public static Connection getConnection(){
        
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
                    
        } catch (ClassNotFoundException | SQLException ex) {
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
         
         public void executaSql(String sql){
             
             try{
                 
                 Statement stm;
                 Connection con = null;
                 stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
                 rs = stm.executeQuery(sql);
         
             }catch(SQLException ex){
                 
                 JOptionPane.showMessageDialog(null,"erro ExecutaSql:\n"+ex.getMessage());
                 
                 
             }
             
             
         }
        
        
        
        
            
        }
        
        
    

