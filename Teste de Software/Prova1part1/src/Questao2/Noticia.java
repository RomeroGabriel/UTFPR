package Questao2;

/**
 *
 * @author romero
 */
public class Noticia {
    String titulo;
    String texto;

    public Noticia(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }
}
