package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author antonio_junior
 * 
 *         <p>
 *         Este dto é usado nos métodos alterarDadosComplementaresUsuario e
 *         buscarDadosComplementaresUsuario ambos da classe
 *         ControleAcessoFacadeBeanWS.
 *         </p>
 */
public class UsuarioComplementoDtoWS implements Serializable {

	private static final long serialVersionUID = 8477453933120198100L;

	private Long idUsuario;

	private Long idPessoaJuridica;
	
	private byte[] imagem;

	private Date dataManut;

	public UsuarioComplementoDtoWS() {
		super();
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdPessoaJuridica() {
		return idPessoaJuridica;
	}

	public void setIdPessoaJuridica(Long idPessoaJuridica) {
		this.idPessoaJuridica = idPessoaJuridica;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Date getDataManut() {
		return dataManut;
	}

	public void setDataManut(Date dataManut) {
		this.dataManut = dataManut;
	}

	@Override
	public String toString() {
		return "UsuarioComplementoDtoWS [idUsuario=" + idUsuario
				+ ", dataManut=" + dataManut + "]";
	}
}