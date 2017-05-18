package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.util.Date;

import br.gov.pa.prodepa.controleacesso.commons.domain.Aplicacao;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;

public class WSOperacaoDto {

	private Long id;
	private String descricao;
	private String codigo;
	private TipoBoleano ativo;
	private Aplicacao aplicacao;
	private Long idUsuarioManut; 
	private Date dataManut;
	private String codigoOperacaoManut;

	public WSOperacaoDto() {
		super();
	}

	public WSOperacaoDto(Long id, String descricao, String codigo,
			TipoBoleano ativo, Aplicacao aplicacao, Long idUsuarioManut,
			Date dataManut, String codigoOperacaoManut) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigo = codigo;
		this.ativo = ativo;
		this.aplicacao = aplicacao;
		this.idUsuarioManut = idUsuarioManut;
		this.dataManut = dataManut;
		this.codigoOperacaoManut = codigoOperacaoManut;
	}


	public WSOperacaoDto(Long id, String descricao, String codigo,
			TipoBoleano ativo, Aplicacao aplicacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigo = codigo;
		this.ativo = ativo;
		this.aplicacao = aplicacao;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TipoBoleano getAtivo() {
		return ativo;
	}

	public void setAtivo(TipoBoleano ativo) {
		this.ativo = ativo;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
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
		WSOperacaoDto other = (WSOperacaoDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WSOperacaoDto [descricao=" + descricao + "]";
	}
}