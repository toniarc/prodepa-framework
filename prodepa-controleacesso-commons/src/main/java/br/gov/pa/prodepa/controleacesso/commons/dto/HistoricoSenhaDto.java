package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.Date;

public class HistoricoSenhaDto implements Serializable {

  private static final long serialVersionUID = 6282144593152884767L;

  private Long id;
  private String senha;
  private Date data;

  private Long idUsuario;

  public HistoricoSenhaDto() {
    super();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public Long getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Long idUsuario) {
    this.idUsuario = idUsuario;
  }
}