package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.Date;

import br.gov.pa.prodepa.controleacesso.commons.domain.Aplicacao;
import br.gov.pa.prodepa.controleacesso.commons.domain.Sessao;

public class AcessoDto implements Serializable {

	private static final long serialVersionUID = -8999181563745353900L;

	private Sessao sessao;
	private Aplicacao aplicacao;
	private Date primeiroAcesso;
	private Date ultimoAcesso;

	private Long idSessao;
	private Long idUsuario;
	private Long idAplicacao;

	public AcessoDto() {
		super();
	}

	public AcessoDto(Sessao sessao, Aplicacao aplicacao, Date primeiroAcesso, Date ultimoAcesso) {
		super();
		this.sessao = sessao;
		this.aplicacao = aplicacao;
		this.primeiroAcesso = primeiroAcesso;
		this.ultimoAcesso = ultimoAcesso;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public Date getPrimeiroAcesso() {
		return primeiroAcesso;
	}

	public void setPrimeiroAcesso(Date primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public Long getIdSessao() {
		return idSessao;
	}

	public void setIdSessao(Long idSessao) {
		this.idSessao = idSessao;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

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
		result = prime * result + ((aplicacao == null) ? 0 : aplicacao.hashCode());
		result = prime * result + ((idAplicacao == null) ? 0 : idAplicacao.hashCode());
		result = prime * result + ((idSessao == null) ? 0 : idSessao.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((primeiroAcesso == null) ? 0 : primeiroAcesso.hashCode());
		result = prime * result + ((sessao == null) ? 0 : sessao.hashCode());
		result = prime * result + ((ultimoAcesso == null) ? 0 : ultimoAcesso.hashCode());
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
		AcessoDto other = (AcessoDto) obj;
		if (aplicacao == null) {
			if (other.aplicacao != null)
				return false;
		} else if (!aplicacao.equals(other.aplicacao))
			return false;
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
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (primeiroAcesso == null) {
			if (other.primeiroAcesso != null)
				return false;
		} else if (!primeiroAcesso.equals(other.primeiroAcesso))
			return false;
		if (sessao == null) {
			if (other.sessao != null)
				return false;
		} else if (!sessao.equals(other.sessao))
			return false;
		if (ultimoAcesso == null) {
			if (other.ultimoAcesso != null)
				return false;
		} else if (!ultimoAcesso.equals(other.ultimoAcesso))
			return false;
		return true;
	}
}