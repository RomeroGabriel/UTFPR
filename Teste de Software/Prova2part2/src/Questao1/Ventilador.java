package Questao1;

public class Ventilador {
    private boolean ligado = false;
    private int velocidade = 0;
    
    public void botaoONOFF(){
        ligado = !ligado;
        velocidade = ligado ? 1 : 0;
    }
    
    public boolean ligado(){
        return ligado;
    } 
    
    public void aumentarVelocidade(){
        if(velocidade < 3) velocidade++;
    }
    
    public void diminuirVelocidade(){
        if(velocidade > 1) velocidade--;
    }
    
    public int velocidade(){
        return velocidade;
    }
}
