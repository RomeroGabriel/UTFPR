package ex11;

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
public class SomatoriaTest {
    
    //1,2,3,[4,5,6]4vezes,7,9
    @Test
    public void test01() throws Exception {
        Somatoria s = new Somatoria();
        int res = s.somatoriaLimitada(-3, 7);
        assertEquals(6, res);
    }
    
    //1,2,[4,5,6]3vezes,4,5,7,8
    @Test(expected = Exception.class)
    public void test02() throws Exception {
        Somatoria s = new Somatoria();
        int res = s.somatoriaLimitada(3, 1);
    }    
}
