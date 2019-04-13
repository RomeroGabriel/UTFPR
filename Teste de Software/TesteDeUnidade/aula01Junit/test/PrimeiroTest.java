/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aula01junit.Aula01Junit;
import java.util.ArrayList;
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
public class PrimeiroTest {
    
    Aula01Junit a;
    
    public PrimeiroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        a = new Aula01Junit();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void casoDeTeste01() {
        int res = a.gerarNumeroAleatorio(1, 10);
        assertTrue(res >= 1 && res <= 10);
    }
    
    @Test
    public void casoDeTeste02() {
        int res = a.gerarNumeroAleatorio(-1, 10);
        assertEquals(-1, res);    
    }
    
    @Test
    public void casoDeTeste03() {
        char s[] = {'a', 'b', 'c', 'd', 'e'};
        String res = a.acharCaracter(5, s, 'c');
        assertEquals("2", res);
    }
    
    @Test
    public void casoDeTeste04() {
        char s[] = {'a', 'b', 'c', 'd', 'e'};
        String res = a.acharCaracter(5, s, 'f');
        assertEquals("caracter nao encontrado", res);    
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void casoDeTeste05(){
        ArrayList<String> list = new ArrayList<>();
        list.add("andre");
        list.add("joao");
        list.add("josefa");
        list.add("maria");
        
        list.get(5);
    }

    @Test
    public void casoDeTeste051(){
        ArrayList<String> list = new ArrayList<>();
        list.add("andre");
        list.add("joao");
        list.add("josefa");
        list.add("maria");
        
        try {
            list.get(5);
            fail("nao deveria chegar ate aqui!");
        }
        catch(Exception e) {
            assertTrue(e instanceof 
                    IndexOutOfBoundsException);
        }
    }
    /*
@Test
    public void casoDeTeste06(){
        ArrayList<String> list = new ArrayList<>();
        list.add("andre");
        list.add("joao");
        list.add("josefa");
        list.add("maria");
        
        try {
            String res = list.get(2);
            assertEquals("josefa", res);
        }
        catch(Exception e) {
            fail("nao deveria chegar ate aqui!");
        }
    } */   
}
