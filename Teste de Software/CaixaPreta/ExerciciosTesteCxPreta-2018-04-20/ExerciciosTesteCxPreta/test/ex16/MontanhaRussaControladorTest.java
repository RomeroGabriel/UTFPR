package ex16;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Aluno
 */
public class MontanhaRussaControladorTest {
    
    public MontanhaRussaControladorTest() {
    }

    @Test
    public void testCV01() throws Exception {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        when(clienteDaoMock.ehCliente("Luke Skywaljker"))
                .thenReturn(Boolean.TRUE);
        
        MontanhaRussaControlador cont = 
            new MontanhaRussaControlador(clienteDaoMock);
        
        String res = cont.autorizar("Luke Skywalker", 20);
        assertEquals("autorizado", res);
    }
    
    @Test
    public void testCV02() throws Exception {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        when(clienteDaoMock.ehCliente("Luke Skywalker"))
                .thenReturn(Boolean.TRUE);
        
        MontanhaRussaControlador cont = 
            new MontanhaRussaControlador(clienteDaoMock);
        
        String res = cont.autorizar("Luke Skywalker", 15);
        assertEquals("acompanhado dos pais", res);
    }    
    
    @Test
    public void testCV03() throws Exception {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        when(clienteDaoMock.ehCliente("Luke Skywalker"))
                .thenReturn(Boolean.TRUE);
        
        MontanhaRussaControlador cont = 
            new MontanhaRussaControlador(clienteDaoMock);
        
        String res = cont.autorizar("Luke Skywalker", 94);
        assertEquals("acompanhado do responsavel legal", res);
    }   
    
    @Test(expected = Exception.class)
    public void testCI01() throws Exception {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        
        MontanhaRussaControlador cont = 
            new MontanhaRussaControlador(clienteDaoMock);
        
        cont.autorizar("Luke$$ Skywalker", 94);
    }      
    
    @Test(expected = Exception.class)
    public void testCI02() throws Exception {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        
        MontanhaRussaControlador cont = 
            new MontanhaRussaControlador(clienteDaoMock);
        
        cont.autorizar("Luke Skywalker", 0);
    }    

    @Test(expected = Exception.class)
    public void testCI03() throws Exception {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        
        MontanhaRussaControlador cont = 
            new MontanhaRussaControlador(clienteDaoMock);
        
        cont.autorizar("Luke Skywalker", 200);
    }  
    
    @Test(expected = Exception.class)
    public void testCI04() throws Exception {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        when(clienteDaoMock.ehCliente("Luke Skywalker"))
                .thenReturn(Boolean.FALSE);
        
        MontanhaRussaControlador cont = 
            new MontanhaRussaControlador(clienteDaoMock);
        
        cont.autorizar("Luke Skywalker", 20);
    }     
    
    @Test
    public void testVL01() throws Exception {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        when(clienteDaoMock.ehCliente("Luke Skywalker"))
                .thenReturn(Boolean.TRUE);
        
        MontanhaRussaControlador cont = 
            new MontanhaRussaControlador(clienteDaoMock);
        
        String res = cont.autorizar("Luke Skywalker", 1);
        assertEquals("acompanhado dos pais", res);
    }  
    
    @Test
    public void testVL02() throws Exception {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        when(clienteDaoMock.ehCliente("Luke Skywalker"))
                .thenReturn(Boolean.TRUE);
        
        MontanhaRussaControlador cont = 
            new MontanhaRussaControlador(clienteDaoMock);
        
        String res = cont.autorizar("Luke Skywalker", 120);
        assertEquals("acompanhado do responsavel legal", res);
    }    
}
