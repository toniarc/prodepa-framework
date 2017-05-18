package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.Date;

import br.gov.pa.prodepa.controleacesso.commons.domain.Situacao;
import br.gov.pa.prodepa.controleacesso.commons.domain.Usuario;

public class HistoricoSituacaoDto implements Serializable {

	private static final long serialVersionUID = -7368553283358926502L;
	
	private Long id;
	private Usuario idUsuario;
	private Usuario idUsuarioManut;
	private Date data;
	private String motivo;
	private Situacao situacao;
	
	public HistoricoSituacaoDto() {
		super();
	}

	public HistoricoSituacaoDto(Long id, Usuario idUsuario, Long idUsuarioManut, Date data, String motivo, Situacao situacao) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
//		this.idUsuarioManut = idUsuarioManut;
		this.data = data;
		this.motivo = motivo;
		this.situacao = situacao;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario getIdUsuarioManut() {
		return idUsuarioManut;
	}

	public void setIdUsuarioManut(Usuario idUsuarioManut) {
		this.idUsuarioManut = idUsuarioManut;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime
				* result
				+ ((idUsuarioManut == null) ? 0 : idUsuarioManut.hashCode());
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
		HistoricoSituacaoDto other = (HistoricoSituacaoDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (idUsuarioManut == null) {
			if (other.idUsuarioManut != null)
				return false;
		} else if (!idUsuarioManut.equals(other.idUsuarioManut))
			return false;
		return true;
	}
}