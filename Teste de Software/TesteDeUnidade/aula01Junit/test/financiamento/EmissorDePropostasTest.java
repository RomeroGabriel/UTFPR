/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiamento;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class EmissorDePropostasTest {
    
    public EmissorDePropostasTest() {
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

    @Test
    public void faixaInferiorA1000reaisTest() {
        Cliente c = new Cliente();
        c.setNome("Joao da Silva");
        c.setSalario(900.00f);
        c.setIdade(25);
        c.setValorAserFinanciado(2000.00f);
        
        EmissorDePropostas ep = new EmissorDePropostas();
        ArrayList<Proposta> propostas = 
                                    ep.definirPropostas(c);
        
        assertEquals(2, propostas.size());
        Proposta p1 = propostas.get(0);
        assertEquals(4000.00f, p1.getTotal(), 0.001);
        assertEquals(2, p1.getNumeroParcelas());
        assertEquals(2000.00f, p1.getValorDaParcela(), 0.001);
        
        Proposta p2 = propostas.get(1);
        assertEquals(4000.00f, p2.getTotal(), 0.001);
        assertEquals(3, p2.getNumeroParcelas());
        assertEquals(1333.33f, p2.getValorDaParcela(), 0.01);        
    }
}
