package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.Date;

public class AplicacaoAcessoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idAplicacao;
  private String aplicacao;
  private String contexto;
	private Long quantidade;
	private Date ultimoAcesso;

	public AplicacaoAcessoDto() {
		super();
	}

	public AplicacaoAcessoDto(Long idAplicacao, String aplicacao, String contexto, Long quantidade, Date ultimoAcesso) {
    super();
    this.idAplicacao = idAplicacao;
    this.aplicacao = aplicacao;
    this.contexto = contexto;
    this.quantidade = quantidade;
    this.ultimoAcesso = ultimoAcesso;
  }

  public Long getIdAplicacao() {
    return idAplicacao;
  }

  public void setIdAplicacao(Long idAplicacao) {
    this.idAplicacao = idAplicacao;
  }

  public String getAplicacao() {
    return aplicacao;
  }

  public void setAplicacao(String aplicacao) {
    this.aplicacao = aplicacao;
  }

  public String getContexto() {
    return contexto;
  }

  public void setContexto(String contexto) {
    this.contexto = contexto;
  }

  public Long getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Long quantidade) {
    this.quantidade = quantidade;
  }

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
    result = prime * result + ((aplicacao == null) ? 0 : aplicacao.hashCode());
    result = prime * result + ((contexto == null) ? 0 : contexto.hashCode());
    result = prime * result + ((idAplicacao == null) ? 0 : idAplicacao.hashCode());
    result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
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
    AplicacaoAcessoDto other = (AplicacaoAcessoDto) obj;
    if (aplicacao == null) {
      if (other.aplicacao != null)
        return false;
    } else if (!aplicacao.equals(other.aplicacao))
      return false;
    if (contexto == null) {
      if (other.contexto != null)
        return false;
    } else if (!contexto.equals(other.contexto))
      return false;
    if (idAplicacao == null) {
      if (other.idAplicacao != null)
        return false;
    } else if (!idAplicacao.equals(other.idAplicacao))
      return false;
    if (quantidade == null) {
      if (other.quantidade != null)
        return false;
    } else if (!quantidade.equals(other.quantidade))
      return false;
    if (ultimoAcesso == null) {
      if (other.ultimoAcesso != null)
        return false;
    } else if (!ultimoAcesso.equals(other.ultimoAcesso))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return aplicacao + " (" + quantidade + ") [" + ultimoAcesso + "]";
  }
}