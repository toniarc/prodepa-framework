package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.List;

public class UsuarioDtoWS implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String login;
  private String nome;

  private Boolean trocouSenha;
  private String passaporte;

  private Long idOrgao;
  private String siglaOrgao;

  private String tipoDocumento;
  private String numeroDocumento;
  
  private String situacao;
  
  private List<String> operacoes;
  private List<PerfilDtoWS> perfis;
  private List<AplicacaoDtoWS> aplicacoes;

  public UsuarioDtoWS() {
    super();
  }
  
  public UsuarioDtoWS(Long id, String login, String nome, Long idOrgao, String siglaOrgao, String numeroDocumento, boolean trocouSenha, String tipoDocumento) {
    super();
    this.id = id;
    this.login = login;
    this.nome = nome;
    this.trocouSenha = trocouSenha;
    this.idOrgao = idOrgao;
    this.siglaOrgao = siglaOrgao;
    this.tipoDocumento = tipoDocumento;
    this.numeroDocumento = numeroDocumento;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Boolean getTrocouSenha() {
    return trocouSenha;
  }

  public void setTrocouSenha(Boolean trocouSenha) {
    this.trocouSenha = trocouSenha;
  }

  public String getPassaporte() {
    return passaporte;
  }

  public void setPassaporte(String passaporte) {
    this.passaporte = passaporte;
  }

  public Long getIdOrgao() {
    return idOrgao;
  }

  public void setIdOrgao(Long idOrgao) {
    this.idOrgao = idOrgao;
  }

  public String getSiglaOrgao() {
    return siglaOrgao;
  }

  public void setSiglaOrgao(String siglaOrgao) {
    this.siglaOrgao = siglaOrgao;
  }

  public List<String> getOperacoes() {
    return operacoes;
  }

  public void setOperacoes(List<String> operacoes) {
    this.operacoes = operacoes;
  }

  public List<PerfilDtoWS> getPerfis() {
    return perfis;
  }

  public void setPerfis(List<PerfilDtoWS> perfis) {
    this.perfis = perfis;
  }

  public List<AplicacaoDtoWS> getAplicacoes() {
    return aplicacoes;
  }

  public void setAplicacoes(List<AplicacaoDtoWS> aplicacoes) {
    this.aplicacoes = aplicacoes;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public String getNumeroDocumento() {
    return numeroDocumento;
  }

  public void setNumeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
  }

  public String getSituacao() {
    return situacao;
  }

  public void setSituacao(String situacao) {
    this.situacao = situacao;
  }

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
    UsuarioDtoWS other = (UsuarioDtoWS) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "UsuarioDtoWS [id=" + id + ", login=" + login + ", nome=" + nome + ", trocouSenha=" + trocouSenha + ", passaporte=" + passaporte + ", idOrgao=" + idOrgao + ", siglaOrgao=" + siglaOrgao
            + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", situacao=" + situacao + ", operacoes=" + operacoes + ", perfis=" + perfis + ", aplicacoes=" + aplicacoes
            + "]";
  }

}