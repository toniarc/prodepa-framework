package br.gov.pa.prodepa.nucleopa.commons.enumeration;

public enum Poder {

	EXECUTIVO  (0, "Executivo"),
	LEGISLATIVO(1, "Legislativo"),
	JUDICIARIO (2, "Judiciário");

	private int codigo;
	private String descricao;

	private Poder(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}