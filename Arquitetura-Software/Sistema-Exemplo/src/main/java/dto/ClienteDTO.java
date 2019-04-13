package dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClienteDTO {
	private int id;
    private String nome;
    private int idade;
    private String telefone;
    private double limiteCredito;
    private PaisDTO pais;
}
