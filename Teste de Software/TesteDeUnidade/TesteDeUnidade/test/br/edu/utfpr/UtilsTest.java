/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class UtilsTest {
    
    public UtilsTest() {
    }

    @Test
    public void testValorNegativo01() {
        Utils utils = new Utils();
        int res = utils.gerarNumeroAleatorio(-5, 10);
        assertEquals(-1, res);
    }
    
    @Test
    public void testValorNegativo02() {
        Utils utils = new Utils();
        int res = utils.gerarNumeroAleatorio(5, -10);
        assertEquals(-1, res);
    } 
    
    @Test
    public void testIntervaloValido() {
        Utils utils = new Utils();
        int res = utils.gerarNumeroAleatorio(5, 10);
        assertTrue( res >= 5 && res <= 10 );
    }
    
    @Test
    public void testDoisNumerosIguais() {
        Utils utils = new Utils();
        int res = utils.gerarNumeroAleatorio(5, 5);
        assertEquals(-1, res);
    }    
    
    @Test
    public void testInicioMaiorQueFim() {
        Utils utils = new Utils();
        int res = utils.gerarNumeroAleatorio(10, 5);
        assertEquals(-1, res);
    }    
}
