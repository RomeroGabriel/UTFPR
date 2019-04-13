/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiamento;

/**
 *
 * @author Aluno
 */
public class Cliente {
    private String nome;
    private float salario;
    private int idade;
    private float valorAserFinanciado;
    
    void setNome(String pNome) {
        nome = pNome;
    }

    void setSalario(float pSalario) {
        salario = pSalario;
    }

    void setIdade(int pIdade) {
        idade = pIdade;
    }

    void setValorAserFinanciado(float pValorAserFinanciado) {
        valorAserFinanciado = pValorAserFinanciado;
    }

    public String getNome() {
        return nome;
    }

    public float getSalario() {
        return salario;
    }

    public int getIdade() {
        return idade;
    }

    public float getValorAserFinanciado() {
        return valorAserFinanciado;
    }
    
}
