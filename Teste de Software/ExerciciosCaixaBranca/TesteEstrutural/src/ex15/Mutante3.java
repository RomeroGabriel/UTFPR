/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex15;

/**
 *
 * @author Aluno
 */
public class Mutante3 {
    public int calcularAnosBissexto(int ano[]) {
        int c = 0;
        for (int i = 0; i < ano.length; i++) {
            if(ano[i] % 40 == 0) //400 -> 40
                c++;
            else if(ano[i] % 4 == 0 && ano[i] % 100 != 0)
                c++;
        }
        return c;
    }
}
