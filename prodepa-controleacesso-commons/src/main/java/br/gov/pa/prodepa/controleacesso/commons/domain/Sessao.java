package br.gov.pa.prodepa.controleacesso.commons.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.pa.prodepa.domain.Model;

/**
 * Sessao.
 */
@Entity
@Table(name = "SESSAO", schema = "controleacesso")
public class Sessao implements Model {

	private static final long serialVersionUID = 2055347315439481165L;

	/** Identificador de uma sessao */
	private Long id;

	/** Identificador do usuario */
	private Long idUsuario;
	
	/** Passport critografado de cada sessao */
	private String passaporte;
	
	public Sessao() {
		super();
	}

	public Sessao(Long id, Long idUsuario, String passaporte) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.passaporte = passaporte;
	}

	public Sessao(Long idUsuario, String passaporte) {
		super();
		this.idUsuario = idUsuario;
		this.passaporte = passaporte;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ID_USUARIO", nullable = false)
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "PASSAPORTE", nullable = false)
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
		Sessao other = (Sessao) obj;
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

	@Override
	public String toString() {
		return "usuario: " + idUsuario + " PASSPORT: " + passaporte;
	}
}