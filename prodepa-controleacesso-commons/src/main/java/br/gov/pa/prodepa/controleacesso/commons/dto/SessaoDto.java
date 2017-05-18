package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;

/**
 * Objeto de transporte de dados de uma sessao.
 */
public class SessaoDto implements Serializable {

	private static final long serialVersionUID = -4348390058333722810L;

	/** Identificador da sessao. */
	private Long id;

	/** Identificador de um usuario. */
	private Long idUsuario;

	/** Passaporte da sessao. */
	private String passaporte;

	public SessaoDto() {
		super();
	}

	public SessaoDto(Long id, Long idUsuario, String passaporte) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.passaporte = passaporte;
	}

	public SessaoDto(Long idUsuario, String passaporte) {
		super();
		this.idUsuario = idUsuario;
		this.passaporte = passaporte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((passaporte == null) ? 0 : passaporte.hashCode());
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
		SessaoDto other = (SessaoDto) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (passaporte == null) {
			if (other.passaporte != null)
				return false;
		} else if (!passaporte.equals(other.passaporte))
			return false;
		return true;
	}
}