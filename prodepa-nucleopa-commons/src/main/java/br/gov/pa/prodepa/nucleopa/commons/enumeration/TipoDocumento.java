package br.gov.pa.prodepa.nucleopa.commons.enumeration;

public enum TipoDocumento {

	CPF (0, "CPF"),
	CNPJ(1, "CNPJ");

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

	@Override
	public String toString() {
		return descricao;
	}
}