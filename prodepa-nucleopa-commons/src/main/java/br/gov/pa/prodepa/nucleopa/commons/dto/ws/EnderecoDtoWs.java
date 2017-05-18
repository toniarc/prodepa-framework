package br.gov.pa.prodepa.nucleopa.commons.dto.ws;

import java.io.Serializable;
import java.util.Date;

public class EnderecoDtoWs implements Serializable {

	private static final long serialVersionUID = -7348956368397495717L;

	private Long id;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String numero;
	private String cep;

	private EstadoDtoWs estadoDto;
	private MunicipioDtoWs municipioDto;

	private Long idMunicipio;
	private String descricaoMunicipio;

	private Date dataManut;
	private Long idUsuarioManut;
	private Long idAplicacaoManut;
	
	public EnderecoDtoWs() {
		super();
	}

	public EnderecoDtoWs(String logradouro, String complemento, String bairro,
			String numero, String cep, EstadoDtoWs estado, MunicipioDtoWs municipio) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
		this.estadoDto = estado;
		this.municipioDto = municipio;
	}

	public EnderecoDtoWs(String logradouro, String complemento, String bairro,
			String numero, String cep, EstadoDtoWs estado, MunicipioDtoWs municipio,
			Date dataManut, Long idUsuarioManut, Long idAplicacaoManut) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
		this.estadoDto = estado;
		this.municipioDto = municipio;
		this.dataManut = dataManut;
		this.idUsuarioManut = idUsuarioManut;
		this.idAplicacaoManut = idAplicacaoManut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getDescricaoMunicipio() {
		return descricaoMunicipio;
	}

	public void setDescricaoMunicipio(String descricaoMunicipio) {
		this.descricaoMunicipio = descricaoMunicipio;
	}

	public EstadoDtoWs getEstadoDto() {
		return estadoDto;
	}

	public void setEstadoDto(EstadoDtoWs estadoDto) {
		this.estadoDto = estadoDto;
	}

	public MunicipioDtoWs getMunicipioDto() {
		return municipioDto;
	}

	public void setMunicipioDto(MunicipioDtoWs municipioDto) {
		this.municipioDto = municipioDto;
	}

	public Date getDataManut() {
		return dataManut;
	}

	public void setDataManut(Date dataManut) {
		this.dataManut = dataManut;
	}

	public Long getIdUsuarioManut() {
		return idUsuarioManut;
	}

	public void setIdUsuarioManut(Long idUsuarioManut) {
		this.idUsuarioManut = idUsuarioManut;
	}

	public Long getIdAplicacaoManut() {
		return idAplicacaoManut;
	}

	public void setIdAplicacaoManut(Long idAplicacaoManut) {
		this.idAplicacaoManut = idAplicacaoManut;
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
		EnderecoDtoWs other = (EnderecoDtoWs) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + id + " " + logradouro + " " + bairro + " " + numero + " ]";
	}

}

