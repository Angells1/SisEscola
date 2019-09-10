/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helper;

import model.beans.Usuario;
import view.Login;

/**
 *
 * @author gabri
 */
public class LoginHelper {
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    
    
    public void setarModelo(Usuario user){
        
       String nome = user.getName();
        String senha = user.getSenha();
        
        view.getTextUsuario().setText(nome);
        view.getTextSenha().setText(senha);
    }
    
    public void limparTela(){
        
        view.getTextUsuario().setText("");
        view.getTextSenha().setText("");
        
        
    }
    
    
    
    
    
}
