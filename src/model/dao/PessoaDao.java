/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import model.beans.Pessoa;


/**
 *
 * @author Gabriel 2
 */
public class PessoaDao {
    
    public void create(Pessoa p) throws ParseException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
             stmt = con.prepareStatement("INSERT INTO pessoas (name,nascimento,sexo,nacionalidade,vinculo)VALUES (?,?,?,?,?)");
             stmt.setString(1, p.getName());
             
            stmt.setString(2, p.getNascimento());

             stmt.setString(3, p.getSexo());
             stmt.setString(4, p.getCpf());
             stmt.setString(5, p.getVinculo());
             
             stmt.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
             
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }
        finally
        {
     
            ConnectionFactory.closeConnection(con, stmt);
          
        }
        
        
    }
    
}
