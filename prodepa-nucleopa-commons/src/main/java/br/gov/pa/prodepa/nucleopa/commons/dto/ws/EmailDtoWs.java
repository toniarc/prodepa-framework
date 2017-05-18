package br.gov.pa.prodepa.nucleopa.commons.dto.ws;

import java.io.Serializable;

import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;

public class EmailDtoWs implements Serializable {

  private static final long serialVersionUID = 3754036547116355217L;
  
  private Long id;
  private String email;
  private String descricao;
  private TipoBoleano principal;


  public EmailDtoWs() {
    super();
    this.principal = TipoBoleano.FALSO;
  }
  
  public EmailDtoWs(String email, String descricao, TipoBoleano principal) {
    super();
    this.email = email;
    this.descricao = descricao;
    this.principal = principal;
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

  public TipoBoleano getPrincipal() {
    return principal;
  }

  public void setPrincipal(TipoBoleano principal) {
    this.principal = principal;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((principal == null) ? 0 : principal.hashCode());
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
    EmailDtoWs other = (EmailDtoWs) obj;
    if (descricao == null) {
      if (other.descricao != null)
        return false;
    } else if (!descricao.equals(other.descricao))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (principal != other.principal)
      return false;
    return true;
  }
    
  @Override
  public String toString() {
    return "[ " + id + " " + email + " " + principal + " ]";
  }  

}

