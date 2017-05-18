package br.gov.pa.prodepa.controleacesso.commons.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.gov.pa.prodepa.controleacesso.commons.domain.pk.WSPerfilWSOperacaoPK;
import br.gov.pa.prodepa.domain.Audit;

@Entity
@Table(name="ws_perfil_ws_operacao", schema = "controleacesso")
public class WSPerfilWSOperacao extends Audit implements Comparable<WSPerfilWSOperacao> {

	private static final long serialVersionUID = 3756347535430568488L;

	private WSPerfilWSOperacaoPK id;

	private WSOperacao operacao;
	
	private WSPerfil perfil;

	public WSPerfilWSOperacao() {
		super();
	}

	public WSPerfilWSOperacao(Long idOperacao, String descricaoOperacao){
		this.operacao = new WSOperacao(idOperacao, descricaoOperacao);
		this.perfil = new WSPerfil();
	}
	
	public WSPerfilWSOperacao(WSPerfilWSOperacaoPK id, WSOperacao wsOperacao, WSPerfil wsPerfil) {
		super();
		this.id = id;
		this.operacao = wsOperacao;
		this.perfil = wsPerfil;
	}
	
	@PrePersist
	@PreUpdate
	public void pkConfig(){
		if(this.id == null){
			this.id = new WSPerfilWSOperacaoPK(perfil.getId(), operacao.getId());
		}
	}
	
	@EmbeddedId
	public WSPerfilWSOperacaoPK getId() {
		return id;
	}

	public void setId(WSPerfilWSOperacaoPK id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="id_operacao", insertable=false, updatable=false)
	public WSOperacao getOperacao() {
		return operacao;
	}

	public void setOperacao(WSOperacao wsOperacao) {
		this.operacao = wsOperacao;
	}

	@ManyToOne
	@JoinColumn(name="id_perfil", insertable=false, updatable=false)
	public WSPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(WSPerfil wsPerfil) {
		this.perfil = wsPerfil;
	}

	public int compareTo(WSPerfilWSOperacao o) {
		return this.getOperacao().getDescricao().compareTo(o.getOperacao().getDescricao());
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
		WSPerfilWSOperacao other = (WSPerfilWSOperacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}