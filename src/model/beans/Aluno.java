/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;


/**
 *
 * @author Gabriel 2
 */
public class Aluno extends Pessoa {
    
    
    private String matricula;
    private int serie;

   
    
    public Aluno(){
        
        
    }
     
    /*public Aluno(String matricula, int serie, String name, String nascimento, String sexo, String nacionalidade, String vinculo)
    {
        super(name, nascimento, sexo, nacionalidade, vinculo);
        this.matricula = matricula;
        this.serie = serie;
      
    }*/
  
    
//    

    public String getMatricula() {
        return matricula;
    }

    public int getSerie() {
        return serie;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }
    
    
    
    
    
    
    
    

    
    
}
