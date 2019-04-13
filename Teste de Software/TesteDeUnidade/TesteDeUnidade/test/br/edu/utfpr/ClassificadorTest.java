package br.edu.utfpr;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class ClassificadorTest {
    
    public ClassificadorTest() {
    }

    @Test
    public void testIdadeInvalida01() {
        Pessoa p = new Pessoa("Arnold Terminator", -10);
        
        Classificador c = new Classificador();
        try {
            String res = c.definirFaixaEtaria(p);
            fail("nao deve chegar aqui");
        }catch(IllegalArgumentException e){
            assertEquals("idade invalida", e.getMessage());
        }
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIdadeInvalida02() {
        Pessoa p = new Pessoa("Arnold Terminator", -10);
        
        Classificador c = new Classificador();
        String res = c.definirFaixaEtaria(p);
    }    
    
    @Test(timeout = 1000)
    public void testTimeout() {
        int a = 10;
        while(a > -1) {
            a = 10;
        }
    }
}
