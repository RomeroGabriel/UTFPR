/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void casoTesteCV() {
        Caracteres car = new Caracteres();
        String res = car.getPosicao(7, "abcdefg", 'c');
        assertEquals("3", res);
    }
    
    @Test
    public void casoTesteCI01() {
        Caracteres car = new Caracteres();
        String res = car.getPosicao(-20, "abcdefg", 'c');
        assertEquals("erro", res);
    }

    @Test
    public void casoTesteCI02() {
        Caracteres car = new Caracteres();
        String res = car.getPosicao(35, "abcdefg", 'c');
        assertEquals("erro", res);
    }

    @Test
    public void casoTesteCI03() {
        Caracteres car = new Caracteres();
        String res = car.getPosicao(7, "abc", 'c');
        assertEquals("erro", res);
    }

    @Test
    public void casoTesteCI04() {
        Caracteres car = new Caracteres();
        String res = car.getPosicao(7, "abcdefgh", 'c');
        assertEquals("erro", res);
    }

    @Test
    public void casoTesteCI05() {
        Caracteres car = new Caracteres();
        String res = car.getPosicao(7, "abcdefg", 'y');
        assertEquals("nao contem", res);
    }    
}
