/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao2;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;

/**
 *
 * @author romero
 */
public class EditorTest {
    
    public EditorTest() {
    }
    
    RepositorioDePalavras repoMock;
    CorretorOrtografico corretorMock;
    Noticia noticia;
    Editor editor;
    List<String> palProibidas;
    
    @Before
    public void configura(){
        String titulo = "Liverpool Ganhou";
        String texto = "Liverpool ganha fácil do City, time pequeno";
        noticia = new Noticia(titulo, texto);
        repoMock = mock(RepositorioDePalavras.class);
        corretorMock = mock(CorretorOrtografico.class);
        editor = new Editor();
        editor.setCorretor(corretorMock);
        editor.setRepo(repoMock);
        palProibidas = new ArrayList<>();
        
        when(repoMock.getListaDePalavrasProibidas()).thenReturn(palProibidas);
        when(corretorMock.verificarGramatica(noticia)).thenReturn(2);
    }
    
    @Test
    public void tituloPalavraProibida(){
        palProibidas.add("Ganhou");
        assertEquals("titulo contem a palavra Ganhou", editor.podePublicar(noticia));
    }
    
    @Test
    public void textoPalavraProibida(){
        palProibidas.add("City");
        assertEquals("texto contem a palavra City", editor.podePublicar(noticia));
    }
    
    @Test
    public void tituloTextoPalavraProibida(){
        String titulo = "liverpool ganha UCL";
        String texto = "E corinthians humilha o palmeiras";
        palProibidas.add("UCL");
        palProibidas.add("palmeiras");
        assertEquals("titulo e texto com erros: 2", editor.podePublicar(noticia));
    }
    
    @Test
    public void autorizado(){
        when(corretorMock.verificarGramatica(noticia)).thenReturn(0);
        assertEquals("autorizado", editor.podePublicar(noticia));
    }
}
