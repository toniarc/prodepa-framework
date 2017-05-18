package br.gov.pa.prodepa.nucleopa.commons.enumeration;

public enum Esfera {

	MUNICIPAL("Municipal"),
	ESTADUAL ("Estadual"),
	FEDERAL  ("Federal");

	private String descricao;

	private Esfera(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}