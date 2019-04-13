package Questão4Test;

import Questao4.Autenticacao;
import Questao4.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author romero
 */
public class AutenticacaoTest {
    
    public AutenticacaoTest() {
    }
    
    @Test
    public void emailVazio(){
        Usuario us = new Usuario("", "12345", "admin");
        Autenticacao au = new Autenticacao();
        assertEquals("e-mail/senha não podem ser vazio", au.login(us));
    }
    
    @Test
    public void senhaVazio(){
        Usuario us = new Usuario("abc@aaa.aaa", "", "admin");
        Autenticacao au = new Autenticacao();
        assertEquals("e-mail/senha não podem ser vazio", au.login(us));
    }
    
    @Test
    public void emailFormatoInvalido(){
        Usuario us = new Usuario("abc@", "12345", "admin");
        Autenticacao au = new Autenticacao();
        assertEquals("e-mail fora do formato", au.login(us));
    }
    
    @Test
    public void senhaMenorQue4(){
        Usuario us = new Usuario("abc@aaa.aaa", "123", "admin");
        Autenticacao au = new Autenticacao();
        assertEquals("a senha tem ao menos 4 caracteres", au.login(us));
    }
    
    @Test
    public void usuarioNaoExiste(){
        Usuario us = new Usuario("abc@aaa.abc", "123", "admin");
        Autenticacao au = new Autenticacao();
        assertEquals("usuario não existe", au.login(us));
    }
    
    @Test
    public void senhaIncorreta(){
        Usuario us = new Usuario("abc@aaa.aaa", "123567", "admin");
        Autenticacao au = new Autenticacao();
        assertEquals("senha incorreta", au.login(us));
    }
    
    @Test
    public void logadoNormal(){
        Usuario us = new Usuario("abc@aaa.aaa", "123567", "normal");
        Autenticacao au = new Autenticacao();
        assertEquals("logado", au.login(us));
    }
    
    @Test
    public void logadoAdmin(){
        Usuario us = new Usuario("abc@aaa.aaa", "123567", "admin");
        Autenticacao au = new Autenticacao();
        assertEquals("logado como admin", au.login(us));
    }
}
