/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import model.beans.Aluno;
import model.beans.Professor;

import model.dao.AlunoDaoPg;
import model.dao.ProfessorDaoPg;
import view.CadastroProfessor;
import view.ManipularImagem;

/**
 *
 * @author gabri
 */
public class CadastroControllerPg {
    
    public void cadastrarAluno(CadastroProfessor l, BufferedImage imagem){
        
        
        Aluno a =  new Aluno();
     
         AlunoDaoPg dao = new AlunoDaoPg();
        
         a.setName(l.getCadastroNome().getText());
           a.setSexo(l.getSexoComboBox().getSelectedItem()+"");
           a.setVinculo(l.getVinculComboBox().getSelectedItem()+"");
           a.setSerie(Integer.parseInt(l.getSerieComboBox().getSelectedItem()+""));
             
             a.setCpf(l.getCadastroCpf().getText());
         a.setMatricula(l.getCadastroMatricula().getText());
         
                String day = l.getDayCB().getSelectedItem()+"";
          String month = l.getMonthCB().getSelectedItem()+"";
          String year = l.getYearCB().getSelectedItem()+"";
         
         String date = day+"/"+month+"/"+year;
      a.setNascimento(date);
      a.setImg(ManipularImagem.getImgBytes(imagem));
         
        try {
            dao.create(a);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }
        
        l.limparTelaAluno();
        
        
    }
    
       public void cadastrarProf(CadastroProfessor l){
        
        
       Professor a =  new Professor();
     
         ProfessorDaoPg dao = new ProfessorDaoPg();
        
         a.setName(l.getCadastroNome().getText());
           a.setSexo(l.getSexoComboBox().getSelectedItem()+"");
           a.setVinculo(l.getVinculComboBox().getSelectedItem()+"");
         
             
             a.setCpf(l.getCadastroCpf().getText());
               a.setDisciplina(l.getCadastroDisciplina().getText());
              a.setCad(l.getCadastroCad().getText());
                String day = l.getDayCB().getSelectedItem()+"";
          String month = l.getMonthCB().getSelectedItem()+"";
          String year = l.getYearCB().getSelectedItem()+"";
         
         String date = day+"/"+month+"/"+year;
      a.setNascimento(date);
         
        try {
            dao.create(a);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }
        
        l.limparTelaAluno();
        
        
    }
    
}
