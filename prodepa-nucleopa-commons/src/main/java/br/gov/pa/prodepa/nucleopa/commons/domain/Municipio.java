package br.gov.pa.prodepa.nucleopa.commons.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import br.gov.pa.prodepa.nucleopa.commons.dto.MunicipioDto;
import br.gov.pa.prodepa.persistence.annotation.Equals;
import br.gov.pa.prodepa.persistence.annotation.Fonetico;
import br.gov.pa.prodepa.persistence.annotation.Like;
import br.gov.pa.prodepa.persistence.annotation.OrderBy;

@Entity
@Table(name = "municipio")
@SequenceGenerator(name = "sg_municipio", sequenceName = "sq_municipio", initialValue = 1, allocationSize = 1)
public class Municipio implements Paginable<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Equals
	@GeneratedValue(generator = "sg_municipio", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Like
	@OrderBy
	@Column(length = 100, nullable = false)
	private String descricao;

	@Fonetico
	@Column(name = "descricao_fonetica", length = 200)
	private String descricaoFonetica;

	@Equals
	@Column(name ="codigo_ibge", length = 7)
	private String codigoIbge;

	@Equals
	@Column(name ="codigo_dne")
	private Integer codigoDne;

	@Equals
	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false)
	private Estado estado;

	@Equals
	@ManyToOne
	@JoinColumn(name = "id_microrregiao")
	private Microrregiao microrregiao;

	@Equals
	@ManyToOne
	@JoinColumn(name = "id_regional")
	private Regional regional;

	@Equals
	@Enumerated
	@Column(nullable = false)
	private TipoBoleano ativo;

	// Autoria

	@Equals
	@Column(nullable = false)
	private Integer versao;

	@Column(name = "id_usuario_manut")
	private Long idUsuarioManutencao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manut")
	private Date dataManutencao;

	@Column(name ="codigo_operacao_manut", length = 20)
	private String codigoOperacao;

	// 

	@Transient
	private MunicipioDto dto;

	public Municipio() {
		super();
	}

	public Municipio(Long id) {
		super();
		this.id = id;
	}

	public Municipio(Estado estado) {
		super();
		this.estado = estado;
	}

	public Long getKey() {
		return id;
	}

	public void setKey(Long key) {
		this.id = key;
	}

	public void changeRegiao() {
		estado = null;
		getDto().setMesorregiao(null);
		microrregiao = null;
		regional = null;
	}

	public void changeEstado() {
		getDto().setMesorregiao(null);
		microrregiao = null;
		regional = null;
	}

	public void changeMesorregiao() {
		microrregiao = null;
	}

	// changeMicrorregiao

	// changeRegional

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

	public String getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public Integer getCodigoDne() {
		return codigoDne;
	}

	public void setCodigoDne(Integer codigoDne) {
		this.codigoDne = codigoDne;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Microrregiao getMicrorregiao() {
		return microrregiao;
	}

	public void setMicrorregiao(Microrregiao microrregiao) {
		this.microrregiao = microrregiao;
	}

	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	public TipoBoleano getAtivo() {
		return ativo;
	}

	public void setAtivo(TipoBoleano ativo) {
		this.ativo = ativo;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
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

	public MunicipioDto getDto() {
		if (dto == null) {
			dto = new MunicipioDto();
		}
		return dto;
	}

	public void setDto(MunicipioDto dto) {
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
		Municipio other = (Municipio) obj;
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