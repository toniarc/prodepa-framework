package br.gov.pa.prodepa.nucleopa.commons.enumeration;

public enum TipoLocalidade {

	D("Distrito"),
	M("Município"),
	P("Povoado");

	private String descricao;

	private TipoLocalidade(String descricao) {
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