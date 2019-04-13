package dto;

import lombok.Builder;

@Builder
public class PaisDTO {
	private int id;
    private String nome;
    private String sigla;
    private int codigoTelefone;
}
