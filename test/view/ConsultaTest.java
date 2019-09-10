/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabri
 */
public class ConsultaTest {
    
    public ConsultaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Consulta.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Consulta.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readJtablePg method, of class Consulta.
     */
    @Test
    public void testReadJtablePg() throws Exception {
        System.out.println("readJtablePg");
        Consulta instance = new Consulta();
        instance.readJtablePg();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exibeImg method, of class Consulta.
     */
    @Test
    public void testExibeImg() throws Exception {
        System.out.println("exibeImg");
        Consulta instance = new Consulta();
        instance.exibeImg();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchJtablePg method, of class Consulta.
     */
    @Test
    public void testSearchJtablePg() throws Exception {
        System.out.println("searchJtablePg");
        String search = "";
        Consulta instance = new Consulta();
        instance.searchJtablePg(search);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alinhaTableCentro method, of class Consulta.
     */
    @Test
    public void testAlinhaTableCentro() {
        System.out.println("alinhaTableCentro");
        JTable table = null;
        int[] posicoesDireita = null;
        Consulta.alinhaTableCentro(table, posicoesDireita);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
