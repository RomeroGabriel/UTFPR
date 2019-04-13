package Questao1;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
/**
 *
 * @author romero
 */
public class IMCCalculadoraTest {
    
    public IMCCalculadoraTest() {
    }
    IMCCalculadora calculadora;
    Pessoa pessoa;
    IMCStatus status;
    
    @Before
    public void configura(){
        calculadora = new IMCCalculadora();
        pessoa = new Pessoa("Romero", 40, 1.80);
        status = new IMCStatus(0, "");
    }
    
       
    
    @Test
    public void abaixoPeso(){
        status = calculadora.calcular(pessoa);
        assertEquals("abaixo do peso", status.getClassificacao());
        assertEquals(40 / (1.80*1.80), status.getImc(), 0.01);
    }
    
    @Test
    public void normal(){
        pessoa = new Pessoa("Neymar", 80, 1.80);
        status = calculadora.calcular(pessoa);
        assertEquals("normal", status.getClassificacao());
        assertEquals(80 / (1.80*1.80), status.getImc(), 0.01);
    }
    
    @Test
    public void acimaPeso(){
        pessoa = new Pessoa("Roberto Firmino", 90, 1.80);
        status = calculadora.calcular(pessoa);
        assertEquals("acima do peso", status.getClassificacao());
        assertEquals(90 / (1.80*1.80), status.getImc(), 0.01);
    }
    
    @Test
    public void obeso(){
        pessoa = new Pessoa("Messi", 120, 1.80);
        status = calculadora.calcular(pessoa);
        assertEquals("obeso", status.getClassificacao());
        assertEquals(120 / (1.80*1.80), status.getImc(), 0.01);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void excecao(){
      pessoa = new Pessoa("CR7", -2, -5);
      calculadora.calcular(pessoa);
    } 
}
