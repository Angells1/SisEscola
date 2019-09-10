/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Gabriel 2
 */
public abstract class  Pessoa {
    
    
    
    private String name;
    private String nascimento;
    private String sexo;  
   private String cpf;
    private String vinculo;
    private int id;
    private int idimg;
    private byte[] img;

    public int getIdimg() {
        return idimg;
    }

    public void setIdimg(int idimg) {
        this.idimg = idimg;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

 




    
    
    
    public Pessoa(){
        
        
    }
    /*public Pessoa(String name, String nascimento, String sexo, String nacionalidade, String vinculo) {
        this.name = name;
   
     
        this.sexo = sexo;
        this.nacionalidade = nacionalidade;
        this.vinculo = vinculo;
        
          this.sexo = String.format("%c", 'M', 'F');
        this.vinculo = String.format("%c", 'A', 'P', 'D');
    }*/


    
   
    
        
        
    
    
    
    public String getName(){
    
    return name;
    
}
    
    public void setName(String outro){
        
        this.name = outro; 
       
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    


    
 
    

    
    public String getNascimento(){
    
    return nascimento;
    
}
    
    public void setNascimento(String outro){
        
        this.nascimento = outro; 
       
    }
    
          public String getVinculo(){
    
    return vinculo;
    
}
    
    public void setVinculo(String outro){
        
        this.vinculo = outro; 
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
 
  public static java.sql.Date formataData(String data) throws Exception { 
 		if (data == null || data.equals("")) return null;
                
         java.sql.Date date = null;
         try {
             DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
             date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );
         } catch (ParseException e) {            
             throw e;
         }
         return date;
 	}
  public static java.sql.Date formataDataPg(String data) throws Exception { 
 		if (data == null || data.equals(""))
 			return null;
 		
              
         java.sql.Date date = null;
         try {
             DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
             date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );
         } catch (ParseException e) {            
             throw e;
         }
         return date;
 	}
  
  public static String formataString(Date data) throws Exception { 
 		
      String date = null;
      
      DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       return date = df.format(data);
      
      
      
 	}
  
 
}
             
             
 	
    
    
    

