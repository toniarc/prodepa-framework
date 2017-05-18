package br.gov.pa.prodepa.controleacesso.commons.domain;

public enum Situacao {

	INATIVO(0, "Inativo"),
	ATIVO(1, "Ativo");
	
	private int codigo;
	private String descricao;
	
	private Situacao(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}