package br.gov.pa.prodepa.nucleopa.commons.dto;

import java.io.Serializable;

import br.gov.pa.prodepa.nucleopa.commons.domain.Regiao;

public class RegionalDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Regiao regiao;

	public RegionalDto() {
		super();
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
}