package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;

public class AtualizarAcessoEnvDto implements Serializable {

	private static final long serialVersionUID = 1330996199442733494L;

	private Long idAplicacao; 
	private String login; 
	private String passaporte;
	
	public AtualizarAcessoEnvDto() {
	}

	public AtualizarAcessoEnvDto(Long idAplicacao, String login, String passaporte) {
		super();
		this.idAplicacao = idAplicacao;
		this.login = login;
		this.passaporte = passaporte;
	}

	public Long getIdAplicacao() {
		return idAplicacao;
	}

	public void setIdAplicacao(Long idAplicacao) {
		this.idAplicacao = idAplicacao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}
	
}
