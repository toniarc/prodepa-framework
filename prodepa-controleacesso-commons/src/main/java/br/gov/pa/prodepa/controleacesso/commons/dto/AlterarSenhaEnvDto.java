package br.gov.pa.prodepa.controleacesso.commons.dto;

public class AlterarSenhaEnvDto {

	private String login; 
	private String senhaAtual; 
	private String novaSenha;
	
	public AlterarSenhaEnvDto() {
	}

	public AlterarSenhaEnvDto(String login, String senhaAtual, String novaSenha) {
		super();
		this.login = login;
		this.senhaAtual = senhaAtual;
		this.novaSenha = novaSenha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}
	
}
