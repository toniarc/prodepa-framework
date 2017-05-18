package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;

import br.gov.pa.prodepa.controleacesso.commons.domain.Aplicacao;
import br.gov.pa.prodepa.controleacesso.commons.domain.Situacao;
import br.gov.pa.prodepa.nucleopa.commons.domain.Orgao;

public class BuscaDto implements Serializable {

	private static final long serialVersionUID = -6180657542041817568L;

	private Orgao orgao;
	private Aplicacao aplicacao;
	private Situacao situacao;

	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
}