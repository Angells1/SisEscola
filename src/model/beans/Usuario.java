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
public class Usuario {
    
    private String name;
    private String id;
    private String senha;
    private String nivelDeAcesso;

   /* public Usuario(String name, String id, String senha) {
        
        this.name = name;
        this.id = id;
        this.senha = senha;
    }*/

    public Usuario() {
        
    }

 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(String nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }
    
    
    
}
