package Questao1;

public class Usuario {
    private String nome, senha;

    public Usuario(String pNome, String pSenha) {
        nome = pNome;
        senha = pSenha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}
