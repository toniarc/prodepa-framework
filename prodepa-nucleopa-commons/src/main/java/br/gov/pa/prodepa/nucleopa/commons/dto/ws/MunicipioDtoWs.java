package br.gov.pa.prodepa.nucleopa.commons.dto.ws;

import java.io.Serializable;
import java.util.Date;

import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;

public class MunicipioDtoWs implements Serializable {

	private static final long serialVersionUID = 188123637128419L;
	
	private Long id;
	private String descricao;
	private EstadoDtoWs estado;
	private TipoBoleano ativo;
	private String codigoIbge;
	private Date dataManut;
	private Long idUsuarioManut;

	public MunicipioDtoWs() {
		super();
		this.ativo = TipoBoleano.VERDADEIRO;
	}

	public MunicipioDtoWs(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public MunicipioDtoWs(Long id, String descricao, EstadoDtoWs estado,
			TipoBoleano ativo, String codigoIbge) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.estado = estado;
		this.ativo = ativo;
		this.codigoIbge = codigoIbge;
	}

	public MunicipioDtoWs(Long id, String descricao, EstadoDtoWs estado,
			TipoBoleano ativo, String codigoIbge, Date dataManut,
			Long idUsuarioManut) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.estado = estado;
		this.ativo = ativo;
		this.codigoIbge = codigoIbge;
		this.dataManut = dataManut;
		this.idUsuarioManut = idUsuarioManut;
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

	public EstadoDtoWs getEstado() {
		return estado;
	}

	public void setEstado(EstadoDtoWs estado) {
		this.estado = estado;
	}

	public TipoBoleano getAtivo() {
		return ativo;
	}

	public void setAtivo(TipoBoleano ativo) {
		this.ativo = ativo;
	}

	public String getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public Date getDataManut() {
		return dataManut;
	}

	public void setDataManut(Date dataManut) {
		this.dataManut = dataManut;
	}

	public Long getIdUsuarioManut() {
		return idUsuarioManut;
	}

	public void setIdUsuarioManut(Long idUsuarioManut) {
		this.idUsuarioManut = idUsuarioManut;
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
		MunicipioDtoWs other = (MunicipioDtoWs) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.descricao;
	}

}

