package questao11;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import questao11.CampoObrigatorioException;
import questao11.Contato;
import questao11.ContatoDAO;
import questao11.IdadeInvalidaException;
import questao11.PesoInvalidoException;

/**
 *
 * @author I202
 */
public class ContatoDAOTest {
    
    Contato contato;
    
    public ContatoDAOTest() {
    }

    @Before
    public void before() {
        contato = new Contato();
        contato.setNome("Joao da Silva");
        contato.setPassword("###");
        contato.setEmail("joao@gmail.com");
        contato.setIdade(25);
        contato.setPeso(80.7f);
        contato.setTelefone("(43) 5555-9988");
    }

    @Test
    public void testNomeBranco() {
        contato.setNome("");
        
        ContatoDAO dao = new ContatoDAO();
        try {
            dao.salvar(contato);
            fail();
        } catch (Exception ex) {
            assertTrue( ex instanceof CampoObrigatorioException);
        }
    }

    @Test
    public void testEmailBranco() {
        contato.setEmail("");
        
        ContatoDAO dao = new ContatoDAO();
        try {
            dao.salvar(contato);
            fail();
        } catch (Exception ex) {
            assertTrue( ex instanceof CampoObrigatorioException);
        }
    }
    
    @Test
    public void testIdadeInvalida() {
        contato.setIdade(120);
        
        ContatoDAO dao = new ContatoDAO();
        try {
            dao.salvar(contato);
            fail();
        } catch (Exception ex) {
            assertTrue( ex instanceof IdadeInvalidaException);
        }
    }

    @Test(expected = PesoInvalidoException.class)
    public void testPesoInvalido() throws Exception {
        contato.setPeso(500.0f);
        
        ContatoDAO dao = new ContatoDAO();
        dao.salvar(contato);
    }    
}
