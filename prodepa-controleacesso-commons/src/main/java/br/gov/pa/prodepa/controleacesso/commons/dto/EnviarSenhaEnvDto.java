package br.gov.pa.prodepa.controleacesso.commons.dto;

public class EnviarSenhaEnvDto {

	private Integer tipoDocumento; 
	private String numeroDocumento; 
	private String email;
	
	public EnviarSenhaEnvDto() {
	}

	public EnviarSenhaEnvDto(Integer tipoDocumento, String numeroDocumento,
			String email) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.email = email;
	}

	public Integer getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
