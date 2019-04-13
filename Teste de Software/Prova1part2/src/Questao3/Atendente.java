package Questao3;
/**
 * @author romero
 */
public class Atendente {
   private ProdutoDAO produtoDAO; 

    public Atendente(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }
   
   public String efetuarPedidoDeOrcamento(String codigoDeBarras, int quantidade)
           throws IllegalArgumentException, SemEstoqueException{
       return"";
   }
}
