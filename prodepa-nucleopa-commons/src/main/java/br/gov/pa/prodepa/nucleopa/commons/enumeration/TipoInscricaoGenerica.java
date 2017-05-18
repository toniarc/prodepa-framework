package br.gov.pa.prodepa.nucleopa.commons.enumeration;

public enum TipoInscricaoGenerica {

	FISICA       (0, "Pessoa Física"),
	JURIDICA     (1, "Pessoa Jurídica"),
	NAO_INFORMADO(2, "Não Informado");

	private int codigo;
	private String descricao;

	private TipoInscricaoGenerica(int codigo, String descricao) {
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