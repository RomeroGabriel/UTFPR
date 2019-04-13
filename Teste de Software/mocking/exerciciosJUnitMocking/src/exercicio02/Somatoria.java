/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio02;

/**
 *
 * @author Aluno
 */
public class Somatoria {

    MathOps mathOps;

    public Somatoria(MathOps mathOps) {
        this.mathOps = mathOps;
    }

    /**
     * @param numeros
     * @return a somatoria do fatorial de cada inteiro no array numeros
     */
    public int somaDeFatoriais(int numeros[]) {
        int res = 0;
        for(int num : numeros) {
            res += mathOps.fatorial(num);
        }
        
        return res;
    }
}
