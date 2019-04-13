/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import mathops.MathOps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class MathOpsTest {
    
    MathOps mo;
    
    public MathOpsTest() {
    }
    
    @Before
    public void before() {
        mo = new MathOps();
    }
    
    @After
    public void after() {
        mo = null;
    }
    
    @Test
    public void testFatorialZero() {
        assertEquals(1, mo.fatorial(0));
    }

    @Test
    public void testFatorialTres() {
        assertEquals(6, mo.fatorial(3));
    }

    @Test
    public void testFatorialNumeroNegativoLancaExcecao() {
        try {
            mo.fatorial(-10);
            fail("deve lancar excecao!");
        }
        catch(RuntimeException re) {
        }
    }

    @Test(expected = RuntimeException.class)
    public void testFatorialNumeroNegativoLancaExcecao2() {
        mo.fatorial(-10);
    }
    
    @Test(timeout = 2000)
    public void testTimeout() {
        while(true);
    }
    
    @Test
    public void testTresEhPrimo() {
        assertEquals(true, mo.ehPrimo(3));
        assertTrue( mo.ehPrimo(3) );
    }

    @Test
    public void testQuatroNaoEhPrimo() {
        assertFalse( mo.ehPrimo(4) );
    }
}
