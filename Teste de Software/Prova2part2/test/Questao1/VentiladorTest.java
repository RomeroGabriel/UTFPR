package Questao1;

import org.junit.Test;
import static org.junit.Assert.*;

public class VentiladorTest {
    
    public VentiladorTest() {
    }
    
    @Test
    public void testBotaoONOFF(){
        //new
        Ventilador ven = new Ventilador();
        //estado desligado
        ven.botaoONOFF();
        assertTrue(ven.ligado());
        //estado velocidade 1
        ven.botaoONOFF();
        assertFalse(ven.ligado());
        //estado velocidade 2
        ven.botaoONOFF(); //vai pro velocidade 1
        ven.aumentarVelocidade();//velocidade 2
        ven.botaoONOFF();
        assertFalse(ven.ligado());
        //estado velocidade 3
        ven.botaoONOFF();
        ven.aumentarVelocidade(); // velocidade 2
        ven.aumentarVelocidade(); //velocidade 3
        ven.botaoONOFF();
        assertFalse(ven.ligado());
    }
    
    @Test
    public void testVelocidade(){
        //new
        Ventilador ven = new Ventilador();
        //estado desligado
        assertEquals(0, ven.velocidade());
        //velocidade 1
        ven.botaoONOFF();
        assertEquals(1, ven.velocidade());
        //velocidade 2
        ven.aumentarVelocidade();
        assertEquals(2, ven.velocidade());
        //velocidade 3
        ven.aumentarVelocidade();
        assertEquals(3, ven.velocidade());
    }
    
    @Test
    public void testRestante(){
        //desligado: totalmente coberto
        //velocidade 1: diminuirVelocidade
        //velocidade 2: ligado, diminiuirVelocidade
        //velocidade 3: ligado, aumentarVelocidade, diminuirVelocidade
        Ventilador ven =  new Ventilador();
        ven.botaoONOFF();
        ven.diminuirVelocidade();
        assertEquals(1, ven.velocidade());
        
        ven.aumentarVelocidade();//vai para velocidade 2
        assertTrue(ven.ligado());//ligado
        ven.diminuirVelocidade();//diminui
        assertEquals(1, ven.velocidade());
        
        ven.aumentarVelocidade();//velocidade 2
        ven.aumentarVelocidade();//velocidade 3
        assertTrue(ven.ligado());//ligado
        ven.aumentarVelocidade();//aumenta
        assertEquals(3, ven.velocidade());
        ven.diminuirVelocidade();//diminiu
        assertEquals(2, ven.velocidade());
    }
}
