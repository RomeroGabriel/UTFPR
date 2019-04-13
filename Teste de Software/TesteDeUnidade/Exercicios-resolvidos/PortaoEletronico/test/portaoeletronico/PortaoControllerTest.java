/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portaoeletronico;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Aluno
 */
public class PortaoControllerTest {
    
    public PortaoControllerTest() {
    }

    @Test
    public void testTagErro() {
        //criar os mocks
        Display mockDisplay = mock(Display.class);
        
        PortaoController portaoController = 
                                    new PortaoController();
        portaoController.setDisplay(mockDisplay);
        
        boolean saidaReal = portaoController.abrir("ERRO");
        assertEquals(false, saidaReal);
        
        //verifico se os metodos a seguir foram chamados
        verify(mockDisplay).limpar();
        verify(mockDisplay)
            .mostrarMsg("Automovel nao possui TAG. Por favor, voltar!");
    }
    
    @Test
    public void testTagDesconhecida() {
        //criar os mocks
        Display mockDisplay = mock(Display.class);
        AutomovelDAO mockAutoDao = mock(AutomovelDAO.class);
        
        //define o que os mocks retornam
        when(mockAutoDao.getByTag("1234")).thenReturn(null);
        
        //preparando o contexto (pre-condicoes)
        PortaoController portaoController = new PortaoController(); 
        portaoController.setDisplay(mockDisplay);
        portaoController.setAutomovelDao(mockAutoDao);
        
        //executando o teste
        boolean saidaReal = portaoController.abrir("1234");
        assertEquals(false, saidaReal);
        
        //verifico se os metodos a seguir foram chamados
        verify(mockDisplay).limpar();
        verify(mockDisplay).mostrarMsg("TAG desconhecida. Por favor, voltar!");
        verify(mockAutoDao).getByTag("1234");
    }

    @Test
    public void testTagDeUmCarroCadastrado() {
        //criar os mocks
        Display mockDisplay = mock(Display.class);
        AutomovelDAO mockAutoDao = mock(AutomovelDAO.class);
        Cancela mockCancela = mock(Cancela.class);
        RegistroEntradaDao mockRegistro = mock(RegistroEntradaDao.class);
        
        //define o que os mocks retornam
        Automovel auto = new Automovel();
        auto.setTag("5561");
        auto.setPlaca("ZXC-9908");
        auto.setProprietario("Joao da Silva");
        when(mockAutoDao.getByTag("5561")).thenReturn( auto );
        
        //preparando o contexto (pre-condicoes)
        PortaoController portaoController = new PortaoController(); 
        portaoController.setDisplay(mockDisplay);
        portaoController.setAutomovelDao(mockAutoDao);
        portaoController.setCancela(mockCancela);
        portaoController.setRegistroEntradaDao(mockRegistro);
        
        //executando o teste
        boolean saidaReal = portaoController.abrir("5561");
        assertEquals(true, saidaReal);
        
        //verifico se os metodos a seguir foram chamados
        verify(mockDisplay).limpar();
        verify(mockDisplay).mostrarMsg("Bem-Vindo, Joao da Silva!");
        verify(mockAutoDao).getByTag("5561");  
        verify(mockCancela).levantar();
        verify(mockRegistro).registrarEntradaAgora("ZXC-9908", "Joao da Silva");
    }


}
