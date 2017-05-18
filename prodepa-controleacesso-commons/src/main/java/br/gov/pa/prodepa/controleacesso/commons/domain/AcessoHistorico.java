package br.gov.pa.prodepa.controleacesso.commons.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.gov.pa.prodepa.controleacesso.commons.domain.pk.AcessoHistoricoPK;
import br.gov.pa.prodepa.domain.Model;

@Entity
@Table(name = "acesso_historico", schema = "controleacesso")
public class AcessoHistorico implements Model {

	private static final long serialVersionUID = -4315494341089229092L;

	private AcessoHistoricoPK id;
	
	private Sessao sessao;
	
	private Aplicacao aplicacao;
	
	private Usuario usuario;

	private Date ultimoAcesso;

	public AcessoHistorico() {
		super();
	}
	
	@EmbeddedId
	public AcessoHistoricoPK getId() {
		return id;
	}

	public void setId(AcessoHistoricoPK id) {
		this.id = id;
	}

	@Transient
	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	@ManyToOne
	@JoinColumn(name = "id_aplicacao", insertable = false, updatable = false)
	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	@ManyToOne
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultimo_acesso", nullable = false)
	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
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
		AcessoHistorico other = (AcessoHistorico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}