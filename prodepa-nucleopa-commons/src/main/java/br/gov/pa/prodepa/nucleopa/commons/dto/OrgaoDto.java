package br.gov.pa.prodepa.nucleopa.commons.dto;

import java.io.Serializable;

public class OrgaoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeFonetico;
	private String nomeFantasiaFonetico;
	private String sigla;
	private String cnpj;

	public OrgaoDto() {
		super();
	}

	public OrgaoDto(Long id, String sigla) {
		super();
		this.id = id;
		this.sigla = sigla;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFonetico() {
		return nomeFonetico;
	}

	public void setNomeFonetico(String nomeFonetico) {
		this.nomeFonetico = nomeFonetico;
	}

	public String getNomeFantasiaFonetico() {
		return nomeFantasiaFonetico;
	}

	public void setNomeFantasiaFonetico(String nomeFantasiaFonetico) {
		this.nomeFantasiaFonetico = nomeFantasiaFonetico;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
		OrgaoDto other = (OrgaoDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return sigla;
	}
}