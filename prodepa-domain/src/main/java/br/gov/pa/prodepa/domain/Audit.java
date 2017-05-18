package br.gov.pa.prodepa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Audit implements Serializable, Model {

	private static final long serialVersionUID = 5471175911621336070L;
	
	private Date dataManut;
	private String codigoOperacaoManut;
	private Long idUsuarioManut;
	
	@Column(name="data_manut")
	public Date getDataManut() {
		return dataManut;
	}

	public void setDataManut(Date dataManut) {
		this.dataManut = dataManut;
	}

	@Column(name="codigo_operacao_manut")
	public String getCodigoOperacaoManut() {
		return codigoOperacaoManut;
	}

	public void setCodigoOperacaoManut(String codigoOperacaoManut) {
		this.codigoOperacaoManut = codigoOperacaoManut;
	}

	public Long getIdUsuarioManut() {
		return idUsuarioManut;
	}

	public void setIdUsuarioManut(Long idUsuarioManut) {
		this.idUsuarioManut = idUsuarioManut;
	}

}
