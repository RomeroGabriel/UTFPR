/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciostestecxbranca;

import java.util.EmptyStackException;

/**
 *
 * @author Aluno
 */
public class Stack {

    int[] values = new int[3];
    int size = 0;

    public void push(int x) {
        if (size >= values.length) {
            resize();
        }
        if (size < values.length) {
            values[size++] = x;
        }
    }

    public int pop() {
        if (size > 0) {
            return values[--size];
        } else {
            throw new EmptyStackException();
        }
    }

    private void resize() {
        int[] tmp = new int[values.length * 2];
        for (int i = 0; i < values.length; i++) {
            tmp[i] = values[i];
        }
        values = tmp;
    }
}
