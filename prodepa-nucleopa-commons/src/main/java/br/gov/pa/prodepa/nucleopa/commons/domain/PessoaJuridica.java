package br.gov.pa.prodepa.nucleopa.commons.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.TipoPessoa;
import br.gov.pa.prodepa.persistence.annotation.Equals;
import br.gov.pa.prodepa.persistence.annotation.Fonetico;
import br.gov.pa.prodepa.persistence.annotation.Like;

@Entity
@Table(name = "pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Equals
	@Column(length = 14, nullable = false)
	private String cnpj;

	@Like
	@Column(name = "nome_fantasia", length = 200)
	private String nomeFantasia;

	@Fonetico
	@Column(name = "nome_fantasia_fonetico", length = 400)
	private String nomeFantasiaFonetico;

	@Equals
	@ManyToOne
	@JoinColumn(name = "id_tipo_pessoa_juridica")
	private NaturezaJuridica naturezaJuridica;

	@Equals
	@OneToOne(mappedBy = "pessoaJuridica", fetch = FetchType.LAZY, optional = true)
	private Orgao orgao;

	@ManyToMany
	@JoinTable(name = "pessoa_juridica_area_tematica",
		joinColumns = @JoinColumn(name = "id_pessoa_juridica"),
		inverseJoinColumns = @JoinColumn(name = "id_area_tematica"))
	private List<AreaTematica> areasTematicas;

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

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(TipoPessoa tipo) {
		super();
		setTipo(tipo);
	}

	public Long getKey() {
		return getId();
	}

	public void setKey(Long key) {
		setId(key);
	}

	public boolean isNaturezaJuridicaOrgao() {
		return naturezaJuridica != null && naturezaJuridica.isOrgao();
	}

	public boolean isOrgaoAtivo() {
		return orgao != null && orgao.getAtivo() != null && orgao.getAtivo().equals(TipoBoleano.VERDADEIRO);
	}

	public boolean isOrgaoInativo() {
		return orgao != null && orgao.getAtivo() != null && orgao.getAtivo().equals(TipoBoleano.FALSO);
	}

	// 

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeFantasiaFonetico() {
		return nomeFantasiaFonetico;
	}

	public void setNomeFantasiaFonetico(String nomeFantasiaFonetico) {
		this.nomeFantasiaFonetico = nomeFantasiaFonetico;
	}

	public NaturezaJuridica getNaturezaJuridica() {
		return naturezaJuridica;
	}

	public void setNaturezaJuridica(NaturezaJuridica naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}

	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	public List<AreaTematica> getAreasTematicas() {
		return areasTematicas;
	}

	public void setAreasTematicas(List<AreaTematica> areasTematicas) {
		this.areasTematicas = areasTematicas;
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
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
		result = prime * result + ((nomeFantasiaFonetico == null) ? 0 : nomeFantasiaFonetico.hashCode());
		result = prime * result + ((naturezaJuridica == null) ? 0 : naturezaJuridica.hashCode());
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
		PessoaJuridica other = (PessoaJuridica) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (nomeFantasiaFonetico == null) {
			if (other.nomeFantasiaFonetico != null)
				return false;
		} else if (!nomeFantasiaFonetico.equals(other.nomeFantasiaFonetico))
			return false;
		if (naturezaJuridica == null) {
			if (other.naturezaJuridica != null)
				return false;
		} else if (!naturezaJuridica.equals(other.naturezaJuridica))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.getId() == null ? null : super.getId().toString();
	}
}