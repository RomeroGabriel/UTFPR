/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulo;

/**
 *
 * @author Aluno
 */
public class Triangulo {
    int a, b, c;
    
    public Triangulo(int ladoA, int ladoB, int ladoC) {
        a = ladoA;
        b = ladoB;
        c = ladoC;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public String qualTriangulo() {
        if(! isValido())
            return "erro";
        
        if(a == b && b == c)
            return "equilatero";

        if(a == b || b == c || a == c)
            return "isosceles";

        return "escaleno";
    }

    private boolean isValido() {
        if(a <= 0 || b <= 0 || c <= 0)
            return false;
        
        return (a+b) > c && (a+c) > b && (b+c) > a;
    }    
}
