/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Aluno
 */
public class SegundoTest {
    
    public SegundoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("@BeforeClass");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("@AfterClass");
    }
    
    @Before
    public void setUp() {
        System.out.println("@Before");
    }
    
    @After
    public void tearDown() {
        System.out.println("@After");
    }

    @Test
    public void casoDeTeste01() {
        System.out.println("caso de teste 01");
    }
    
    @Ignore
    @Test
    public void casoDeTeste02() {
        System.out.println("caso de teste 02");
    }
    
}
