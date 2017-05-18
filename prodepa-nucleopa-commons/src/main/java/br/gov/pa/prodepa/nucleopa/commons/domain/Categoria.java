package br.gov.pa.prodepa.nucleopa.commons.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.pa.prodepa.domain.Paginable;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.TipoAdministracao;
import br.gov.pa.prodepa.persistence.annotation.Equals;
import br.gov.pa.prodepa.persistence.annotation.Like;
import br.gov.pa.prodepa.persistence.annotation.OrderBy;

@Entity
@Table(name = "categoria")
@SequenceGenerator(name = "sg_categoria", sequenceName = "sq_categoria", allocationSize = 1, initialValue = 1)
public class Categoria implements Paginable<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Equals
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg_categoria")
	private Long id;

	@Like
	@OrderBy
	@Column(length = 100, nullable = false)
	private String descricao;

	@Equals
	@Enumerated
	@Column(name = "tipo_administracao", nullable = false)
	private TipoAdministracao tipoAdministracao;

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

	public Categoria() {
		super();
	}

	public Categoria(TipoBoleano ativo) {
		super();
		this.ativo = ativo;
	}

	public Long getKey() {
		return id;
	}

	public void setKey(Long key) {
		this.id = key;
	}

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

	public TipoAdministracao getTipoAdministracao() {
		return tipoAdministracao;
	}

	public void setTipoAdministracao(TipoAdministracao tipoAdministracao) {
		this.tipoAdministracao = tipoAdministracao;
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
		Categoria other = (Categoria) obj;
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