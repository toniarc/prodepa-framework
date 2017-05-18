package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;

public class WSUsuarioDto implements Serializable {

	private static final long serialVersionUID = 6623307122517016260L;

	private String confirmacaoSenha;

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}
	
}