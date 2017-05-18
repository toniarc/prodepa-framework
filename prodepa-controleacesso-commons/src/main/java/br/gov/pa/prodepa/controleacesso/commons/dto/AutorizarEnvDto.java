package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;

public class AutorizarEnvDto implements Serializable{

	private static final long serialVersionUID = -2342594735157490310L;
	
	private Long idAplicacao; 
	private String passaporte;
	
	public AutorizarEnvDto() {
	}

	public AutorizarEnvDto(Long idAplicacao, String passaporte) {
		super();
		this.idAplicacao = idAplicacao;
		this.passaporte = passaporte;
	}

	public Long getIdAplicacao() {
		return idAplicacao;
	}

	public void setIdAplicacao(Long idAplicacao) {
		this.idAplicacao = idAplicacao;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

}
