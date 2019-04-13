/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula01junit;

import java.util.Random;

/**
 *
 * @author Aluno
 */
public class Aula01Junit {

    public int gerarNumeroAleatorio(int inicio, int fim) {
        if (inicio < 0 || fim < 0) {
            return -1;
        }
        if (inicio >= fim) {
            return -1;
        }
        int diff = fim - inicio + 1;
        Random random = new Random();
        int tInt = random.nextInt(diff); //esse método retorna um número aleatorio
                                         //entre 0 e diff [ 0, diff [
        return inicio + tInt;
    }

    public String acharCaracter(int tamanho, char cadeia[], char caracterProcurado) {
        if (tamanho < 1 || tamanho > 20) {
            return "comprimento invalido";
        }
        if (cadeia.length != tamanho) {
            return "comprimento fornecido diferente do comprimento real";
        }
        for (int i = 0; i < cadeia.length; i++) {
            char c = cadeia[i];
            if (c == caracterProcurado) {
                return String.valueOf(i);
            }
        }
        return "caracter nao encontrado";
    }
}
