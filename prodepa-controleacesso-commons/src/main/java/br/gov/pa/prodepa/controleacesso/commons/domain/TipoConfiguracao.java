package br.gov.pa.prodepa.controleacesso.commons.domain;

public enum TipoConfiguracao {

  INDEFINIDO(0, "Indefinido"),
  TEXTO(1, "Texto"),
  NUMERO(2, "Número");

  private int codigo;
  private String descricao;

  private TipoConfiguracao(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public int getCodigo() {
    return this.codigo;
  }

  public String getDescricao() {
    return this.descricao;
  }
}