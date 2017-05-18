package br.gov.pa.prodepa.nucleopa.commons.dto.ws;

import java.io.Serializable;

import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;

public class EstadoDtoWs implements Serializable {

  private static final long serialVersionUID = 188123637125489L;

  private Long id;
  private String descricao;
  private String uf;
  private TipoBoleano ativo;
  private String codigoIbge;
  
  public EstadoDtoWs() {
    super();
    this.ativo = TipoBoleano.VERDADEIRO;
  }

  public EstadoDtoWs(Long id, String uf, String descricao) {
    super();
    this.id = id;
    this.uf = uf;
    this.descricao = descricao;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public TipoBoleano getAtivo() {
    return ativo;
  }

  public void setAtivo(TipoBoleano ativo) {
    this.ativo = ativo;
  }
  
  public String getCodigoIbge() {
    return codigoIbge;
  }

  public void setCodigoIbge(String codigoIbge) {
    this.codigoIbge = codigoIbge;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
    result = prime * result + ((codigoIbge == null) ? 0 : codigoIbge.hashCode());
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
    EstadoDtoWs other = (EstadoDtoWs) obj;
    if (ativo != other.ativo)
      return false;
    if (codigoIbge == null) {
      if (other.codigoIbge != null)
        return false;
    } else if (!codigoIbge.equals(other.codigoIbge))
      return false;
    if (descricao == null) {
      if (other.descricao != null)
        return false;
    } else if (!descricao.equals(other.descricao))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (uf == null) {
      if (other.uf != null)
        return false;
    } else if (!uf.equals(other.uf))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return this.descricao;
  }

}

