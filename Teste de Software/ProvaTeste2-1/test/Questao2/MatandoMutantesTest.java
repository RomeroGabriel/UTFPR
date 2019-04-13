package Questao2;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MatandoMutantesTest {
    
    public MatandoMutantesTest() {
    }
    
    @Test
    public void matandoMutante1(){
        MathOps math = mock(MathOps.class);
        when(math.fatorial(0)).thenReturn(1);
        when(math.fatorial(4)).thenReturn(24);
        int vet[] = { 0, 4 };
        
        Original o = new Original(math);
        assertEquals(25, o.somaDeFatoriais(vet), 0.0001);
        
        Mutante1 m1 = new Mutante1(math);
        assertEquals(25, m1.somaDeFatoriais(vet), 0.0001);
        
        //mutante morto
    }
    
    @Test
    public void matandoMutante2(){
        MathOps math = mock(MathOps.class);
        when(math.fatorial(0)).thenReturn(1);
        when(math.fatorial(4)).thenReturn(24);
        int vet[] = { 0, 4 };
        
        Original o = new Original(math);
        assertEquals(25, o.somaDeFatoriais(vet), 0.0001);
        
        Mutante2 m2 = new Mutante2(math);
        assertEquals(25, m2.somaDeFatoriais(vet), 0.00001);
        //mutante equivalente
        //É equivalente porque mesmo mudando para || ele vai continuar
        //pegando numeros maiores que 0 OU numeros pares
        //O conjunto de numeros que satisfaz o if é o mesmo usando || ou &&
    }
}
