package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;


public class AutenticarEnvDto implements Serializable{

	private static final long serialVersionUID = -202242461962571452L;
	
	private String login; 
	private String senha;
	
	public AutenticarEnvDto() {
	}

	public AutenticarEnvDto(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
