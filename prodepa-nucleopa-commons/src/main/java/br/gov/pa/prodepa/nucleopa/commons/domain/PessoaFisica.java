package br.gov.pa.prodepa.nucleopa.commons.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.pa.prodepa.nucleopa.commons.enumeration.Sexo;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.TipoPessoa;
import br.gov.pa.prodepa.persistence.annotation.Equals;

@Entity
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Equals
	@Column(length = 11, nullable = false)
	private String cpf;

	@Equals
	@Enumerated
	@Column(name = "id_sexo")
	private Sexo sexo;

	// Auditoria

	@Equals
	@Column(nullable = false)
	private Integer versao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manut")
	private Date dataManutencao;

	@Column(name = "id_usuario_manut")
	private Long idUsuarioManutencao;

	@Column(name = "id_aplicacao_manut")
	private Long idAplicacaoManutencao;

	@Column(name ="codigo_operacao_manut", length = 20)
	private String codigoOperacao;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(TipoPessoa tipo) {
		super();
		setTipo(tipo);
	}

	public Long getKey() {
		return getId();
	}

	public void setKey(Long key) {
		setId(key);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
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

	public String getCodigoOperacao() {
		return codigoOperacao;
	}

	public void setCodigoOperacao(String codigoOperacao) {
		this.codigoOperacao = codigoOperacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFisica other = (PessoaFisica) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.getId() == null ? null : super.getId().toString();
	}
}