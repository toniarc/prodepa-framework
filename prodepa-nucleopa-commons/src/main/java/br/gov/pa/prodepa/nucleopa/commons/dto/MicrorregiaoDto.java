package br.gov.pa.prodepa.nucleopa.commons.dto;

import java.io.Serializable;

import br.gov.pa.prodepa.nucleopa.commons.domain.Estado;
import br.gov.pa.prodepa.nucleopa.commons.domain.Regiao;

public class MicrorregiaoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Regiao regiao;

	private Estado estado;

	public MicrorregiaoDto() {
		super();
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}