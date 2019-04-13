package Questao1;

/**
 *
 * @author romero
 */
public class IMCStatus {
    double imc;
    String classificacao;

    public IMCStatus(double imc, String classificacao) {
        this.imc = imc;
        this.classificacao = classificacao;
    }

    public double getImc() {
        return imc;
    }

    public String getClassificacao() {
        return classificacao;
    }
}
