package br.gov.pa.prodepa.controleacesso.commons.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.pa.prodepa.controleacesso.commons.domain.pk.UsuarioPerfilPK;
import br.gov.pa.prodepa.domain.Audit;

@Entity
@Table(name = "USUARIO_PERFIL", schema = "controleacesso")
public class UsuarioPerfil extends Audit {

	private static final long serialVersionUID = 8332268116199768616L;

	private UsuarioPerfilPK id;

	private Usuario usuario;

	private Perfil perfil;

	public UsuarioPerfil() {
	}
	
	public UsuarioPerfil(Long idUsuario, Long idPerfil) {
		this.id = new UsuarioPerfilPK(idUsuario, idPerfil);
	}
	
	//p.id, p.codigo, p.descricao
	public UsuarioPerfil(Long idUsuario, Long idPerfil, String codigoPerfil, String descricao){
		this.id = new UsuarioPerfilPK(idUsuario, idPerfil);
		this.usuario = new Usuario(idUsuario);
		this.perfil = new Perfil(idPerfil, codigoPerfil, descricao);
	}
	
	//up.idUsuario, up.idPerfil, p.descricao, ap.id, ap.descricao
	public UsuarioPerfil(Long idUsuario, Long idPerfil, String descricaoPerfil, Long idAplicacao, String decricaoAplicacao){
		this.usuario = new Usuario(idUsuario);
		this.id = new UsuarioPerfilPK(idUsuario, idPerfil);
		this.perfil = new Perfil(idPerfil, null, descricaoPerfil);
		this.perfil.setAplicacao(new Aplicacao(idAplicacao, decricaoAplicacao));
	}
	
	public UsuarioPerfil(UsuarioPerfilPK id) {
		this.id = id;
	}

	public UsuarioPerfil(Usuario usuario, Perfil perfil) {
		this.usuario = usuario;
		this.perfil = perfil;
	}

	@EmbeddedId
	public UsuarioPerfilPK getId() {
		return id;
	}

	public void setId(UsuarioPerfilPK id) {
		this.id = id;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_perfil", insertable = false, updatable = false)
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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
		UsuarioPerfil other = (UsuarioPerfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}