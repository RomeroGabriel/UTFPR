/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import pilharestrita.PilhaCheiaException;
import pilharestrita.PilhaRestrita;
import pilharestrita.PilhaVaziaException;

/**
 *
 * @author Aluno
 */
public class TesteBaseadoModeloTest {
    
    public TesteBaseadoModeloTest() {
    }

    @Test
    public void ct01() throws Exception {
        //new (x=3)
        PilhaRestrita pilha = new PilhaRestrita(3);
        //vazia()/true
        assertTrue( pilha.vazia() );
        //empilhar
        pilha.empilhar("s1");
        //vazia()/false
        assertFalse( pilha.vazia() );
        //empilhar(x-1)
        pilha.empilhar("s2");
        pilha.empilhar("s3");
        //vazia/false
        assertFalse( pilha.vazia() );
    }
    
    @Test
    public void ct02() throws Exception {
        //new (x=3)
        PilhaRestrita pilha = new PilhaRestrita(3);
        //desempilhar/PilhaVaziaException
        try {
            pilha.desempilhar(); 
            fail();
        }catch(PilhaVaziaException ex) { }
        //empilhar
        pilha.empilhar("s1");
        //empilhar(x-1)
        pilha.empilhar("s2");
        pilha.empilhar("s3");
        //empilhar/PilhaCheiaException
        try {
            pilha.empilhar("s4");
            fail();
        }catch(PilhaCheiaException ex) { }
    }
}
