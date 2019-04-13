/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeEstrutural;

import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class PessoaDAO {

    RHService rhservice;

    public PessoaDAO(RHService rhservice) {
        this.rhservice = rhservice;
    }

    public boolean existePessoa(String nome) {
        ArrayList<Pessoa> pessoas = rhservice.getAllPessoas();
        for (Pessoa p : pessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }
}
