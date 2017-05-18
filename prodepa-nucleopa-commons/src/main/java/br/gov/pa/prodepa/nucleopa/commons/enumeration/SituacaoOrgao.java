package br.gov.pa.prodepa.nucleopa.commons.enumeration;

public enum SituacaoOrgao {

	INATIVO(0, "Inativo", false),
	ATIVO  (1, "Ativo", true),
	EXTINTO(2, "Extinto", false);

	private int codigo;
	private String descricao;
	private boolean condicao;

	private SituacaoOrgao(int codigo, String descricao, boolean condicao) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.condicao = condicao;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public boolean isCondicao() {
		return condicao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}