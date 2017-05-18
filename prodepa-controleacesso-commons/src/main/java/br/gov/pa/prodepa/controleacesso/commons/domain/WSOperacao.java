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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.pa.prodepa.domain.Audit;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;

/**
 * Operacao.
 */
@Entity
@Table(name = "ws_operacao", schema = "controleacesso")
public class WSOperacao extends Audit implements Comparable<WSOperacao>{

	private static final long serialVersionUID = -6929339356224258944L;

	private Long id;

	private String descricao;

	private String codigo;

	private TipoBoleano ativo;

	private Aplicacao aplicacao;
	
	private List<WSPerfilWSOperacao> perfis;
	
	public WSOperacao() {
		super();
	}
	
	public WSOperacao(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public WSOperacao(Long id, String codigo, String descricao, Long idAplicacao, String nomeAplicacao, TipoBoleano ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ativo = ativo;
		this.codigo = codigo;
		this.aplicacao = new Aplicacao(idAplicacao, nomeAplicacao);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="wsoperacao_generator")
	@SequenceGenerator(name="wsoperacao_generator", sequenceName="controleacesso.sq_ws_operacao",allocationSize=1)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "descricao", nullable = false, length = 100)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "codigo")
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ativo", nullable = false)
	public TipoBoleano getAtivo() {
		return ativo;
	}

	public void setAtivo(TipoBoleano ativo) {
		this.ativo = ativo;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_aplicacao", nullable = true)
	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	@OneToMany(mappedBy="operacao", fetch=FetchType.LAZY)
	public List<WSPerfilWSOperacao> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<WSPerfilWSOperacao> perfis) {
		this.perfis = perfis;
	}

	public int compareTo(WSOperacao o) {
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
		WSOperacao other = (WSOperacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WSOperacao [descricao=" + descricao + "]";
	}
}