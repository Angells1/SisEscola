
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import model.beans.Aluno;

/**
 *
 * @author gabri
 */
public class AlunoDao {
    
       public void create(Aluno p) throws ParseException, Exception{
        
         Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
             stmt = con.prepareStatement("INSERT INTO aluno (nome,dataNascimento,sexo,nacionalidade,vinculo,matricula,serie)VALUES(?,?,?,?,?,?,?)");
             
             stmt.setString(1, p.getName());
             
             
             
             java.sql.Date data = Aluno.formataData(p.getNascimento());
             
             stmt.setDate(2, data);
             stmt.setString(3, p.getSexo());
             stmt.setString(4, p.getCpf());
             stmt.setString(5, p.getVinculo());
             stmt.setString(6, p.getMatricula());
             stmt.setInt(7, p.getSerie());
                     
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
       
       public void delete (Aluno p) throws ParseException, Exception{
           
        Connection con = ConnectionFactory.getConnection();
         
           Statement stmt = con.createStatement();
       
        try{
           stmt.executeQuery("DELETE FROM aluno ="+p.getName()+";");
           
           JOptionPane.showMessageDialog(null, "Aluno excluido");
           
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao excluir");
        }finally{
            
            ConnectionFactory.closeConnection(con);
             
            
        }
        
           
           
       }
    
    
       
       public List<Aluno> read(){
           
           Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
           ResultSet rs = null;
           List <Aluno> alunos = new ArrayList<>();
           
           
           try {
               stmt = con.prepareStatement("SELECT * FROM aluno");
               rs = stmt.executeQuery();
               
               while(rs.next()){
                   
                  Aluno aluno = new Aluno();
                  aluno.setId(rs.getInt("ID"));
                   aluno.setName(rs.getString("nome"));
                   
                  
                       
                  
                   try {
                       String data;
                       data = Aluno.formataString(rs.getDate("dataNascimento"));
                       aluno.setNascimento(data);
                       
                   } catch (Exception ex) {
                       Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
                   }

                       
                       aluno.setSexo(rs.getString("sexo"));
                       aluno.setCpf(rs.getString("cpf"));
                       aluno.setVinculo(rs.getString("vinculo"));
                       aluno.setMatricula(rs.getString("matricula"));
                       aluno.setSerie(rs.getInt("serie"));
                        alunos.add(aluno);
                       
                  
               }
               
                       } catch (SQLException ex) {
               Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
           }finally{
               
               ConnectionFactory.closeConnection(con, stmt, rs);
               
           }
           
           return alunos;
       }
       
       public List<Aluno> search(String nome){
           
           Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
           ResultSet rs = null;
           List <Aluno> alunos = new ArrayList<>();
           
           try {
               stmt = con.prepareStatement("SELECT * FROM aluno WHERE nome LIKE ?"); //like busca palavra digitada no inicio ou no final da palavra no DB
               stmt.setString(1, "%"+nome+"%");
               rs = stmt.executeQuery();
            
               while(rs.next()){
               
           Aluno a = new Aluno();
                 a.setId(rs.getInt("ID"));
                   a.setName(rs.getString("nome"));
                   
                   try {
                       String data;
                       data = Aluno.formataString(rs.getDate("dataNascimento"));
                       a.setNascimento(data);
                       
                   } catch (Exception ex) {
                       Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
                   }

                       a.setSexo(rs.getString("sexo"));
                       a.setCpf(rs.getString("cpf"));
                       a.setVinculo(rs.getString("vinculo"));
                       a.setMatricula(rs.getString("matricula"));
                       a.setSerie(rs.getInt("serie"));
                                      alunos.add(a);

                   
               }
               
                       } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Erro no banco de dados");
           }finally{
               
               ConnectionFactory.closeConnection(con, stmt, rs);
               
           }
           
           return alunos;
       }
       
       
       
}
