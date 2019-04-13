/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex17;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
    }

    @Test
    public void testCB1() {
        Calculadora c = new Calculadora();
        Salario s = c.calcularSalario("assalariado40h", 0);
        assertEquals(4000, s.getValorSalario());
        assertEquals("", s.getPendencia());
    }
    
    @Test
    public void testCB2() {
        Calculadora c = new Calculadora();
        Salario s = c.calcularSalario("assalariado20h", 0);
        assertEquals(1500, s.getValorSalario());
        assertEquals("", s.getPendencia());
    } 
    
    @Test
    public void testCB3() {
        Calculadora c = new Calculadora();
        Salario s = c.calcularSalario("horista", 40);
        assertEquals(40 * 15, s.getValorSalario());
        assertEquals("", s.getPendencia());
    } 
    
    @Test
    public void testCB4() {
        Calculadora c = new Calculadora();
        Salario s = c.calcularSalario("horista", 30);
        assertEquals(30 * 15, s.getValorSalario());
        assertEquals("relatorio de ausencia", s.getPendencia());
    } 

    @Test
    public void testCB5() {
        Calculadora c = new Calculadora();
        Salario s = c.calcularSalario("horista", 55);
        assertEquals(55 * 15, s.getValorSalario());
        assertEquals("autorizacao de hora-extra", 
                                    s.getPendencia());
    }     
}
