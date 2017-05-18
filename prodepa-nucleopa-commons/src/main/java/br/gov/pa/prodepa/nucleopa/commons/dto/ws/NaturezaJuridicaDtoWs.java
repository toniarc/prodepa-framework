package br.gov.pa.prodepa.nucleopa.commons.dto.ws;

import java.io.Serializable;
import java.util.Date;

import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;

public class NaturezaJuridicaDtoWs implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private TipoBoleano ativo;
	private Date dataManutencao;
	private Long idUsuarioManutencao;
	
	public NaturezaJuridicaDtoWs() {
		super();
	}

	public NaturezaJuridicaDtoWs(Long id) {
		super();
		this.id = id;
	}

	public NaturezaJuridicaDtoWs(TipoBoleano ativo) {
		super();
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoBoleano getAtivo() {
		return ativo;
	}

	public void setAtivo(TipoBoleano ativo) {
		this.ativo = ativo;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public Long getIdUsuarioManutencao() {
		return idUsuarioManutencao;
	}

	public void setIdUsuarioManutencao(Long idUsuarioManutencao) {
		this.idUsuarioManutencao = idUsuarioManutencao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NaturezaJuridicaDtoWs other = (NaturezaJuridicaDtoWs) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id == null ? null : id.toString();
	}
}