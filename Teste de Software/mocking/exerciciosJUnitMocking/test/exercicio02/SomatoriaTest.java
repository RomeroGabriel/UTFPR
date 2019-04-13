/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio02;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Aluno
 */
public class SomatoriaTest {
    
    public SomatoriaTest() {
    }

    @Test
    public void ct01() {
        MathOps mathopsMock = mock(MathOps.class);
        
        when(mathopsMock.fatorial(3)).thenReturn(6);
        when(mathopsMock.fatorial(4)).thenReturn(24);
        
        Somatoria somatoria = new Somatoria(mathopsMock);
        int numeros[] = {3,4};
        int resultado = somatoria.somaDeFatoriais(numeros);
        assertEquals(30, resultado);
        
        verify(mathopsMock).fatorial(3);
        verify(mathopsMock).fatorial(4);
        
        //verify(mathopsMock, times(2)).fatorial(anyInt());
    }
    
    @Test
    public void ct02() {
        MathOps mathopsMock = mock(MathOps.class);
        
        when(mathopsMock.fatorial(0)).thenReturn(1);
        when(mathopsMock.fatorial(1)).thenReturn(1);
        when(mathopsMock.fatorial(2)).thenReturn(2);
        when(mathopsMock.fatorial(3)).thenReturn(6);
        when(mathopsMock.fatorial(4)).thenReturn(24);
        
        Somatoria somatoria = new Somatoria(mathopsMock);
        int numeros[] = {0, 1, 2, 3, 4};
        int resultado = somatoria.somaDeFatoriais(numeros);
        assertEquals(34, resultado);
        
        verify(mathopsMock, times(5))
                .fatorial(anyInt());
    }    
}
