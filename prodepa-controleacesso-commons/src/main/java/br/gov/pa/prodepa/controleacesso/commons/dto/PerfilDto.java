package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.List;

import br.gov.pa.prodepa.controleacesso.commons.domain.Operacao;

/**
 * Objeto para transporte de dados referentes a um perfil de usuario.
 * 
 * @author Bruno Ribeiro
 */
public class PerfilDto implements Serializable {

	private static final long serialVersionUID = 188123637122322L;

	private List<Operacao> operacoes;
	
	public PerfilDto() {
		super();
	}

	public List<Operacao> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<Operacao> operacoes) {
		this.operacoes = operacoes;
	}
	
}