/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.beans.Aluno;
import model.dao.AlunoDao;
import view.CadastroProfessor;

/**
 *
 * @author gabri
 */
public class CadastroController {
    
    
    public void cadastrarAluno(CadastroProfessor l){
        
        
        Aluno a =  new Aluno();
     
         AlunoDao dao = new AlunoDao();
        
         a.setName(l.getCadastroNome().getText());
           a.setSexo(l.getSexoComboBox().getSelectedItem()+"");
           a.setVinculo(l.getVinculComboBox().getSelectedItem()+"");
            a.setSerie(Integer.parseInt(l.getSerieComboBox().getSelectedItem()+""));
           
             a.setCpf((String) l.getCadastroCpf().getText());
          a.setMatricula(l.getCadastroMatricula().getText());
          
   
          
        try {
            dao.create(a);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }
        
        l.limparTelaAluno();
        
        
    }
    
}
