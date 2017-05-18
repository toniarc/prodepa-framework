package br.gov.pa.prodepa.controleacesso.commons.domain;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.gov.pa.prodepa.controleacesso.commons.constants.ControleAcesso;
import br.gov.pa.prodepa.controleacesso.commons.domain.pk.UsuarioPerfilAplicacaoPK;
import br.gov.pa.prodepa.domain.Audit;

@Entity
@Table(name = "usuario_perfil_aplicacao", schema = "controleacesso")
public class UsuarioPerfilAplicacao extends Audit implements Comparable<UsuarioPerfilAplicacao> {

	private static final long serialVersionUID = -4309200991548268302L;

	private UsuarioPerfilAplicacaoPK id;

	private UsuarioPerfil usuarioPerfil;

	private Aplicacao aplicacao;
	
	public UsuarioPerfilAplicacao() {
	}

	public UsuarioPerfilAplicacao(UsuarioPerfilAplicacaoPK id) {
		this.id = id;
	}

	public UsuarioPerfilAplicacao(UsuarioPerfil usuarioPerfil, Aplicacao aplicacao) {
		this.usuarioPerfil = usuarioPerfil;
		this.aplicacao = aplicacao;
	}
	
	public UsuarioPerfilAplicacao(Long idUsuario, Long idPerfil, String codigoPerfil, Long idAplicacao, String nomeAplicacao){
		this.id = new UsuarioPerfilAplicacaoPK(idUsuario, idAplicacao, idPerfil);
		this.usuarioPerfil = new UsuarioPerfil(idUsuario, idPerfil, codigoPerfil, null);
		this.aplicacao = new Aplicacao(idAplicacao, nomeAplicacao);
	}

	@EmbeddedId
	public UsuarioPerfilAplicacaoPK getId() {
		return id;
	}

	public void setId(UsuarioPerfilAplicacaoPK id) {
		this.id = id;
	}

	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumns({
			@JoinColumn(name = "id_usuario", referencedColumnName="id_usuario", insertable = false, updatable = false),
			@JoinColumn(name = "id_perfil", referencedColumnName="id_perfil", insertable = false, updatable = false) })
	public UsuarioPerfil getUsuarioPerfil() {
		return usuarioPerfil;
	}

	public void setUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_aplicacao", insertable = false, updatable = false)
	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	@Transient
	public String getDescricaoGerente(){
		if(usuarioPerfil != null && usuarioPerfil.getPerfil() != null){
			if(usuarioPerfil.getPerfil().getCodigo().equals(ControleAcesso.CODIGO_PERFIL_GERENTE_SISTEMA)){
				return "Gerente Sistema";
			}
			
			if(usuarioPerfil.getPerfil().getCodigo().equals(ControleAcesso.CODIGO_PERFIL_GERENTE_SISTEMA_ORGAO)){
				return "Gerente Órgão";
			}
		}
		return null;
	}
	
	public int compareTo(UsuarioPerfilAplicacao o) {
		return this.getAplicacao().getNome().compareTo(o.getAplicacao().getNome());
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
		UsuarioPerfilAplicacao other = (UsuarioPerfilAplicacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}