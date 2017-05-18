package br.gov.pa.prodepa.nucleopa.commons.dto;

import java.io.Serializable;

import br.gov.pa.prodepa.nucleopa.commons.domain.Estado;

public class BairroDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Estado estado;

	public BairroDto() {
		super();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}