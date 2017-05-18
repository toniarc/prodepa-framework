package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;

public class AplicacaoDtoWS implements Serializable {

  private static final long serialVersionUID = 422872976830535779L;
  
  private Long id;
  private String nome;
  private String descricao;
  private String contexto;
//  private byte[] logo;

  public AplicacaoDtoWS() {
    super();
  }

  public AplicacaoDtoWS(Long id, String nome, String descricao, String contexto) {
    super();
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.contexto = contexto;
  }

//  public AplicacaoDtoWS(Long id, String nome, String descricao, String contexto, byte[] logo) {
//    super();
//    this.id = id;
//    this.nome = nome;
//    this.descricao = descricao;
//    this.contexto = contexto;
//    this.logo = logo;
//  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getContexto() {
    return contexto;
  }

  public void setContexto(String contexto) {
    this.contexto = contexto;
  }

//  public byte[] getLogo() {
//    return logo;
//  }
//
//  public void setLogo(byte[] logo) {
//    this.logo = logo;
//  }

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
    AplicacaoDtoWS other = (AplicacaoDtoWS) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "AplicacaoDtoWS [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", contexto=" + contexto + "]";
  }
  
}