package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.Date;

import br.gov.pa.prodepa.nucleopa.commons.domain.PessoaJuridica;

public class UsuarioComplementoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idUsuario;

	private PessoaJuridica pessoaJuridica;
	
	private byte[] imagem;

	private Date dataManut;

	private Long idUsuarioManut;

	private String codigoOperacaoManut;

	public UsuarioComplementoDto() {
		super();
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
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

	public Long getIdUsuarioManut() {
		return idUsuarioManut;
	}

	public void setIdUsuarioManut(Long idUsuarioManut) {
		this.idUsuarioManut = idUsuarioManut;
	}

	public String getCodigoOperacaoManut() {
		return codigoOperacaoManut;
	}

	public void setCodigoOperacaoManut(String codigoOperacaoManut) {
		this.codigoOperacaoManut = codigoOperacaoManut;
	}

	@Override
	public String toString() {
		return "UsuarioComplementoDtoWS [idUsuario=" + idUsuario
				+ ", dataManut=" + dataManut + "]";
	}
}