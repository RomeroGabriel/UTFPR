/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex13;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Aluno
 */
public class UsuarioValidatorTest {
    
    public UsuarioValidatorTest() {
    }
    
    //1, 2
    @Test(expected = Exception.class)
    public void ct1() throws Exception {
        UsuarioDAO usuarioDaoMock = mock(UsuarioDAO.class);
        UsuarioValidator v = new UsuarioValidator(usuarioDaoMock);
        Usuario u = new Usuario();
        u.setNome("ab");
        v.ehUsuarioValido(u);
    }
    
    //1, 3, 4
    @Test(expected = Exception.class)
    public void ct2() throws Exception {
        UsuarioDAO usuarioDaoMock = mock(UsuarioDAO.class);
        UsuarioValidator v = new UsuarioValidator(usuarioDaoMock);
        Usuario u = new Usuario();
        u.setNome("Sergio");
        u.setSenha("sal");
        u.setSenhaConfirmada("salva");
        v.ehUsuarioValido(u);
    }    
    
    //1, 3, 5, 6
    @Test(expected = Exception.class)
    public void ct3() throws Exception {
        UsuarioDAO usuarioDaoMock = mock(UsuarioDAO.class);
        when(usuarioDaoMock.existe(anyString()))
                .thenReturn(Boolean.TRUE);
        
        UsuarioValidator v = new UsuarioValidator(usuarioDaoMock);
        Usuario u = new Usuario();
        u.setNome("Sergio");
        u.setSenha("salva");
        u.setSenhaConfirmada("salva");
        v.ehUsuarioValido(u);
    }        
    
    //1, 3, 5, 7, 8
    @Test(expected = Exception.class)
    public void ct4() throws Exception {
        UsuarioDAO usuarioDaoMock = mock(UsuarioDAO.class);
        when(usuarioDaoMock.existe(anyString()))
                .thenReturn(Boolean.FALSE);

        SenhaValidator senhaValMock = mock(SenhaValidator.class);
        when(senhaValMock.verificar(anyString()))
                .thenReturn(Boolean.TRUE);
        
        UsuarioValidator v = new UsuarioValidator(usuarioDaoMock);
        v.setSenhaValidator(senhaValMock);
        Usuario u = new Usuario();
        u.setNome("Sergio");
        u.setSenha("salva");
        u.setSenhaConfirmada("salva");
        v.ehUsuarioValido(u);
    }    
    
    //1, 3, 5, 7, 9, 10, 11, ...
    @Test
    public void ct5() throws Exception {
        UsuarioDAO usuarioDaoMock = mock(UsuarioDAO.class);
        when(usuarioDaoMock.existe(anyString()))
                .thenReturn(Boolean.FALSE);

        SenhaValidator senhaValMock = mock(SenhaValidator.class);
        when(senhaValMock.verificar(anyString()))
                .thenReturn(Boolean.FALSE);
        
        UsuarioValidator v = new UsuarioValidator(usuarioDaoMock);
        v.setSenhaValidator(senhaValMock);
        Usuario u = new Usuario();
        u.setNome("Ser$gi2o");
        u.setSenha("salva");
        u.setSenhaConfirmada("salva");
        assertFalse(v.ehUsuarioValido(u));
    }    
}
