package br.gov.pa.prodepa.controleacesso.commons.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import br.gov.pa.prodepa.controleacesso.commons.domain.pk.WSUsuarioWSPerfilPK;
import br.gov.pa.prodepa.domain.Audit;

@Entity
@Table(name = "ws_usuario_ws_perfil", schema = "controleacesso")
public class WSUsuarioWSPerfil extends Audit implements Comparable<WSUsuarioWSPerfil> {

	private static final long serialVersionUID = -1071035813133374262L;

	private WSUsuarioWSPerfilPK id;

	private WSUsuario wsUsuario;
					 
	private WSPerfil wsPerfil;

	public WSUsuarioWSPerfil() {
		super();
	}

	public WSUsuarioWSPerfil(Long idPerfil, String descricaoPerfil){
		this.wsPerfil = new WSPerfil(idPerfil, descricaoPerfil);
	}
	
	public WSUsuarioWSPerfil(WSUsuarioWSPerfilPK id, WSUsuario wsUsuario, WSPerfil wsPerfil) {
		this.id = id;
		this.wsUsuario = wsUsuario;
		this.wsPerfil = wsPerfil;
	}
	
	@PrePersist
	public void beforePersist(){
		if(this.wsPerfil != null && this.wsUsuario != null){
			this.id = new WSUsuarioWSPerfilPK(this.wsUsuario.getId(), this.wsPerfil.getId());
		}
	}

	@EmbeddedId
	public WSUsuarioWSPerfilPK getId() {
		return id;
	}

	public void setId(WSUsuarioWSPerfilPK id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	public WSUsuario getWsUsuario() {
		return wsUsuario;
	}

	public void setWsUsuario(WSUsuario wsUsuario) {
		this.wsUsuario = wsUsuario;
	}

	@ManyToOne
	@JoinColumn(name = "id_perfil", insertable = false, updatable = false)
	public WSPerfil getWsPerfil() {
		return wsPerfil;
	}

	public void setWsPerfil(WSPerfil wsPerfil) {
		this.wsPerfil = wsPerfil;
	}

	public int compareTo(WSUsuarioWSPerfil o) {
		return this.getWsPerfil().getDescricao().compareTo(o.getWsPerfil().getDescricao());
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
		WSUsuarioWSPerfil other = (WSUsuarioWSPerfil) obj;
		
		if (id == null) {
			if(wsPerfil != null && other.getWsPerfil() != null){
				if(wsPerfil.equals(other.getWsPerfil())){
					return true;
				} else {
					return false;
				}
			}
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}