package br.gov.pa.prodepa.nucleopa.commons.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.pa.prodepa.domain.Paginable;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.TipoPessoa;
import br.gov.pa.prodepa.persistence.annotation.Equals;
import br.gov.pa.prodepa.persistence.annotation.Fonetico;
import br.gov.pa.prodepa.persistence.annotation.Like;
import br.gov.pa.prodepa.persistence.annotation.OrderBy;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "sg_pessoa", sequenceName = "sq_pessoa", initialValue = 1, allocationSize = 1)
public class Pessoa implements Paginable<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Equals
	@GeneratedValue(generator = "sg_pessoa", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Equals
	@Enumerated
	@Column(name = "id_tipo_pessoa", nullable = false)
	private TipoPessoa tipo;

	@Like
	@OrderBy
	@Column(length = 200, nullable = false)
	private String nome;

	@Fonetico
	@Column(name = "nome_fonetico", length = 400)
	private String nomeFonetico;

	@Equals
	@Enumerated
	@Column(name = "e_fornecedor", nullable = false)
	private TipoBoleano ehFornecedor;

	@Equals
	@Enumerated
	@Column(name = "e_orgao", nullable = false)
	private TipoBoleano ehOrgao;

	// Lists

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Endereco> enderecos;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	@javax.persistence.OrderBy("numero")
	private List<Telefone> telefones;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	@javax.persistence.OrderBy("email")
	private List<Email> emails;

	// Auditoria

	@Equals
	@Column(name = "versao", nullable = false)
	private Integer versaoPessoa;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manut")
	private Date dataManutencaoPessoa;
	
	@Column(name = "id_usuario_manut")
	private Long idUsuarioManutencaoPessoa;
	
	@Column(name = "id_aplicacao_manut")
	private Long idAplicacaoManutencaoPessoa;
	
	@Column(name ="codigo_operacao_manut", length = 20)
	private String codigoOperacaoPessoa;

	public Pessoa() {
		super();
	}

	public Pessoa(Long id) {
		super();
		this.id = id;
	}

	public Long getKey() {
		return id;
	}

	public void setKey(Long key) {
		this.id = key;
	}

	public boolean isPessoaFisica() {
		return tipo != null && tipo.equals(TipoPessoa.FISICA);
	}

	public boolean isPessoaJuridica() {
		return tipo != null && tipo.equals(TipoPessoa.JURIDICA);
	}

	public boolean isInscricaoGenerica() {
		return tipo != null && tipo.equals(TipoPessoa.GENERICA);
	}

	// 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFonetico() {
		return nomeFonetico;
	}

	public void setNomeFonetico(String nomeFonetico) {
		this.nomeFonetico = nomeFonetico;
	}

	public TipoBoleano getEhFornecedor() {
		return ehFornecedor;
	}

	public void setEhFornecedor(TipoBoleano ehFornecedor) {
		this.ehFornecedor = ehFornecedor;
	}

	public TipoBoleano getEhOrgao() {
		return ehOrgao;
	}

	public void setEhOrgao(TipoBoleano ehOrgao) {
		this.ehOrgao = ehOrgao;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public Integer getVersaoPessoa() {
		return versaoPessoa;
	}

	public void setVersaoPessoa(Integer versaoPessoa) {
		this.versaoPessoa = versaoPessoa;
	}

	public Date getDataManutencaoPessoa() {
		return dataManutencaoPessoa;
	}

	public void setDataManutencaoPessoa(Date dataManutencaoPessoa) {
		this.dataManutencaoPessoa = dataManutencaoPessoa;
	}

	public Long getIdUsuarioManutencaoPessoa() {
		return idUsuarioManutencaoPessoa;
	}

	public void setIdUsuarioManutencaoPessoa(Long idUsuarioManutencaoPessoa) {
		this.idUsuarioManutencaoPessoa = idUsuarioManutencaoPessoa;
	}

	public Long getIdAplicacaoManutencaoPessoa() {
		return idAplicacaoManutencaoPessoa;
	}

	public void setIdAplicacaoManutencaoPessoa(Long idAplicacaoManutencaoPessoa) {
		this.idAplicacaoManutencaoPessoa = idAplicacaoManutencaoPessoa;
	}

	public String getCodigoOperacaoPessoa() {
		return codigoOperacaoPessoa;
	}

	public void setCodigoOperacaoPessoa(String codigoOperacaoPessoa) {
		this.codigoOperacaoPessoa = codigoOperacaoPessoa;
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
		Pessoa other = (Pessoa) obj;
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