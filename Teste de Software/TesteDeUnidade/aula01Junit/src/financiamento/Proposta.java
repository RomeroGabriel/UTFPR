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
public class Proposta {
    int numeroParcelas;
    float total, valorDaParcela;
    Proposta(int pNumeroParcelas, float pTotal) {
        numeroParcelas = pNumeroParcelas;
        total = pTotal;
    }

    float getTotal() {
        return total;
    }

    Object getNumeroParcelas() {
        return numeroParcelas;
    }

    double getValorDaParcela() {
        return valorDaParcela;
    }

    void calcularValorDaParcela() {
        valorDaParcela = total / numeroParcelas;
    }
    
}
