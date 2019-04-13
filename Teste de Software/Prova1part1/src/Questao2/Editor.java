package Questao2;

import java.util.List;

/**
 *
 * @author romero
 */
public class Editor {
    RepositorioDePalavras repo;
    CorretorOrtografico corretor;

    public void setRepo(RepositorioDePalavras repo) {
        this.repo = repo;
    }

    public void setCorretor(CorretorOrtografico corretor) {
        this.corretor = corretor;
    }
    
    public String podePublicar(Noticia noticia){
        List<String> palProibidas = repo.getListaDePalavrasProibidas();
        for(String palProibida : palProibidas){
            String titulo = noticia.getTitulo();
            if(titulo.contains(palProibida))
                return "titulo contem a palavra " + palProibida;
            
            String texto = noticia.getTexto();
            if(texto.contains(palProibida))
                return "texto contem a palavra "+ palProibida;
        }
        
        int numErros = corretor.verificarGramatica(noticia);
        if(numErros != 0)
            return "titulo e texto com erros: " +numErros;
        
        return "autorizado";
    }
}
