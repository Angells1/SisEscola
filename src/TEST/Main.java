/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.beans.Aluno;
import model.dao.AlunoDao;
import model.dao.AlunoDaoPg;

/**
 *
 * @author gabri
 */
public class Main {
    
    public static void main (String[] args){
        
        
        Aluno po = new Aluno();
        
        //po.setMatricula("2515415");
        po.setName("Lucas");
        po.setNascimento("12/08/2000");
        po.setSexo("M");
        po.setCpf("02558534165");
        po.setVinculo("A");
        //po.setSerie(1);
        
        AlunoDaoPg dao = new AlunoDaoPg();
        
        try {
            dao.create(po);
           
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
