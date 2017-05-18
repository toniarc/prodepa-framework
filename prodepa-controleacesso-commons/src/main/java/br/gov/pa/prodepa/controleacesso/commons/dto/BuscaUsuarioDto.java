package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.util.List;

import br.gov.pa.prodepa.controleacesso.commons.domain.Aplicacao;
import br.gov.pa.prodepa.controleacesso.commons.domain.Situacao;
import br.gov.pa.prodepa.controleacesso.commons.domain.TipoDocumento;
import br.gov.pa.prodepa.nucleopa.commons.domain.Orgao;

public class BuscaUsuarioDto extends BuscaPaginableDto {

  private static final long serialVersionUID = 6418386391918219732L;

  private Long id;
  private String nome;
  private String login;
  private TipoDocumento tipoDocumento;
  private String numeroDocumento;
  private Orgao orgao;
  private Situacao situacao;

  private Aplicacao aplicacao;
  private Long idAplicacao;
  private List<Long> idsPerfis;
  private String email;

  public BuscaUsuarioDto() {
    super();
  }

  public BuscaUsuarioDto(Situacao situacao, Long idAplicacao, String nome) {
    super();
    this.situacao = situacao;
    this.idAplicacao = idAplicacao;
    this.nome = nome;
  }

  public BuscaUsuarioDto(Situacao situacao, Long idAplicacao, String nome, Orgao orgao) {
    super();
    this.situacao = situacao;
    this.idAplicacao = idAplicacao;
    this.nome = nome;
    this.orgao = orgao;
  }

  public BuscaUsuarioDto(Aplicacao aplicacao, Situacao situacao, Long id, Long idAplicacao, TipoDocumento tipoDocumento, String numeroDocumento, String nome, Orgao orgao) {
    super();
    this.aplicacao = aplicacao;
    this.situacao = situacao;
    this.id = id;
    this.idAplicacao = idAplicacao;
    this.tipoDocumento = tipoDocumento;
    this.numeroDocumento = numeroDocumento;
    this.nome = nome;
    this.orgao = orgao;
  }

  public Aplicacao getAplicacao() {
    return aplicacao;
  }

  public void setAplicacao(Aplicacao aplicacao) {
    this.aplicacao = aplicacao;
  }

  public Long getIdAplicacao() {
    return idAplicacao;
  }

  public void setIdAplicacao(Long idAplicacao) {
    this.idAplicacao = idAplicacao;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Orgao getOrgao() {
    return orgao;
  }

  public void setOrgao(Orgao orgao) {
    this.orgao = orgao;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TipoDocumento getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(TipoDocumento tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public String getNumeroDocumento() {
    return numeroDocumento;
  }

  public void setNumeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
  }

  public List<Long> getIdsPerfis() {
    return idsPerfis;
  }

  public void setIdsPerfis(List<Long> idsPerfis) {
    this.idsPerfis = idsPerfis;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Situacao getSituacao() {
    return situacao;
  }

  public void setSituacao(Situacao situacao) {
    this.situacao = situacao;
  }
}