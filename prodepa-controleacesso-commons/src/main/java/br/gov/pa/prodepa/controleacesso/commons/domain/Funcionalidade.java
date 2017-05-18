package br.gov.pa.prodepa.controleacesso.commons.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.gov.pa.prodepa.domain.Audit;
import br.gov.pa.prodepa.domain.CanEnableOrDisable;

/**
 * Funcionalidade.
 */
@Entity
@Table(name = "FUNCIONALIDADE", schema = "controleacesso")
public class Funcionalidade extends Audit implements Comparable<Funcionalidade>, CanEnableOrDisable{

	private static final long serialVersionUID = 5774460830335368946L;

	/** Identificador da funcionalidade. */
	private Long id;

	/** Descricao da funcionalidade. */
	private String descricao;

	/** Codigo de uma funcionalidade. */
	private String codigo;

	/** Indica se a funcionalidade esta ativa ou nao. */
	private Boolean ativo;

	/** Aplicacao na qual a funcionalidade esta vinculada. */
	private Aplicacao aplicacao;

	/** Lista de funcionalidades. */
	private List<Operacao> operacoes;
	
	public Funcionalidade() {
		super();
	}

	//"id","codigo", "descricao", "ativo", "a.id", "a.nome"
	
	public Funcionalidade(Long id, String codigo, String descricao, Boolean ativo, Long idAplicacao, String nomeAplicacao){
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.ativo = ativo;
		this.aplicacao = new Aplicacao(idAplicacao, nomeAplicacao);
	}
	
	public Funcionalidade(Long id, String descricao, String codigo, Boolean ativo, Aplicacao aplicacao, List<Operacao> operacoes) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigo = codigo;
		this.ativo = ativo;
		this.aplicacao = aplicacao;
		this.operacoes = operacoes;
	}

	public Funcionalidade(Long id, String descricao, String codigo,
			Boolean ativo, Aplicacao aplicacao, List<Operacao> operacoes,
			Date dataManut, Long idUsuarioManut, String codigoOperacaoManut) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigo = codigo;
		this.ativo = ativo;
		this.aplicacao = aplicacao;
		this.operacoes = operacoes;
		this.setDataManut(dataManut);
		this.setIdUsuarioManut(idUsuarioManut);
		this.setCodigoOperacaoManut(codigoOperacaoManut);
	}

	public Funcionalidade(Long idFuncionalidade, String nomeFuncionalidade) {
		this.id = idFuncionalidade;
		this.descricao = nomeFuncionalidade;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "DESCRICAO", nullable = false, length = 200)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "CODIGO")
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ATIVO", nullable = false)
	public Boolean getEnable() {
		return ativo;
	}

	public void setEnable(Boolean ativo) {
		this.ativo = ativo;
	}

	@ManyToOne
	@JoinColumn(name = "ID_APLICACAO", nullable = false)
	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	@OneToMany(mappedBy = "funcionalidade", cascade = CascadeType.REMOVE)
	public List<Operacao> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<Operacao> operacoes) {
		this.operacoes = operacoes;
	}
	
	public int compareTo(Funcionalidade o) {
		return this.getDescricao().compareTo(o.getDescricao());
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
		Funcionalidade other = (Funcionalidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
	    return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}
}