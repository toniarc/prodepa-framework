package br.gov.pa.prodepa.controleacesso.commons.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.pa.prodepa.domain.Audit;

@Entity
@Table(name = "parametro", schema = "controleacesso")
@SequenceGenerator(name = "sq_generator_configuracao", sequenceName = "controleacesso.sq_configuracao", allocationSize = 1, initialValue = 1)
public class Configuracao extends Audit {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Aplicacao aplicacao;

	private String nome;

	private String descricao;

	private String valor;

	private TipoConfiguracao tipo;

	public Configuracao() {
		super();
	}

	public Configuracao(Long id, Long idAplicacao, String nomeAplicacao, String nome, String descricao, String valor, TipoConfiguracao tipo) {
		super();
		this.id = id;
		this.aplicacao = new Aplicacao(idAplicacao, nomeAplicacao);
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.tipo = tipo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_generator_configuracao")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "id_aplicacao")
	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	@Column(name = "nome", nullable = false)
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

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "id_tipo", nullable = false)
	public TipoConfiguracao getTipo() {
		return tipo;
	}

	public void setTipo(TipoConfiguracao tipo) {
		this.tipo = tipo;
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
		Configuracao other = (Configuracao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return valor;
	}
}