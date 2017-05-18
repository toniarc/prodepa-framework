package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;

public class PerfilDtoWS implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String codigo;
  private String descricao;

  public PerfilDtoWS() {
    super();
  }

  public PerfilDtoWS(Long id, String codigo, String descricao) {
    super();
    this.id = id;
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public PerfilDtoWS(String role) {
	this.codigo = role;
  }

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
    PerfilDtoWS other = (PerfilDtoWS) obj;
    if (codigo == null) {
      if (other.codigo != null)
        return false;
    } else if (!codigo.equals(other.codigo))
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
    return true;
  }

  @Override
  public String toString() {
    return "PerfilDtoWS [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + "]";
  }
  
}