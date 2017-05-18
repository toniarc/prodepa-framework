package br.gov.pa.prodepa.nucleopa.commons.dto.ws;

import java.io.Serializable;

import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.TipoTelefone;

public class TelefoneDtoWs implements Serializable {

  private static final long serialVersionUID = -6503941012872159194L;
  
  private Long id;
  private String ddd;
  private String numero;
  private String descricao;
  private TipoBoleano principal;
  private TipoTelefone tipo;

  public TelefoneDtoWs() {
    super();
    this.principal = TipoBoleano.FALSO;
  }
  
  public TelefoneDtoWs(String ddd, String numero, String descricao, TipoBoleano principal, TipoTelefone tipo) {
    super();
    this.ddd = ddd;
    this.numero = numero;
    this.descricao = descricao;
    this.principal = principal;
    this.tipo = tipo;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDdd() {
    return ddd;
  }

  public void setDdd(String ddd) {
    this.ddd = ddd;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public TipoBoleano getPrincipal() {
    return principal;
  }

  public void setPrincipal(TipoBoleano principal) {
    this.principal = principal;
  }

  public TipoTelefone getTipo() {
    return tipo;
  }

  public void setTipo(TipoTelefone tipo) {
    this.tipo = tipo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((numero == null) ? 0 : numero.hashCode());
    result = prime * result + ((principal == null) ? 0 : principal.hashCode());
    result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
    TelefoneDtoWs other = (TelefoneDtoWs) obj;
    if (ddd == null) {
      if (other.ddd != null)
        return false;
    } else if (!ddd.equals(other.ddd))
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
    if (numero == null) {
      if (other.numero != null)
        return false;
    } else if (!numero.equals(other.numero))
      return false;
    if (principal != other.principal)
      return false;
    if (tipo != other.tipo)
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    return "[ " +ddd+" " + numero + " ]";
  }
  
}

