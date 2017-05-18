package br.gov.pa.prodepa.controleacesso.commons.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import br.gov.pa.prodepa.controleacesso.commons.domain.pk.PerfilOperacaoPk;
import br.gov.pa.prodepa.domain.Audit;

@Entity
@Table(name = "perfil_operacao", schema = "controleacesso")
public class PerfilOperacao extends Audit {

	private static final long serialVersionUID = 5756247212715159228L;

	private PerfilOperacaoPk id;
	
	private Perfil perfil;
	
	private Operacao operacao;
	
	public PerfilOperacao() {
	}

	public PerfilOperacao(Perfil perfil, Operacao operacao) {
		this.id = new PerfilOperacaoPk(perfil.getId(), operacao.getId());
		this.perfil = perfil;
		this.operacao = operacao;
	}

	@PrePersist
	@PreRemove
	public void setAuditySetting(){
		this.setIdUsuarioManut(this.perfil.getIdUsuarioManut());
		this.setDataManut(this.perfil.getDataManut());
		this.setCodigoOperacaoManut(this.perfil.getCodigoOperacaoManut());
	}
	
	@EmbeddedId
	public PerfilOperacaoPk getId() {
		return id;
	}

	public void setId(PerfilOperacaoPk id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "id_perfil", insertable = false, updatable = false)
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@ManyToOne
	@JoinColumn(name = "id_operacao", insertable = false, updatable = false)
	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}
	
	
}
