/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio01;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Aluno
 */
public class PessoaDAOTest {
    
    public PessoaDAOTest() {
    }

    @Test
    public void pessoaExisteTest() {
        RHService rhserviceMock = mock(RHService.class);
        
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Pessoa p1 = new Pessoa();
        p1.setNome("Joao da Silva");
        pessoas.add(p1);
        Pessoa p2 = new Pessoa();
        p2.setNome("Maria Souza");
        pessoas.add(p2);
        
        when(rhserviceMock.getAllPessoas())
                .thenReturn(pessoas);
        
        PessoaDAO dao = new PessoaDAO(rhserviceMock);
        boolean resposta = dao.existePessoa("Maria Souza");
        assertEquals(true, resposta);
        
        verify(rhserviceMock).getAllPessoas(); 
    }
    
    @Test
    public void pessoaNaoExisteTest() {
        RHService rhserviceMock = mock(RHService.class);
        
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Pessoa p1 = new Pessoa();
        p1.setNome("Joao da Silva");
        pessoas.add(p1);
        Pessoa p2 = new Pessoa();
        p2.setNome("Maria Souza");
        pessoas.add(p2);
        
        when(rhserviceMock.getAllPessoas())
                .thenReturn(pessoas);
        
        PessoaDAO dao = new PessoaDAO(rhserviceMock);
        boolean resposta = dao.existePessoa("Donald Trump");
        assertEquals(false, resposta);
        
        verify(rhserviceMock).getAllPessoas(); 
    }    
}
