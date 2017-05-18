package br.gov.pa.prodepa.controleacesso.commons.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.pa.prodepa.domain.Audit;
import br.gov.pa.prodepa.nucleopa.commons.domain.PessoaJuridica;

/**
 * @author antonio_junior
 * 
 *         <p>
 *         Esta entidade é usada nos métodos alterarDadosComplementaresUsuario e
 *         buscarDadosComplementaresUsuario ambos da classe UsuarioServicoBean.
 *         </p>
 */
@Entity
@Table(name = "usuario_complemento", schema = "controleacesso")
public class UsuarioComplemento extends Audit {

	private static final long serialVersionUID = 6836406949039256608L;

	/** Identificador de um usuario. */
	private Long id;

	private PessoaJuridica pessoaJuridica;

	private byte[] imagem;

	public UsuarioComplemento() {
		super();
	}

	public UsuarioComplemento(Long id) {
		super();
		this.id = id;
	}

	@Id
	@Column(name = "ID_USUARIO", nullable = false)
	public Long getId() {
		return id;
	}

	@ManyToOne
	@JoinColumn(name = "ID_PESSOA_JURIDICA")
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	@Lob
	@Column(name = "IMAGEM")
	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public void setId(Long id) {
		this.id = id;
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
		UsuarioComplemento other = (UsuarioComplemento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}