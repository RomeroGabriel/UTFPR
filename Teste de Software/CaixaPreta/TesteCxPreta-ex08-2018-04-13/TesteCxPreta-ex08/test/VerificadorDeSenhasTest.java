/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import testecxpreta.ex08.Dicionario;
import testecxpreta.ex08.VerificadorDeSenhas;

/**
 *
 * @author Aluno
 */
public class VerificadorDeSenhasTest {
    
    public VerificadorDeSenhasTest() {
    }

    @Test
    public void testCV1() {
        Dicionario dicMock = mock(Dicionario.class);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("senha");
        lista.add("12345678");
        lista.add("password");
        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn(lista);
        
        VerificadorDeSenhas v = new VerificadorDeSenhas(dicMock);
        boolean res = v.validarNovaSenha("utf2018");
        assertTrue(res);
    }
    
    @Test
    public void testCIMenorQueCinco() {
        Dicionario dicMock = mock(Dicionario.class);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("senha");
        lista.add("12345678");
        lista.add("password");
        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn(lista);
        
        VerificadorDeSenhas v = new VerificadorDeSenhas(dicMock);
        boolean res = v.validarNovaSenha("123");
        assertFalse(res);
    }   
    
    @Test
    public void testCIEstaNaLista() {
        Dicionario dicMock = mock(Dicionario.class);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("senha");
        lista.add("12345678");
        lista.add("password");
        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn(lista);
        
        VerificadorDeSenhas v = new VerificadorDeSenhas(dicMock);
        boolean res = v.validarNovaSenha("password");
        assertFalse(res);
    } 
    
    @Test
    public void testCIMaiorQueDez() {
        Dicionario dicMock = mock(Dicionario.class);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("senha");
        lista.add("12345678");
        lista.add("password");
        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn(lista);
        
        VerificadorDeSenhas v = new VerificadorDeSenhas(dicMock);
        boolean res = v.validarNovaSenha("1234567890");
        assertFalse(res);
    }   
    
    @Test
    public void testCIPrimeiroNaoAlfaNum() {
        Dicionario dicMock = mock(Dicionario.class);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("senha");
        lista.add("12345678");
        lista.add("password");
        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn(lista);
        
        VerificadorDeSenhas v = new VerificadorDeSenhas(dicMock);
        boolean res = v.validarNovaSenha("&utf2018");
        assertFalse(res);
    }      
    
    @Test
    public void testCICombinacaoTemCaracterNaoAlfaNum() {
        Dicionario dicMock = mock(Dicionario.class);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("senha");
        lista.add("12345678");
        lista.add("password");
        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn(lista);
        
        VerificadorDeSenhas v = new VerificadorDeSenhas(dicMock);
        boolean res = v.validarNovaSenha("utf%2018");
        assertFalse(res);
    }    
    
    //Analise de valor limite
    @Test
    public void testAVLsenha4digitos() {
        Dicionario dicMock = mock(Dicionario.class);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("senha");
        lista.add("12345678");
        lista.add("password");
        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn(lista);
        
        VerificadorDeSenhas v = new VerificadorDeSenhas(dicMock);
        boolean res = v.validarNovaSenha("utf2");
        assertFalse(res);
    }  
    
@Test
    public void testAVLsenhaNaUltimaPosicaoDaLista() {
        Dicionario dicMock = mock(Dicionario.class);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("senha");
        lista.add("12345678");
        lista.add("password");
        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn(lista);
        
        VerificadorDeSenhas v = new VerificadorDeSenhas(dicMock);
        boolean res = v.validarNovaSenha("password");
        assertFalse(res);
    }     
}
