package br.gov.pa.prodepa.nucleopa.commons.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.gov.pa.prodepa.domain.Paginable;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.TipoTelefone;
import br.gov.pa.prodepa.persistence.annotation.Equals;

@Entity
@Table(name = "telefone")
@SequenceGenerator(name = "sg_telefone", sequenceName = "sq_telefone", initialValue = 1, allocationSize = 1)
public class Telefone implements Paginable<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Equals
	@GeneratedValue(generator = "sg_telefone", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Equals
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa", nullable = false)
	private Pessoa pessoa;

	@Equals
	@Enumerated
	@Column(name = "id_tipo_telefone", nullable = false)
	private TipoTelefone tipo;

	@Equals
	@Column(name = "cd_ddd", length = 3)
	private String ddd;

	@Equals
	@Column(length = 15, nullable = false)
	private String numero;

	@Column(name = "obs", length = 200)
	private String observacao;

	@Equals
	@Enumerated
	@Column(nullable = false)
	private TipoBoleano principal;

	// Auditoria

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manut")
	private Date dataManutencao;
	
	@Column(name = "id_usuario_manut")
	private Long idUsuarioManutencao;
	
	@Column(name = "id_aplicacao_manut")
	private Long idAplicacaoManutencao;

	// 

	@Transient
	private Long timestamp;

	public Telefone() {
		super();
	}

	public Telefone(Long id) {
		super();
		this.id = id;
	}
	
	public Telefone(TipoTelefone tipo, TipoBoleano principal) {
		super();
		this.tipo = tipo;
		this.principal = principal;
	}

	public Long getKey() {
		return id;
	}

	public void setKey(Long key) {
		this.id = key;
	}

	public void copy(Telefone origem) {
		if (origem != null) {
			setId(origem.getId());
			setPessoa(origem.getPessoa());
			setTipo(origem.getTipo());
			setDdd(origem.getDdd());
			setNumero(origem.getNumero());
			setObservacao(origem.getObservacao());
			setPrincipal(origem.getPrincipal());
			//
			setIdUsuarioManutencao(origem.getIdUsuarioManutencao());
			setIdAplicacaoManutencao(origem.getIdAplicacaoManutencao());
			setDataManutencao(origem.getDataManutencao());
			setTimestamp(origem.getTimestamp());
		}
	}

	public boolean igual(Telefone t) {
		return ((ddd == null && t.getDdd() == null) || (ddd != null && ddd.equals(t.getDdd())))
				&& numero != null
				&& numero.equals(t.getNumero())
				&& (timestamp == null || !timestamp.equals(t.getTimestamp()));
	}

	public boolean isUpdate() {
		return timestamp != null;
	}

	// 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoBoleano getPrincipal() {
		return principal;
	}

	public void setPrincipal(TipoBoleano principal) {
		this.principal = principal;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public Long getIdUsuarioManutencao() {
		return idUsuarioManutencao;
	}

	public void setIdUsuarioManutencao(Long idUsuarioManutencao) {
		this.idUsuarioManutencao = idUsuarioManutencao;
	}

	public Long getIdAplicacaoManutencao() {
		return idAplicacaoManutencao;
	}

	public void setIdAplicacaoManutencao(Long idAplicacaoManutencao) {
		this.idAplicacaoManutencao = idAplicacaoManutencao;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
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
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id == null ? null : id.toString();
	}
}