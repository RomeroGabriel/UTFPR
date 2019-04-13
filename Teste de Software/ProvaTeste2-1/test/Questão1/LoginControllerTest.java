package Questão1;

import Questao1.LoginController;
import Questao1.Usuario;
import Questao1.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoginControllerTest {
    
    public LoginControllerTest() {
    }
    
    @Test(expected= Exception.class)
    public void nomeVazio() throws Exception{
        LoginController controller = new LoginController();
        assertEquals("preencher nome e senha", controller.efetuarLogin("", "123"));
    }
    
    @Test(expected= Exception.class)
    public void senhaVazio() throws Exception{
        LoginController controller = new LoginController();
        assertEquals("preencher nome e senha", controller.efetuarLogin("aaa", ""));
    }
    
    @Test(expected = Exception.class)
    public void usuarioNaoExiste()throws Exception{
        List<Usuario> usu = new ArrayList<>();
        Usuario u = new Usuario("0", "123");
        Usuario u1 = new Usuario("1", "123");
        Usuario u2 = new Usuario("2", "123");
        usu.add(u); usu.add(u1); usu.add(u2);
        UsuarioDAO dao = mock(UsuarioDAO.class);
        when(dao.getUsuarios()).thenReturn(usu);
        
        LoginController controller = new LoginController();
        controller.setUsuarioDAO(dao);

        assertEquals("usuario nao existe", controller.efetuarLogin("aa", "kkkk"));
    }
    
    @Test
    public void usuarioExiste()throws Exception{
        List<Usuario> usu = new ArrayList<>();
        Usuario u = new Usuario("0", "123");
        Usuario u1 = new Usuario("1", "123");
        Usuario u2 = new Usuario("2", "123");
        usu.add(u); usu.add(u1); usu.add(u2);
        UsuarioDAO dao = mock(UsuarioDAO.class);
        when(dao.getUsuarios()).thenReturn(usu);
        
        LoginController controller = new LoginController();
        controller.setUsuarioDAO(dao);

        assertEquals(true, controller.efetuarLogin("0", "123"));
    }
    
    @Test
    public void usuarioExisteSenhaDiferente()throws Exception{
        List<Usuario> usu = new ArrayList<>();
        Usuario u = new Usuario("0", "123");
        Usuario u1 = new Usuario("1", "123");
        Usuario u2 = new Usuario("2", "123");
        usu.add(u); usu.add(u1); usu.add(u2);
        UsuarioDAO dao = mock(UsuarioDAO.class);
        when(dao.getUsuarios()).thenReturn(usu);
        
        LoginController controller = new LoginController();
        controller.setUsuarioDAO(dao);

        assertEquals(false, controller.efetuarLogin("0", "1234"));
    }
}
