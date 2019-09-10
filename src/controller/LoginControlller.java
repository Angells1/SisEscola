/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.helper.LoginHelper;
import model.beans.Usuario;
import view.CadastroProfessor;
import view.Login;

/**
 *
 * @author gabri
 */
public class LoginControlller {

    private final Login view;
    private LoginHelper helper;
    
    public LoginControlller(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void fizTarefa(){
        
        
        
         System.out.println("Busquei algo no banco de dados");
        this.view.exibeMensagem("Executei o fiz tarefa");
             
    }
    
    public void entrarNoSistema(){
        
        //Pegar view do usuario
    
         
        
    }
    
    
}
