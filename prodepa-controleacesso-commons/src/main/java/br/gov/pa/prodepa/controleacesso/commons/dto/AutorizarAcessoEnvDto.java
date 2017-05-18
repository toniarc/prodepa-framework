package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;

public class AutorizarAcessoEnvDto implements Serializable {

	private static final long serialVersionUID = 1519876674135899679L;

	private Long idAplicacao; 
	private String passaporte; 
	private boolean atualizarAcesso;
	
	public AutorizarAcessoEnvDto() {
	}

	public Long getIdAplicacao() {
		return idAplicacao;
	}

	public void setIdAplicacao(Long idAplicacao) {
		this.idAplicacao = idAplicacao;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	public boolean isAtualizarAcesso() {
		return atualizarAcesso;
	}

	public void setAtualizarAcesso(boolean atualizarAcess) {
		this.atualizarAcesso = atualizarAcess;
	}
	
}
