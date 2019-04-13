package Questao3Test;

import Questao3.Atendente;
import Questao3.ProdutoDAO;
import Questao3.SemEstoqueException;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.lang.IllegalArgumentException;
/**
 *
 * @author romero
 */
public class AtendenteTest {
    
    public AtendenteTest() {
    }
    
    @Test
    public void CTValido() throws IllegalArgumentException, SemEstoqueException{
        ProdutoDAO prodMock = mock(ProdutoDAO.class);
        when(prodMock.getQuantidadeDisponivel("0123456789012")).thenReturn(100);
        Atendente at = new Atendente(prodMock);
        
        String res = at.efetuarPedidoDeOrcamento("0123456789012",10);
        
        assertEquals("Orcamento normal", res);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void CTInvalido01() throws IllegalArgumentException, SemEstoqueException{
        ProdutoDAO prodMock = mock(ProdutoDAO.class);
        when(prodMock.getQuantidadeDisponivel("0123456789ab")).thenReturn(100);
        Atendente at = new Atendente(prodMock);
        at.efetuarPedidoDeOrcamento("0123456789ab", 10);
    }
    
    @Test(expected = SemEstoqueException.class)
    public void CTInvalido02() throws IllegalArgumentException, SemEstoqueException{
        ProdutoDAO prodMock = mock(ProdutoDAO.class);
        when(prodMock.getQuantidadeDisponivel("0123456789012")).thenReturn(100);
        Atendente at = new Atendente(prodMock);
        at.efetuarPedidoDeOrcamento("0123456789ab", 1050);
    }
}
