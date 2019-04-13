/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import testeEstrutural.Pessoa;
import testeEstrutural.PessoaDAO;
import testeEstrutural.RHService;

/**
 *
 * @author Aluno
 */
public class PessoaDAOTest {
    
    public PessoaDAOTest() {
    }
    
    //caminho: 1,2,5
    @Test
    public void testListaDePessoasVazia() {
        //criou o mock
        RHService rhServiceMock = mock(RHService.class); 
        //define o comportamento do mock
        ArrayList<Pessoa> pessoasDoMock = new ArrayList<Pessoa>();
        when(rhServiceMock.getAllPessoas())
                .thenReturn( pessoasDoMock );
        
        PessoaDAO dao = new PessoaDAO(rhServiceMock);
        
        assertFalse( dao.existePessoa("joao da silva") );
    }
    
    //caminho:1,2,3,2,5 
    @Test
    public void testListaDePessoasCom1Elemento() {
        //criou o mock
        RHService rhServiceMock = mock(RHService.class); 
        //define o comportamento do mock
        ArrayList<Pessoa> pessoasDoMock = new ArrayList<Pessoa>();
        Pessoa p = new Pessoa();
        p.setNome("Carlos de Souza");
        pessoasDoMock.add(p);
        
        when(rhServiceMock.getAllPessoas())
                .thenReturn( pessoasDoMock );
        
        PessoaDAO dao = new PessoaDAO(rhServiceMock);
        
        assertFalse( dao.existePessoa("joao da silva") );
    }
    
    //caminho: 1,2,3,4
    @Test
    public void testListaDePessoasCom2Elementos() {
        //criou o mock
        RHService rhServiceMock = mock(RHService.class); 
        //define o comportamento do mock
        ArrayList<Pessoa> pessoasDoMock = new ArrayList<Pessoa>();
        Pessoa p = new Pessoa();
        p.setNome("Joao Da Silva");
        pessoasDoMock.add(p);
        p = new Pessoa();
        p.setNome("Carlos de Souza");
        pessoasDoMock.add(p);
        
        when(rhServiceMock.getAllPessoas())
                .thenReturn( pessoasDoMock );
        
        PessoaDAO dao = new PessoaDAO(rhServiceMock);
        
        assertTrue( dao.existePessoa("joao da silva") );
        
        verify(rhServiceMock).getAllPessoas();
    }    
}
