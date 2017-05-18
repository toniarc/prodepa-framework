package br.gov.pa.prodepa.nucleopa.commons.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.pa.prodepa.domain.Paginable;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;
import br.gov.pa.prodepa.persistence.annotation.Equals;
import br.gov.pa.prodepa.persistence.annotation.Fonetico;
import br.gov.pa.prodepa.persistence.annotation.Like;
import br.gov.pa.prodepa.persistence.annotation.OrderBy;

@Entity
@Table(name = "pais")
@SequenceGenerator(name = "sg_pais", sequenceName = "sq_pais", allocationSize = 1, initialValue = 1)
public class Pais implements Paginable<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Equals
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg_pais")
	private Long id;

	@Like
	@OrderBy
	@Column(length = 100, nullable = false)
	private String descricao;

	@Fonetico
	@Column(name = "descricao_fonetica", length = 200)
	private String descricaoFonetica;

	@Equals
	@Column(name ="codigo_onu", length = 3, nullable = false)
	private String codigoOnu;

	@Equals
	@Column(name ="sigla2_onu", length = 2, nullable = false)
	private String siglaOnu2;

	@Equals
	@Column(name ="sigla3_onu", length = 3, nullable = false)
	private String siglaOnu3;

	@Equals
	@Enumerated
	@Column(name = "ativo", nullable = false)
	private TipoBoleano ativo;

	public Pais() {
		super();
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

	public String getDescricaoFonetica() {
		return descricaoFonetica;
	}

	public void setDescricaoFonetica(String descricaoFonetica) {
		this.descricaoFonetica = descricaoFonetica;
	}

	public String getCodigoOnu() {
		return codigoOnu;
	}

	public void setCodigoOnu(String codigoOnu) {
		this.codigoOnu = codigoOnu;
	}

	public String getSiglaOnu2() {
		return siglaOnu2;
	}

	public void setSiglaOnu2(String siglaOnu2) {
		this.siglaOnu2 = siglaOnu2;
	}

	public String getSiglaOnu3() {
		return siglaOnu3;
	}

	public void setSiglaOnu3(String siglaOnu3) {
		this.siglaOnu3 = siglaOnu3;
	}

	public TipoBoleano getAtivo() {
		return ativo;
	}

	public void setAtivo(TipoBoleano ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((codigoOnu == null) ? 0 : codigoOnu.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((descricaoFonetica == null) ? 0 : descricaoFonetica.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((siglaOnu2 == null) ? 0 : siglaOnu2.hashCode());
		result = prime * result + ((siglaOnu3 == null) ? 0 : siglaOnu3.hashCode());
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
		Pais other = (Pais) obj;
		if (ativo != other.ativo)
			return false;
		if (codigoOnu == null) {
			if (other.codigoOnu != null)
				return false;
		} else if (!codigoOnu.equals(other.codigoOnu))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (descricaoFonetica == null) {
			if (other.descricaoFonetica != null)
				return false;
		} else if (!descricaoFonetica.equals(other.descricaoFonetica))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (siglaOnu2 == null) {
			if (other.siglaOnu2 != null)
				return false;
		} else if (!siglaOnu2.equals(other.siglaOnu2))
			return false;
		if (siglaOnu3 == null) {
			if (other.siglaOnu3 != null)
				return false;
		} else if (!siglaOnu3.equals(other.siglaOnu3))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id == null ? null : id.toString();
	}
}