package dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaisDTO {
	private int id;
    private String nome;
    private String sigla;
    private int codigoTelefone;
}
