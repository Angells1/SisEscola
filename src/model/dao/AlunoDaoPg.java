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
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.beans.Aluno;
import model.beans.Pessoa;
import model.beans.Professor;

/**
 *
 * @author gabri
 */
public class AlunoDaoPg {
    
    public void create (Aluno p) throws Exception{
 Connection con = ConnectionFactoryPost.getConnection();
    PreparedStatement stmt = null;
    
    try{
        
    
        stmt = con.prepareStatement("INSERT INTO aluno (nome,datanasc,cpf,sexo,vinculo,matricula,serie,img) values(?,?,?,?,?,?,?,?)");
        stmt.setString(1, p.getName());

       java.sql.Date data = Aluno.formataData(p.getNascimento());

            stmt.setDate(2, data);
        stmt.setString(3, p.getCpf());
        stmt.setString(4, p.getSexo());
        stmt.setString(5, p.getVinculo());
        stmt.setString(6, p.getMatricula());
        stmt.setInt(7, p.getSerie());
        
        try{
        stmt.setBytes(8, p.getImg());
        }catch (SQLException ex){
              JOptionPane.showMessageDialog(null, "Erro ao salvar imagem");
            
        }
         stmt.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
             
        
    }catch(SQLException ex){
        
        JOptionPane.showMessageDialog(null, "Erro ao salvar");
    }finally{
        
          ConnectionFactoryPost.closeConnection(con, stmt);
    }
    
}
    
   
    
    
      public List<Aluno> read(){
           
           Connection con = ConnectionFactoryPost.getConnection();
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
                       data = Aluno.formataString(rs.getDate("datanasc"));
                       aluno.setNascimento(data);
                       
                   } catch (Exception ex) {
                       Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
                   }

                         aluno.setCpf(rs.getString("cpf"));
                       aluno.setSexo(rs.getString("sexo"));
                     
                       aluno.setVinculo(rs.getString("vinculo"));
                       aluno.setMatricula(rs.getString("matricula"));
                       aluno.setSerie(rs.getInt("serie"));
                       aluno.setImg(rs.getBytes("img"));
                        alunos.add(aluno);
    

                  
               }
               
                       } catch (SQLException ex) {
               Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
           }finally{
               
               ConnectionFactoryPost.closeConnection(con, stmt, rs);
               
           }
           
           return alunos;
       }
            public List<Professor> readp(){
           
           Connection con = ConnectionFactoryPost.getConnection();
            PreparedStatement stmt = null;
           ResultSet rs = null;
           List <Professor> profs = new ArrayList<>();


            
           
           try {
               stmt = con.prepareStatement("SELECT * FROM aluno");
               rs = stmt.executeQuery();
               
               while(rs.next()){
                   
               
                      
                      
                      Professor prof = new Professor();
                  
                  prof.setId(rs.getInt("ID"));
                   prof.setName(rs.getString("nome"));
                   
                  
                       
                  
                   try {
                       String data;
                       data = Aluno.formataString(rs.getDate("datanasc"));
                       prof.setNascimento(data);
                       
                   } catch (Exception ex) {
                       Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
                   }

                         prof.setCpf(rs.getString("cpf"));
                       prof.setSexo(rs.getString("sexo"));
                     
                       prof.setVinculo(rs.getString("vinculo"));
                       prof.setDisciplina(rs.getString("matricula"));
                       prof.setCad(rs.getString("cad"));
                       profs.add(prof);
    

                  
               }
               
                       } catch (SQLException ex) {
               Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
           }finally{
               
               ConnectionFactoryPost.closeConnection(con, stmt, rs);
               
           }
           
           return profs;
       }

      
      
      
      
       public List<Aluno> search(String nome) throws Exception{
           
           Connection con = ConnectionFactoryPost.getConnection();
            PreparedStatement stmt = null;
  
           ResultSet rs = null;

           List <Aluno> al = new ArrayList<>();
     
           
           try {
               
               stmt = con.prepareStatement("SELECT * FROM aluno WHERE lower(nome) LIKE ?"); //like busca palavra digitada no inicio ou no final da palavra no DB

               stmt.setString(1, "%"+nome.toLowerCase()+"%");

               rs = stmt.executeQuery();

          
                 
               while(rs.next()){

           Aluno a = new Aluno();
          
                 a.setId(rs.getInt("ID"));
                   a.setName(rs.getString("nome"));
                   
                   try {
                       String data;
                       data = Aluno.formataString(rs.getDate("datanasc"));
                       a.setNascimento(data);
                       
                   } catch (Exception ex) {
                       Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
                   }
                        a.setCpf(rs.getString("cpf"));
                       a.setSexo(rs.getString("sexo"));
                      
                       a.setVinculo(rs.getString("vinculo"));
                       a.setMatricula(rs.getString("matricula"));
                       a.setSerie(rs.getInt("serie"));
                                      
                                     al.add(a);
  
               }
               
                       } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Erro no banco de dados");
           }finally{
               
               ConnectionFactoryPost.closeConnection(con, stmt, rs);
               
           }
           
           return al;
       }
             public byte[] searchimg(String nome) throws Exception{
           
           Connection con = ConnectionFactoryPost.getConnection();
            PreparedStatement stmt = null;
  
           ResultSet rs = null;


                  byte[] imag = null;
           try {
               
               stmt = con.prepareStatement("SELECT * FROM aluno WHERE lower(nome) LIKE ?"); //like busca palavra digitada no inicio ou no final da palavra no DB

               stmt.setString(1, "%"+nome.toLowerCase()+"%");

               rs = stmt.executeQuery();

          
                 
               while(rs.next()){

            imag = rs.getBytes("img");

               }
               
                       } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Erro no banco de dados");
           }finally{
               
               ConnectionFactoryPost.closeConnection(con, stmt, rs);
               
           }
           
           return imag ;
       }
       
          public void delete (Aluno p) throws ParseException, Exception{
           
        Connection con = ConnectionFactoryPost.getConnection();
         
           PreparedStatement stmt = null;
       
        try{
            
           //stmt = con.prepareStatement("DELETE FROM aluno(ID,nome,datanasc,cpf,sexo,vinculo) VALUES(+,+,+,+,+,+)");
           stmt = con.prepareStatement("DELETE FROM aluno WHERE nome = ?");
           stmt.setString(1, p.getName());
           //stmt.setString(2, p.getName());
           
          //java.sql.Date data = Aluno.formataData(p.getNascimento());
           
          // stmt.setDate(3, data);
         //  stmt.setString(4, p.getCpf());
           //stmt.setString(5, p.getSexo());
          // stmt.setString(5, p.getVinculo());
          // stmt.setString(6, p.getMatricula());
          stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Aluno excluido");
           
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao excluir");
        }finally{
            
            ConnectionFactoryPost.closeConnection(con,stmt);
             
            
        }
        
           
           
       }
    
     
    
    
    
    
}