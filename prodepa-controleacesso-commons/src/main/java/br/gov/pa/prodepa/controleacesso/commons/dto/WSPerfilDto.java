package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.gov.pa.prodepa.controleacesso.commons.domain.Aplicacao;
import br.gov.pa.prodepa.controleacesso.commons.domain.WSOperacao;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;

public class WSPerfilDto implements Serializable {

	private static final long serialVersionUID = -6374980428515323203L;

	private Long id;
	private String descricao;
	private TipoBoleano ativo;
	private String codigo;
	private Aplicacao aplicacao;
	private List<WSOperacao> wsOperacoes;
	private Long idUsuarioManut; 
	private Date dataManut; 
	private String codigoOperacaoManut; 
	
	public WSPerfilDto() {
		super();
	}
	
	public WSPerfilDto(Long id, String descricao, TipoBoleano ativo,
			String codigo, Aplicacao aplicacao, List<WSOperacao> wsOperacoes,
			Long idUsuarioManut, Date dataManut, String codigoOperacaoManut) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ativo = ativo;
		this.codigo = codigo;
		this.aplicacao = aplicacao;
		this.wsOperacoes = wsOperacoes;
		this.idUsuarioManut = idUsuarioManut;
		this.dataManut = dataManut;
		this.codigoOperacaoManut = codigoOperacaoManut;
	}



	public WSPerfilDto(Long id, String descricao, TipoBoleano ativo, String codigo,
			Aplicacao aplicacao, List<WSOperacao> wsOperacoes) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ativo = ativo;
		this.codigo = codigo;
		this.aplicacao = aplicacao;
		this.wsOperacoes = wsOperacoes;
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

	public TipoBoleano getAtivo() {
		return ativo;
	}

	public void setAtivo(TipoBoleano ativo) {
		this.ativo = ativo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public List<WSOperacao> getWsOperacoes() {
		return wsOperacoes;
	}

	public void setWsOperacoes(List<WSOperacao> wsOperacoes) {
		this.wsOperacoes = wsOperacoes;
	}
	
	public Long getIdUsuarioManut() {
		return idUsuarioManut;
	}

	public void setIdUsuarioManut(Long idUsuarioManut) {
		this.idUsuarioManut = idUsuarioManut;
	}

	public Date getDataManut() {
		return dataManut;
	}

	public void setDataManut(Date dataManut) {
		this.dataManut = dataManut;
	}

	public String getCodigoOperacaoManut() {
		return codigoOperacaoManut;
	}

	public void setCodigoOperacaoManut(String codigoOperacaoManut) {
		this.codigoOperacaoManut = codigoOperacaoManut;
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
		WSPerfilDto other = (WSPerfilDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WSPerfilDto [descricao=" + descricao + "]";
	}
}