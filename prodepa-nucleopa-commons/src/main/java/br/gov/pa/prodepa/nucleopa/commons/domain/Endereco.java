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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.gov.pa.prodepa.domain.Paginable;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;
import br.gov.pa.prodepa.persistence.annotation.Equals;
import br.gov.pa.prodepa.persistence.annotation.Like;

@Entity
@Table(name = "endereco")
@SequenceGenerator(name = "sg_endereco", sequenceName = "sq_endereco", initialValue = 1, allocationSize = 1)
public class Endereco implements Paginable<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Equals
	@GeneratedValue(generator = "sg_endereco", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Equals
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa", nullable = false)
	private Pessoa pessoa;

	@Like
	@Column(length = 100)
	private String logradouro;

	@Equals
	@Column(length = 15)
	private String numero;

	@Like
	@Column(length = 150)
	private String complemento;

	@Equals
	@Column(length = 9)
	private String cep;

	@Equals
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	@Equals
	@ManyToOne
	@JoinColumn(name = "id_municipio")
	private Municipio municipio;

	@Like
	@Column(length = 100)
	private String bairro;

	@Column(name = "obs", length = 300)
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

	public Endereco() {
		super();
	}

	public Endereco(Long id) {
		super();
		this.id = id;
	}

	public Endereco(TipoBoleano principal) {
		super();
		this.principal = principal;
	}

	public Long getKey() {
		return id;
	}

	public void setKey(Long key) {
		this.id = key;
	}

	public void copy(Endereco origem) {
		if (origem != null) {
			setId(origem.getId());
			setPessoa(origem.getPessoa());
			setLogradouro(origem.getLogradouro());
			setNumero(origem.getNumero());
			setComplemento(origem.getComplemento());
			setCep(origem.getCep());
			setEstado(origem.getEstado());
			setMunicipio(origem.getMunicipio());
			setBairro(origem.getBairro());
			setObservacao(origem.getObservacao());
			setPrincipal(origem.getPrincipal());
			//
			setIdUsuarioManutencao(origem.getIdUsuarioManutencao());
			setIdAplicacaoManutencao(origem.getIdAplicacaoManutencao());
			setDataManutencao(origem.getDataManutencao());
			setTimestamp(origem.getTimestamp());
		}
	}

	public boolean igual(Endereco t) {
		return timestamp == null || !timestamp.equals(t.getTimestamp());
	}

	public boolean isUpdate() {
		return timestamp != null;
	}

	public void changeEstado() {
		municipio = null;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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
		Endereco other = (Endereco) obj;
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