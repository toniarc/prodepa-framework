package br.gov.pa.prodepa.controleacesso.commons.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WSUsuarioWSPerfilPK implements Serializable {

	private static final long serialVersionUID = -5950577488097618677L;

	private Long idUsuario;
	
	private Long idPerfil;

	public WSUsuarioWSPerfilPK() {
		super();
	}

	public WSUsuarioWSPerfilPK(Long idUsuario, Long idPerfil) {
		super();
		this.idUsuario = idUsuario;
		this.idPerfil = idPerfil;
	}

	@Column(name = "id_usuario")
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "id_perfil")
	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPerfil == null) ? 0 : idPerfil.hashCode());
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		WSUsuarioWSPerfilPK other = (WSUsuarioWSPerfilPK) obj;
		if (idPerfil == null) {
			if (other.idPerfil != null)
				return false;
		} else if (!idPerfil.equals(other.idPerfil))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
}