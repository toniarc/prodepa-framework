package br.gov.pa.prodepa.nucleopa.commons.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import br.gov.pa.prodepa.nucleopa.commons.dto.MesorregiaoDto;
import br.gov.pa.prodepa.persistence.annotation.Equals;
import br.gov.pa.prodepa.persistence.annotation.Like;
import br.gov.pa.prodepa.persistence.annotation.OrderBy;

@Entity
@Table(name = "mesorregiao")
@SequenceGenerator(name = "sg_mesorregiao", sequenceName = "sq_mesorregiao", initialValue = 1, allocationSize = 1)
public class Mesorregiao implements Paginable<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Equals
	@GeneratedValue(generator = "sg_mesorregiao", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Like
	@OrderBy
	@Column(length = 100, nullable = false)
	private String descricao;

	@Equals
	@Column(name ="codigo_ibge", length = 6, nullable = false)
	private String codigoIbge;

	@Equals
	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false)
	private Estado estado;

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
	private MesorregiaoDto dto;

	public Mesorregiao() {
		super();
	}

	public Mesorregiao(Estado estado) {
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

	public String getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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

	public MesorregiaoDto getDto() {
		if (dto == null) {
			dto = new MesorregiaoDto();
		}
		return dto;
	}

	public void setDto(MesorregiaoDto dto) {
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
		Mesorregiao other = (Mesorregiao) obj;
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