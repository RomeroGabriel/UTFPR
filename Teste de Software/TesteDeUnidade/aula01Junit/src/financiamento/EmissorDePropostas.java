/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiamento;

import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class EmissorDePropostas {

    ArrayList<Proposta> definirPropostas(Cliente c) {
        if(c.getSalario() <= 1000.00f) {
            ArrayList<Proposta> propostas = 
                    calcularParaMenorFaixa(c);
            return propostas;
        }
        
        return null;
    }

    private ArrayList<Proposta> calcularParaMenorFaixa(Cliente c) {
        Proposta p1 =
                new Proposta(2, 2.0f * c.getValorAserFinanciado());
        p1.calcularValorDaParcela();
        Proposta p2 =
                new Proposta(3, 2.0f * c.getValorAserFinanciado());
        p2.calcularValorDaParcela();
        ArrayList<Proposta> propostas = new ArrayList<>();
        propostas.add(p1);
        propostas.add(p2);
        return propostas;
    }
    
}
