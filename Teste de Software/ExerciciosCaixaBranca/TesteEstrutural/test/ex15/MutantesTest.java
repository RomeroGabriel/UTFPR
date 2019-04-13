/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex15;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class MutantesTest {
    
    @Test
    public void testM1() {
        int ano [] = {2004};
        Original o = new Original();
        assertEquals(1, o.calcularAnosBissexto(ano));
        
        Mutante1 m = new Mutante1();
        assertEquals(1, m.calcularAnosBissexto(ano));
    }
    
    @Test
    public void testM2() {
        int ano [] = {300};
        Original o = new Original();
        assertEquals(0, o.calcularAnosBissexto(ano));
        
        Mutante2 m = new Mutante2();
        assertEquals(0, m.calcularAnosBissexto(ano));
    
    }

    @Test
    public void testM3() {
        int ano [] = {200};
        Original o = new Original();
        assertEquals(0, o.calcularAnosBissexto(ano));

        Mutante3 m = new Mutante3();
        assertEquals(0, m.calcularAnosBissexto(ano));        
    }
    
}
