package br.gov.pa.prodepa.controleacesso.commons.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.pa.prodepa.controleacesso.commons.domain.pk.AcessoPK;

@Entity
@Table(name = "ACESSO", schema = "controleacesso")
public class Acesso implements Serializable {

	private static final long serialVersionUID = 3236544964495627925L;

	private AcessoPK id;

	private Aplicacao aplicacao;

	private Sessao sessao;

	private Date primeiroAcesso;

	private Date ultimoAcesso;

	public Acesso() {
		super();
	}

	public Acesso(AcessoPK id, Date primeiroAcesso, Date ultimoAcesso) {
		super();
		this.id = id;
		this.primeiroAcesso = primeiroAcesso;
		this.ultimoAcesso = ultimoAcesso;
	}

	public Acesso(Sessao sessao, Aplicacao aplicacao, Date primeiroAcesso,
			Date ultimoAcesso) {
		super();
		this.sessao = sessao;
		this.aplicacao = aplicacao;
		this.primeiroAcesso = primeiroAcesso;
		this.ultimoAcesso = ultimoAcesso;
	}

	@EmbeddedId
	public AcessoPK getId() {
		return id;
	}

	public void setId(AcessoPK id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "primeiro_acesso", nullable = false)
	public Date getPrimeiroAcesso() {
		return primeiroAcesso;
	}

	public void setPrimeiroAcesso(Date primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultimo_acesso", nullable = false)
	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
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
	@JoinColumn(name = "id_sessao", insertable = false, updatable = false)
	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
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
		Acesso other = (Acesso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}