package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;


public class BuscaSessaoDto implements Serializable {

	private static final long serialVersionUID = 3437436027714430319L;

	private Long idUsuario;
	private String passaporte;

	public BuscaSessaoDto() {
		super();
	}

	public BuscaSessaoDto(Long idUsuario, String passaporte) {
		super();
		this.idUsuario = idUsuario;
		this.passaporte = passaporte;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}
}