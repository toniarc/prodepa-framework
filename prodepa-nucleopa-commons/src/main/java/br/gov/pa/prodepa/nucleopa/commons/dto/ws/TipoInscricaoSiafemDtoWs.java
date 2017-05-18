package br.gov.pa.prodepa.nucleopa.commons.dto.ws;

import java.util.Date;

import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;

public class TipoInscricaoSiafemDtoWs {

	private Long id;

	private String descricao;

	private String descricaoFonetica;

	private String codigo;

	private TipoBoleano ativo;

	private Long idUsuarioManutencao;

	private Date dataManutencao;

	private String codigoOperacao;
	
	public TipoInscricaoSiafemDtoWs() {
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

	public String getDescricaoFonetica() {
		return descricaoFonetica;
	}

	public void setDescricaoFonetica(String descricaoFonetica) {
		this.descricaoFonetica = descricaoFonetica;
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

	public Long getIdUsuarioManutencao() {
		return idUsuarioManutencao;
	}

	public void setIdUsuarioManutencao(Long idUsuarioManutencao) {
		this.idUsuarioManutencao = idUsuarioManutencao;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public String getCodigoOperacao() {
		return codigoOperacao;
	}

	public void setCodigoOperacao(String codigoOperacao) {
		this.codigoOperacao = codigoOperacao;
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
		TipoInscricaoSiafemDtoWs other = (TipoInscricaoSiafemDtoWs) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
