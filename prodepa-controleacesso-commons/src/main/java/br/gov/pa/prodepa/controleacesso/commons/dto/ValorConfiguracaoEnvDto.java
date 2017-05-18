package br.gov.pa.prodepa.controleacesso.commons.dto;

public class ValorConfiguracaoEnvDto {

	private String nome; 
	private Long idAplicacao;
	
	public ValorConfiguracaoEnvDto() {
	}

	public ValorConfiguracaoEnvDto(String nome, Long idAplicacao) {
		super();
		this.nome = nome;
		this.idAplicacao = idAplicacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdAplicacao() {
		return idAplicacao;
	}

	public void setIdAplicacao(Long idAplicacao) {
		this.idAplicacao = idAplicacao;
	}
	
	
}
