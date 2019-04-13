/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathops;

/**
 *
 * @author Aluno
 */
public class MathOps {

    public int fatorial(int n) 
            throws RuntimeException {
        
        if(n < 0)
            throw new RuntimeException();
        
        if(n == 0)
            return 1;
        else
            return n * fatorial(n-1);
    }
    
    public boolean ehPrimo(int n) {
        //TO DO
        
        return true;
    }
    
}
