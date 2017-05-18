package br.gov.pa.prodepa.controleacesso.commons.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
 * Operacao.
 */
@Entity
@Table(name = "OPERACAO", schema = "controleacesso")
public class Operacao extends Audit implements Comparable<Operacao>, CanEnableOrDisable {

	private static final long serialVersionUID = -6929339356224258944L;

	private Long id;

	private String descricao;

	private String codigo;

	private Boolean ativo;

	private Funcionalidade funcionalidade;

	private List<PerfilOperacao> perfis;

	private Aplicacao aplicacao;
	
	public Operacao() {
		super();
	}

	public Operacao(Long id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}
	
	public Operacao(Long id, String descricao, Long idFuncionalidade, String nomeFuncionalidade){
		this.id = id;
		this.descricao = descricao;
		this.funcionalidade = new Funcionalidade(idFuncionalidade, nomeFuncionalidade);
	}
	
	public Operacao(Long id, String codigo, String descricao , Long idAplicacao, String nomeAplicacao, Long idFuncionalidade, String nomeFuncionalidade, Boolean ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigo = codigo;
		this.ativo = ativo;
		this.funcionalidade = new Funcionalidade(idFuncionalidade, nomeFuncionalidade);
		this.aplicacao = new Aplicacao(idAplicacao, nomeAplicacao);
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

	@Column(name = "DESCRICAO", nullable = false, length = 100)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	@JoinColumn(name = "ID_FUNCIONALIDADE", nullable = false)
	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	@Column(name = "CODIGO")
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@OneToMany(mappedBy="operacao", fetch=FetchType.LAZY)
	public List<PerfilOperacao> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<PerfilOperacao> perfis) {
		this.perfis = perfis;
	}

	@ManyToOne
	@JoinColumn(name = "ID_APLICACAO", nullable = true)
	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public int compareTo(Operacao o) {
		return this.descricao.compareTo(o.getDescricao());
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
		Operacao other = (Operacao) obj;
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