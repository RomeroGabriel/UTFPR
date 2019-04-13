/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exercicio8.Dicionario;
import exercicio8.VerificadorDeSenhas;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Aluno
 */
public class VerificadorDeSenhasTest {
    
    public VerificadorDeSenhasTest() {
    }
    
    //classes validas
    @Test
    public void test01() {
        Dicionario dicMock = mock(Dicionario.class);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("senha");
        lista.add("12345");
        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn( lista );
        
        VerificadorDeSenhas verificador = new VerificadorDeSenhas(dicMock);
        
        assertTrue(verificador.validarNovaSenha("abcdef"));
    }
    
    @Test
    public void test02() {
        Dicionario dicMock = mock(Dicionario.class);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("senha");
        lista.add("12345");
        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn( lista );
        
        VerificadorDeSenhas verificador = new VerificadorDeSenhas(dicMock);
        
        assertTrue(verificador.validarNovaSenha("1bcdef"));
    }

    @Test
    public void test03() {
        Dicionario dicMock = mock(Dicionario.class);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("senha");
        lista.add("12345");
        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn( lista );
        
        VerificadorDeSenhas verificador = new VerificadorDeSenhas(dicMock);
        
        assertTrue(verificador.validarNovaSenha("_bcdef"));
    }
    
    //classes invalidas
    @Test
    public void testTamanhoMenorCinco() {
        Dicionario dicMock = mock(Dicionario.class);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("senha");
        lista.add("12345");
        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn( lista );
        
        VerificadorDeSenhas verificador = new VerificadorDeSenhas(dicMock);
        
        assertFalse(verificador.validarNovaSenha("ab"));
    }
    
@Test
    public void testSenhaEstaNoDicionario() {
        Dicionario dicMock = mock(Dicionario.class);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("senha");
        lista.add("12345");
        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn( lista );
        
        VerificadorDeSenhas verificador = 
                        new VerificadorDeSenhas(dicMock);
        
        assertFalse(verificador.validarNovaSenha("senha"));
    }    
    
}
