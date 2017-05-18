package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import br.gov.pa.prodepa.controleacesso.commons.domain.Aplicacao;
import br.gov.pa.prodepa.controleacesso.commons.domain.Operacao;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;

/**
 * Objeto de transporte de dados referente a uma funcionalidade de uma
 * aplicacao.
 * 
 * @author Bruno Ribeiro
 */
public class FuncionalidadeDto implements Serializable {

	private static final long serialVersionUID = 188516637122319L;

	/** Identificador da funcionalidade. */
	private Long id;

	/** Descricao da funcionalidade. */
	private String descricao;

	/** Codigo da funcionalidade. */
	private String codigo;

	/** Indica se a funcionalidade esta ativa ou nao. */
	@Column(name = "ATIVO", nullable = false)
	private TipoBoleano ativo;

	/** aplicacao na qual a funcionalidade esta vinculada. */
	private Aplicacao aplicacao;

	/** Operacoes de usuarios associados a uma funcionalidade. */
	private List<Operacao> operacoes;

	private Date dataManut;

	private Long idUsuarioManut;

	private String codigoOperacaoManut;

	/** Construtor padrao. */
	public FuncionalidadeDto() {
		super();
	}

	public FuncionalidadeDto(Aplicacao aplicacao) {
		super();
		this.aplicacao = aplicacao;
	}

	/** Construtor para iniciar os atributos. */
	public FuncionalidadeDto(Long id, String descricao, String codigo,
			TipoBoleano ativo, Aplicacao aplicacao, List<Operacao> operacoes) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigo = codigo;
		this.ativo = ativo;
		this.aplicacao = aplicacao;
		this.operacoes = operacoes;
	}

	public FuncionalidadeDto(Long id, String descricao, String codigo,
			TipoBoleano ativo, Aplicacao aplicacao, List<Operacao> operacoes,
			Date dataManut, Long idUsuarioManut, String codigoOperacaoManut) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigo = codigo;
		this.ativo = ativo;
		this.aplicacao = aplicacao;
		this.operacoes = operacoes;
		this.dataManut = dataManut;
		this.idUsuarioManut = idUsuarioManut;
		this.codigoOperacaoManut = codigoOperacaoManut;
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

	public List<Operacao> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<Operacao> operacoes) {
		this.operacoes = operacoes;
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
		result = prime * result
				+ ((aplicacao == null) ? 0 : aplicacao.hashCode());
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
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
		FuncionalidadeDto other = (FuncionalidadeDto) obj;
		if (aplicacao == null) {
			if (other.aplicacao != null)
				return false;
		} else if (!aplicacao.equals(other.aplicacao))
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return descricao;
	}
}