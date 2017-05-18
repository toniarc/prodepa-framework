package br.gov.pa.prodepa.nucleopa.commons.dto;

import java.io.Serializable;

import br.gov.pa.prodepa.nucleopa.commons.domain.Mesorregiao;
import br.gov.pa.prodepa.nucleopa.commons.domain.Regiao;

public class MunicipioDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Regiao regiao;

	private Mesorregiao mesorregiao;

	public MunicipioDto() {
		super();
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public Mesorregiao getMesorregiao() {
		return mesorregiao;
	}

	public void setMesorregiao(Mesorregiao mesorregiao) {
		this.mesorregiao = mesorregiao;
	}
}