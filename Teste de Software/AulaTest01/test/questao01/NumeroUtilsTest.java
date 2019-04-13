package questao01;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import questao01.NumeroUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class NumeroUtilsTest {
    
    public NumeroUtilsTest() {
    }

    @Test
    public void testNumerosNegativosSendoXMaior() {
        NumeroUtils nu = new NumeroUtils();
        int res = nu.maior(-10, -20);
        assertEquals(-10, res);
    }
    
    @Test
    public void testNumerosPositivosSendoYMaior() {
        NumeroUtils nu = new NumeroUtils();
        int res = nu.maior(1, 2);
        assertEquals(2, res);
    }

    @Test
    public void testNumerosPositivosSendoXMaior() {
        NumeroUtils nu = new NumeroUtils();
        int res = nu.maior(5, 4);
        assertEquals(5, res);
    }

    @Test
    public void testUmInteiroValido() {
        NumeroUtils nu = new NumeroUtils();
        boolean res = nu.ehInteiroValido("123");
        assertEquals(true, res);
        assertTrue(res);
    }
    
    @Test
    public void testUmaLetraInvalida() {
        NumeroUtils nu = new NumeroUtils();
        boolean res = nu.ehInteiroValido("a");
        assertEquals(false, res);
        assertFalse(res);
    }    

    @Test
    public void testCaracteresInvalidos() {
        NumeroUtils nu = new NumeroUtils();
        boolean res = nu.ehInteiroValido("fgjwpa0t8i45434lksk#4$#d");
        assertEquals(false, res);
        assertFalse(res);
    }    
}
