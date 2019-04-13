/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import triangulo.Triangulo;

/**
 *
 * @author Aluno
 */
public class TrianguloTest {
    
    public TrianguloTest() {
    }

    @Test
    public void testConstrutor() {
        Triangulo t = new Triangulo(3, 4, 5);
        assertEquals(3, t.getA());
        assertEquals(4, t.getB());
        assertEquals(5, t.getC());
    }
    
    @Test
    public void testEscalenoValido() {
        Triangulo t = new Triangulo(3, 4, 5);
        String res = t.qualTriangulo();
        assertTrue(res.equals("escaleno"));
    }
    
    @Test
    public void testIsoscelesValido() {
        Triangulo t = new Triangulo(3, 4, 4);
        String res = t.qualTriangulo();
        assertTrue(res.equals("isosceles"));
        
        t = new Triangulo(4, 3, 4);
        res = t.qualTriangulo();
        assertTrue(res.equals("isosceles"));

        t = new Triangulo(4, 4, 3);
        res = t.qualTriangulo();
        assertTrue(res.equals("isosceles"));        
    }    
    
    @Test
    public void testEquilateroValido() {
        Triangulo t = new Triangulo(1, 1, 1);
        String res = t.qualTriangulo();
        assertTrue(res.equals("equilatero"));
    }    
    
    @Test
    public void testTrianguloInvalidoComZero() {
        Triangulo t = new Triangulo(1, 1, 0);
        String res = t.qualTriangulo();
        assertTrue(res.equals("erro"));
    }  
    
    @Test
    public void testTrianguloInvalidoNegativo() {
        Triangulo t = new Triangulo(-1, -1, 10);
        String res = t.qualTriangulo();
        assertTrue(res.equals("erro"));
    }  

    @Test
    public void testTrianguloInvalidoComTodosPositivos() {
        Triangulo t = new Triangulo(1, 1, 10);
        String res = t.qualTriangulo();
        assertTrue(res.equals("erro"));
    }  
    
}
