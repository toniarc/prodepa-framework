package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.List;

import br.gov.pa.prodepa.controleacesso.commons.domain.Situacao;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;

/**
 * Objeto de transporte de dados referente a um usuario.
 * @author Bruno Ribeiro
 */
public class UsuarioDtoWebService implements Serializable {

  private static final long serialVersionUID = 188123637156989L;

  /** Identificador de um usuario. */
  private Long id;

  /** Login de um usuario. */
  private String login;

  /** Nome do usuario. */
  private String nome;

  /** Situacao do usuario. */
  private Situacao situacao;

  /** Identifica se o usuario trocou a senha. */
  private TipoBoleano trocouSenha;

  /** Identifica as operacoes que o usuario tem acesso. */
  private List<String> operacoes;

  private List<PerfilDtoWS> perfis;

  private List<AplicacaoDtoWS> aplicacoes;

  public UsuarioDtoWebService() {
    super();
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

  public Situacao getSituacao() {
    return situacao;
  }

  public void setSituacao(Situacao situacao) {
    this.situacao = situacao;
  }

  public TipoBoleano getTrocouSenha() {
    return trocouSenha;
  }

  public void setTrocouSenha(TipoBoleano trocouSenha) {
    this.trocouSenha = trocouSenha;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((aplicacoes == null) ? 0 : aplicacoes.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((login == null) ? 0 : login.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((operacoes == null) ? 0 : operacoes.hashCode());
    result = prime * result + ((perfis == null) ? 0 : perfis.hashCode());
    result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
    result = prime * result + ((trocouSenha == null) ? 0 : trocouSenha.hashCode());
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
    UsuarioDtoWebService other = (UsuarioDtoWebService) obj;
    if (aplicacoes == null) {
      if (other.aplicacoes != null)
        return false;
    } else if (!aplicacoes.equals(other.aplicacoes))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (login == null) {
      if (other.login != null)
        return false;
    } else if (!login.equals(other.login))
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (operacoes == null) {
      if (other.operacoes != null)
        return false;
    } else if (!operacoes.equals(other.operacoes))
      return false;
    if (perfis == null) {
      if (other.perfis != null)
        return false;
    } else if (!perfis.equals(other.perfis))
      return false;
    if (situacao != other.situacao)
      return false;
    if (trocouSenha != other.trocouSenha)
      return false;
    return true;
  }
}