package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;

public class ParametroDtoWS implements Serializable {

  private static final long serialVersionUID = 1L;

  private String nome;
  private String descricao;
  private String valor;
  private String tipo;

  public ParametroDtoWS() {
    super();
  }

  public ParametroDtoWS(String nome, String descricao, String valor, String tipo) {
    super();
    this.nome = nome;
    this.descricao = descricao;
    this.valor = valor;
    this.tipo = tipo;
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

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public String getTipo() {
    return tipo;
  }
  
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
    ParametroDtoWS other = (ParametroDtoWS) obj;
    if (descricao == null) {
      if (other.descricao != null)
        return false;
    } else if (!descricao.equals(other.descricao))
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (valor == null) {
      if (other.valor != null)
        return false;
    } else if (!valor.equals(other.valor))
      return false;
    if (tipo == null) {
      if (other.tipo != null)
        return false;
    } else if (!tipo.equals(other.tipo))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "ParametroDtoWS [nome=" + nome + ", descricao=" + descricao + ", valor=" + valor + ", tipo=" + tipo + "]";
  }
}