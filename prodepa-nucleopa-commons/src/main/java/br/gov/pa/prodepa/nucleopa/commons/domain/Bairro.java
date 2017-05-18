package br.gov.pa.prodepa.nucleopa.commons.domain;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.gov.pa.prodepa.domain.Paginable;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;
import br.gov.pa.prodepa.nucleopa.commons.dto.BairroDto;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.TipoLocalidade;
import br.gov.pa.prodepa.persistence.annotation.Equals;
import br.gov.pa.prodepa.persistence.annotation.Fonetico;
import br.gov.pa.prodepa.persistence.annotation.Like;
import br.gov.pa.prodepa.persistence.annotation.OrderBy;

@Entity
@Table(name = "bairro")
@SequenceGenerator(name = "sg_bairro", sequenceName = "sq_bairro", initialValue = 1, allocationSize = 1)
public class Bairro implements Paginable<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Equals
	@Column(nullable = false)
	@GeneratedValue(generator = "sg_bairro", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Like
	@OrderBy
	@Column(length = 100, nullable = false)
	private String descricao;

	@Fonetico
	@Column(name = "descricao_fonetica", length = 200)
	private String descricaoFonetica;

	@Equals
	@Column(name ="codigo_dne")
	private Integer codigoDne;

	@Equals
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_localidade_dne", nullable = false)
	private TipoLocalidade tipoLocalidade;

	@Equals
	@ManyToOne
	@JoinColumn(name = "id_municipio", nullable = false)
	private Municipio municipio;

	@Equals
	@ManyToOne
	@JoinColumn(name = "id_localidade")
	private Localidade localidade;

	@Equals
	@Enumerated
	@Column(name = "ativo", nullable = false)
	private TipoBoleano ativo;

	// Autoria

	@Column(name = "id_usuario_manut")
	private Long idUsuarioManutencao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manut")
	private Date dataManutencao;

	@Column(name ="codigo_operacao_manut", length = 20)
	private String codigoOperacao;

	// 

	@Transient
	private BairroDto dto;

	public Bairro() {
		super();
	}

	public Bairro(Long id) {
		super();
		this.id = id;
	}

	public Bairro(TipoBoleano ativo) {
		super();
		this.ativo = ativo;
	}

	// 

	public Long getKey() {
		return id;
	}

	public void setKey(Long key) {
		this.id = key;
	}

	public void changeEstado() {
		municipio = null;
		localidade  = null;
	}

	public void changeMunicipio() {
		localidade  = null;
	}

	// 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoFonetica() {
		return descricaoFonetica;
	}

	public void setDescricaoFonetica(String descricaoFonetica) {
		this.descricaoFonetica = descricaoFonetica;
	}

	public Integer getCodigoDne() {
		return codigoDne;
	}

	public void setCodigoDne(Integer codigoDne) {
		this.codigoDne = codigoDne;
	}

	public TipoLocalidade getTipoLocalidade() {
		return tipoLocalidade;
	}

	public void setTipoLocalidade(TipoLocalidade tipoLocalidade) {
		this.tipoLocalidade = tipoLocalidade;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public TipoBoleano getAtivo() {
		return ativo;
	}

	public void setAtivo(TipoBoleano ativo) {
		this.ativo = ativo;
	}

	public Long getIdUsuarioManutencao() {
		return idUsuarioManutencao;
	}

	public void setIdUsuarioManutencao(Long idUsuarioManutencao) {
		this.idUsuarioManutencao = idUsuarioManutencao;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public String getCodigoOperacao() {
		return codigoOperacao;
	}

	public void setCodigoOperacao(String codigoOperacao) {
		this.codigoOperacao = codigoOperacao;
	}

	public BairroDto getDto() {
		if (dto == null) {
			dto = new BairroDto();
		}
		return dto;
	}

	public void setDto(BairroDto dto) {
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
		Bairro other = (Bairro) obj;
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