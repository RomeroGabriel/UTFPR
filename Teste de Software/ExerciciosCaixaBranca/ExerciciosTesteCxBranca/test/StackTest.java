/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exerciciostestecxbranca.Stack;
import java.util.EmptyStackException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class StackTest {
    
    public StackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void empilharDois() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        
    }
    
    @Test
    public void empilharParaExecutarResize() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        assertEquals(40, stack.pop());
        assertEquals(30, stack.pop());
        
    }
    
    @Test(expected = EmptyStackException.class)
    public void desempilharVazio() {
        Stack stack = new Stack();
        stack.pop();
    }    
}
