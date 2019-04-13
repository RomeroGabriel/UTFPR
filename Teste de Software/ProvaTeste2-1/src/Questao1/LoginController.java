package Questao1;

import java.util.List;

public class LoginController {

    private UsuarioDAO usuarioDAO;
    
    public void setUsuarioDAO(UsuarioDAO usuarioDAO){
        this.usuarioDAO = usuarioDAO;
    }
    
    public boolean efetuarLogin(String nome, String senha) throws Exception{
        if(nome.equals("")/*1*/ || senha.equals("")/*2*/)
            throw new Exception("preencher nome e senha");/*3*/
        
        List<Usuario> usuarios = usuarioDAO.getUsuarios();/*4*/
        Usuario u = null;/*5*/
        for(int i = 0 /*6*/; i < usuarios.size()/*7*/; i++/*8*/){
            if(usuarios.get(i).getNome().equals(nome)/*9*/){
                u = usuarios.get(i);/*10*/
                break;/*11*/
            }
        }
        
        if(u == null)/*12*/
            throw  new Exception("usuario nao existe");/*13*/
        else if(u.getSenha().equals(senha))/*14*/
            return true;/*15*/
        else
            return false;/*16*/
    }
}
