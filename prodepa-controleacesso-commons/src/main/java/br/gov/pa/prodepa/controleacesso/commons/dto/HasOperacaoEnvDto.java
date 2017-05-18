package br.gov.pa.prodepa.controleacesso.commons.dto;

public class HasOperacaoEnvDto {

	private Long idUsuario; 
	private String operacao;
	
	public HasOperacaoEnvDto() {
	}

	public HasOperacaoEnvDto(Long idUsuario, String operacao) {
		super();
		this.idUsuario = idUsuario;
		this.operacao = operacao;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
	
}
