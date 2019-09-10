/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactoryPost;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.beans.Aluno;
import model.beans.Professor;

/**
 *
 * @author gabri
 */
public class ProfessorDaoPg {
    
       public void create (Professor p) throws Exception{
 Connection con = ConnectionFactoryPost.getConnection();
    PreparedStatement stmt = null;
    
    try{
        
    
        stmt = con.prepareStatement("INSERT INTO professor (nome,datanasc,cpf,sexo,vinculo,disciplina,cad,img) values(?,?,?,?,?,?,?,?)");
        stmt.setString(1, p.getName());

       java.sql.Date data = Aluno.formataData(p.getNascimento());

            stmt.setDate(2, data);
        stmt.setString(3, p.getCpf());
        stmt.setString(4, p.getSexo());
        stmt.setString(5, p.getVinculo());
        stmt.setString(6, p.getDisciplina());
        stmt.setString(7, p.getCad());
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
       public List<Professor> read(){
           
           Connection con = ConnectionFactoryPost.getConnection();
            PreparedStatement stmt = null;
           ResultSet rs = null;
           List <Professor> professor = new ArrayList<>();


            
           
           try {
               stmt = con.prepareStatement("SELECT * FROM professor");
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
                       prof.setDisciplina(rs.getString("disciplina"));
                       prof.setCad(rs.getString("cad"));
                            prof.setImg(rs.getBytes("img"));
                        professor.add(prof);
    

                  
               }
               
                       } catch (SQLException ex) {
               Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
           }finally{
               
               ConnectionFactoryPost.closeConnection(con, stmt, rs);
               
           }
           
           return professor;
       }
       
        public void delete (Professor p) throws ParseException, Exception{
           
        Connection con = ConnectionFactoryPost.getConnection();
         
           PreparedStatement stmt = null;
       
        try{
            
           //stmt = con.prepareStatement("DELETE FROM aluno(ID,nome,datanasc,cpf,sexo,vinculo) VALUES(+,+,+,+,+,+)");
           stmt = con.prepareStatement("DELETE FROM professor WHERE nome = ?");
           stmt.setString(1, p.getName());
           //stmt.setString(2, p.getName());
           
          //java.sql.Date data = Aluno.formataData(p.getNascimento());
           
          // stmt.setDate(3, data);
         //  stmt.setString(4, p.getCpf());
           //stmt.setString(5, p.getSexo());
          // stmt.setString(5, p.getVinculo());
          // stmt.setString(6, p.getMatricula());
          stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Professor excluido");
           
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao excluir");
        }finally{
            
            ConnectionFactoryPost.closeConnection(con,stmt);
             
            
        }
        
           
           
       }
        
           public List<Professor> search(String nome) throws Exception{
           
           Connection con = ConnectionFactoryPost.getConnection();
            PreparedStatement stmt = null;
           ResultSet rs = null;
           List <Professor> prof = new ArrayList<>();
     
           
           try {
               
               stmt = con.prepareStatement("SELECT * FROM professor WHERE lower(nome) LIKE ?"); //like busca palavra digitada no inicio ou no final da palavra no DB

               stmt.setString(1, "%"+nome.toLowerCase()+"%");
       
               rs = stmt.executeQuery();

          
                 
               while(rs.next()){

           Professor a = new Professor();
          
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
                       a.setDisciplina(rs.getString("disciplina"));
                       a.setCad(rs.getString("cad"));
                                            a.setImg(rs.getBytes("img"));
                                     prof.add(a);
  
               }
               
                       } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Erro no banco de dados");
           }finally{
               
               ConnectionFactoryPost.closeConnection(con, stmt, rs);
               
           }
           
           return prof;
       }
        
        
       
       
    
}
