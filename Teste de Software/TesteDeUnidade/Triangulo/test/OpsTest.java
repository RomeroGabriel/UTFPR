
import org.junit.Test;
import static org.junit.Assert.*;
import triangulo.Ops;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class OpsTest {

    @Test
    public void testMedia() {
        Ops ops = new Ops();
        
        assertEquals(3.0, ops.media(1.0, 5.0), 0.0001);
    }
    
    @Test
    public void testOrdenacao() {
        Ops ops = new Ops();
        
        int a[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        
        ops.sort(a);
        
        for (int i = 0; i < a.length-1; i++) {
            assertTrue( a[i] <= a[i+1] );
        }
    }
       
}
