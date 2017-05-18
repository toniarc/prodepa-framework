package br.gov.pa.prodepa.nucleopa.commons.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.gov.pa.prodepa.domain.Paginable;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;
import br.gov.pa.prodepa.nucleopa.commons.dto.OrgaoDto;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.Esfera;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.SituacaoOrgao;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.TipoAdministracao;
import br.gov.pa.prodepa.persistence.annotation.Equals;
import br.gov.pa.prodepa.persistence.annotation.Like;

@Entity
@Table(name = "orgao")
public class Orgao implements Paginable<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Equals
	@Column(name = "id_orgao")
	private Long id;

	@OneToOne(optional = false)
	@PrimaryKeyJoinColumn
	private PessoaJuridica pessoaJuridica;

	@Like
	@Column(length = 100)
	private String sigla;

	@Equals
	@Column(name = "id_orgao_adabas", length = 5)
	private String codigoAdabas;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ato_legal")
	private Date dataAtoLegal;

	@Like
	@Column(name="numero_ato_legal", length = 100)
	private String numeroAtoLegal;

	// Inicio Vigencia
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "vigencia")
	private Date dataVigencia;

	@Equals
	@Enumerated
	@Column(name = "id_tipo_administracao") // , nullable = false)
	private TipoAdministracao tipoAdministracao;

	@Equals
	@ManyToOne
	@JoinColumn(name = "id_categoria") // , nullable = false)
	private Categoria categoria;

	@Equals
	@Enumerated
	@Column
	private Esfera esfera;

	@Equals
	@Enumerated
	@Column(nullable = false)
	private SituacaoOrgao situacao;

	@Equals
	@Enumerated
	@Column(nullable = false)
	private TipoBoleano ativo;

	// Extincao

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ato_legal_extincao")
	private Date dataAtoLegalExtincao;

	@Like
	@Column(name="numero_ato_legal_extincao", length = 100)
	private String numeroAtoLegalExtincao;

	// Inicio Vigencia
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "vigencia_extincao")
	private Date dataVigenciaExtincao;

	// Lists

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

	@Column(name ="codigo_operacao_manut", length = 20)
	private String codigoOperacao;

	// 

	@Transient
	private OrgaoDto dto;

	public Orgao() {
		super();
	}

	public Orgao(SituacaoOrgao situacao) {
		super();
		this.situacao = situacao;
	}

	public Orgao(Long idOrgao, String siglaOrgao) {
		this.id = idOrgao;
		this.sigla = siglaOrgao;
	}

	public Long getKey() {
		return getId();
	}

	public void setKey(Long key) {
		setId(key);
	}

	public boolean isSituacaoAtivo() {
		return situacao != null && situacao.equals(SituacaoOrgao.ATIVO);
	}

	public boolean isSituacaoInativo() {
		return situacao != null && situacao.equals(SituacaoOrgao.INATIVO);
	}

	public boolean isSituacaoExtinto() {
		return situacao != null && situacao.equals(SituacaoOrgao.EXTINTO);
	}

	// 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCodigoAdabas() {
		return codigoAdabas;
	}

	public void setCodigoAdabas(String codigoAdabas) {
		this.codigoAdabas = codigoAdabas;
	}

	public Date getDataAtoLegal() {
		return dataAtoLegal;
	}

	public void setDataAtoLegal(Date dataAtoLegal) {
		this.dataAtoLegal = dataAtoLegal;
	}

	public String getNumeroAtoLegal() {
		return numeroAtoLegal;
	}

	public void setNumeroAtoLegal(String numeroAtoLegal) {
		this.numeroAtoLegal = numeroAtoLegal;
	}

	public Date getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public TipoAdministracao getTipoAdministracao() {
		return tipoAdministracao;
	}

	public void setTipoAdministracao(TipoAdministracao tipoAdministracao) {
		this.tipoAdministracao = tipoAdministracao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Esfera getEsfera() {
		return esfera;
	}

	public void setEsfera(Esfera esfera) {
		this.esfera = esfera;
	}

	public SituacaoOrgao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoOrgao situacao) {
		this.situacao = situacao;
	}

	public TipoBoleano getAtivo() {
		return ativo;
	}

	public void setAtivo(TipoBoleano ativo) {
		this.ativo = ativo;
	}

	public Date getDataAtoLegalExtincao() {
		return dataAtoLegalExtincao;
	}

	public void setDataAtoLegalExtincao(Date dataAtoLegalExtincao) {
		this.dataAtoLegalExtincao = dataAtoLegalExtincao;
	}

	public String getNumeroAtoLegalExtincao() {
		return numeroAtoLegalExtincao;
	}

	public void setNumeroAtoLegalExtincao(String numeroAtoLegalExtincao) {
		this.numeroAtoLegalExtincao = numeroAtoLegalExtincao;
	}

	public Date getDataVigenciaExtincao() {
		return dataVigenciaExtincao;
	}

	public void setDataVigenciaExtincao(Date dataVigenciaExtincao) {
		this.dataVigenciaExtincao = dataVigenciaExtincao;
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

	public String getCodigoOperacao() {
		return codigoOperacao;
	}

	public void setCodigoOperacao(String codigoOperacao) {
		this.codigoOperacao = codigoOperacao;
	}

	public OrgaoDto getDto() {
		if (dto == null) {
			dto = new OrgaoDto();
		}
		return dto;
	}

	public void setDto(OrgaoDto dto) {
		this.dto = dto;
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
		Orgao other = (Orgao) obj;
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