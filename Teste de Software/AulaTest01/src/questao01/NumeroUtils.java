package questao01;

/**
 *
 * @author Aluno
 */
public class NumeroUtils {

    public int maior(int x, int y) {
        if(x > y)
            return x;
        else
            return y;
    }
    
    public boolean ehInteiroValido(String entrada) {
        try {
            int num = Integer.parseInt(entrada);
        }catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    
}
