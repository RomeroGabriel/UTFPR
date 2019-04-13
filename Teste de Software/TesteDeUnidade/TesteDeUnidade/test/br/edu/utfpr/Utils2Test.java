package br.edu.utfpr;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;

/**
 *
 * @author Aluno
 */
public class Utils2Test {
    
    char cadeia[];
    Utils utils;
    
    @Before
    public void before() {
        cadeia = new char[5];
        cadeia[0] = 'a';
        cadeia[1] = 'b';
        cadeia[2] = 'c';
        cadeia[3] = 'd';
        cadeia[4] = 'e';
        //{'a', 'b', 'c', 'd', 'e'};
        utils = new Utils();
    }
    
    @After
    public void after() {
        cadeia = null;
    }
    
    @Test
    public void testTamanhoInvalido() {
        String res = utils.acharCaracter(0, cadeia, 'b');
        assertEquals("comprimento invalido", res);
    }
    
    @Test
    public void testComprimentoDiferente() {
        String res = utils.acharCaracter(10, cadeia, 'b');
        assertEquals("comprimento fornecido diferente do comprimento real", res);
    }    
    
    @Test
    public void testEncontrarCaracterB() {
        String res = utils.acharCaracter(5, cadeia, 'b');
        assertEquals("1", res);
    }        
    
    @Ignore
    @Test
    public void testCaracterNaoEstaNaCadeia() {
        String res = utils.acharCaracter(5, cadeia, 'g');
        assertEquals("caracter nao encontrado", res);
    }    
}
