package br.gov.pa.prodepa.controleacesso.commons.domain;

public enum TipoDocumento {
	
	CPF(0, "CPF"),
	PASSAPORTE(1, "Nº Passaporte");

	private int codigo;
	private String descricao;
	
	private TipoDocumento(int codigo, String descricao) {
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