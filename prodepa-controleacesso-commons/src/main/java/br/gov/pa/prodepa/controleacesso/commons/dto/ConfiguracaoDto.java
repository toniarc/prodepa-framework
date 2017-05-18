package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.Date;

import br.gov.pa.prodepa.controleacesso.commons.domain.Aplicacao;
import br.gov.pa.prodepa.controleacesso.commons.domain.TipoConfiguracao;

public class ConfiguracaoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

  private Aplicacao aplicacao;

  private String nome;
	private String descricao;
	private String valor;

  private TipoConfiguracao tipo;

  private String codigoOperacaoManut;
  private Date dataManut;
  private Long idUsuarioManut;

  public ConfiguracaoDto() {
		super();
	}

  public ConfiguracaoDto(String nome, String descricao, String valor, String tipo) {
    super();
    this.nome = nome;
    this.descricao = descricao;
    this.valor = valor;
    if (tipo != null && !tipo.isEmpty()) {
      if (tipo.equals("varchar")) {
        this.tipo = TipoConfiguracao.TEXTO;
      } else {
        if (tipo.equals("integer")) {
          this.tipo = TipoConfiguracao.NUMERO;
        } else {
          this.tipo = TipoConfiguracao.INDEFINIDO;
        }
      }
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Aplicacao getAplicacao() {
    return aplicacao;
  }

  public void setAplicacao(Aplicacao aplicacao) {
    this.aplicacao = aplicacao;
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

  public TipoConfiguracao getTipo() {
    return tipo;
  }

  public void setTipo(TipoConfiguracao tipo) {
    this.tipo = tipo;
  }

  public String getCodigoOperacaoManut() {
    return codigoOperacaoManut;
  }

  public void setCodigoOperacaoManut(String codigoOperacaoManut) {
    this.codigoOperacaoManut = codigoOperacaoManut;
  }

  public Date getDataManut() {
    return dataManut;
  }

  public void setDataManut(Date dataManut) {
    this.dataManut = dataManut;
  }

  public Long getIdUsuarioManut() {
    return idUsuarioManut;
  }

  public void setIdUsuarioManut(Long idUsuarioManut) {
    this.idUsuarioManut = idUsuarioManut;
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
    ConfiguracaoDto other = (ConfiguracaoDto) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return id != null ? id.toString() : null;
  }
}