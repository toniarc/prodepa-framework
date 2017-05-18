package br.gov.pa.prodepa.controleacesso.commons.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AcessoPK implements Serializable {

	private static final long serialVersionUID = -6099024192501855038L;

	private Long idSessao;

	private Long idAplicacao;

	public AcessoPK() {
		super();
	}

	public AcessoPK(Long idSessao, Long idAplicacao) {
		super();
		this.idSessao = idSessao;
		this.idAplicacao = idAplicacao;
	}

	@Column(name = "id_sessao")
	public Long getIdSessao() {
		return idSessao;
	}

	public void setIdSessao(Long idSessao) {
		this.idSessao = idSessao;
	}

	@Column(name = "id_aplicacao")
	public Long getIdAplicacao() {
		return idAplicacao;
	}

	public void setIdAplicacao(Long idAplicacao) {
		this.idAplicacao = idAplicacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAplicacao == null) ? 0 : idAplicacao.hashCode());
		result = prime * result + ((idSessao == null) ? 0 : idSessao.hashCode());
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
		AcessoPK other = (AcessoPK) obj;
		if (idAplicacao == null) {
			if (other.idAplicacao != null)
				return false;
		} else if (!idAplicacao.equals(other.idAplicacao))
			return false;
		if (idSessao == null) {
			if (other.idSessao != null)
				return false;
		} else if (!idSessao.equals(other.idSessao))
			return false;
		return true;
	}
}