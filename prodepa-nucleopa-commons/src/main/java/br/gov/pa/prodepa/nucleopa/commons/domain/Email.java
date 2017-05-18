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
import br.gov.pa.prodepa.persistence.annotation.Equals;
import br.gov.pa.prodepa.persistence.annotation.Like;

@Entity
@Table(name = "email")
@SequenceGenerator(name = "sg_email", sequenceName = "sq_email", initialValue = 1, allocationSize = 1)
public class Email implements Paginable<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Equals
	@GeneratedValue(generator = "sg_email", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Equals
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa", nullable = false)
	private Pessoa pessoa;

	@Like
	@Column(length = 100, nullable = false)
	private String email;

	@Column(name = "descricao", length = 100)
	private String descricao;

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

	public Email() {
		super();
	}

	public Email(Long id) {
		super();
		this.id = id;
	}

	public Email(TipoBoleano principal) {
		super();
		this.principal = principal;
	}

	public Long getKey() {
		return id;
	}

	public void setKey(Long key) {
		this.id = key;
	}

	public void copy(Email origem) {
		if (origem != null) {
			setId(origem.getId());
			setPessoa(origem.getPessoa());
			setEmail(origem.getEmail());
			setDescricao(origem.getDescricao());
			setPrincipal(origem.getPrincipal());
			//
			setIdUsuarioManutencao(origem.getIdUsuarioManutencao());
			setIdAplicacaoManutencao(origem.getIdAplicacaoManutencao());
			setDataManutencao(origem.getDataManutencao());
			setTimestamp(origem.getTimestamp());
		}
	}

	public boolean igual(Email t) {
		return email != null
				&& email.equals(t.getEmail())
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Email other = (Email) obj;
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