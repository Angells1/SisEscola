/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.sql.Date;

/**
 *
 * @author Gabriel 2
 */
public class Professor extends Pessoa {
    
    private String cad;
    private String disciplina;
    
    
    

   /* public Professor(String name, String nascimento, String sexo, String nacionalidade, String vinculo, String cad, String disciplina ) {
        super(name, nascimento, sexo, nacionalidade, vinculo);
        
        this.cad = cad;
        this.disciplina = disciplina;
    }*/

    public String getCad() {
        return cad;
    }

    public void setCad(String cad) {
        this.cad = cad;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    
    
    
}
