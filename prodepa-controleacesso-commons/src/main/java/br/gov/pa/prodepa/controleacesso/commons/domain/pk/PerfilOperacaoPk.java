package br.gov.pa.prodepa.controleacesso.commons.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PerfilOperacaoPk implements Serializable {

	private static final long serialVersionUID = -7870944576915948921L;

	private Long idPerfil;
	
	private Long idOperacao;
	
	public PerfilOperacaoPk() {
	}

	public PerfilOperacaoPk(Long idPerfil, Long idOperacao) {
		this.idPerfil = idPerfil;
		this.idOperacao = idOperacao;
	}

	@Column(name="id_perfil")
	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	@Column(name="id_operacao")
	public Long getIdOperacao() {
		return idOperacao;
	}

	public void setIdOperacao(Long idOperacao) {
		this.idOperacao = idOperacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idOperacao == null) ? 0 : idOperacao.hashCode());
		result = prime * result
				+ ((idPerfil == null) ? 0 : idPerfil.hashCode());
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
		PerfilOperacaoPk other = (PerfilOperacaoPk) obj;
		if (idOperacao == null) {
			if (other.idOperacao != null)
				return false;
		} else if (!idOperacao.equals(other.idOperacao))
			return false;
		if (idPerfil == null) {
			if (other.idPerfil != null)
				return false;
		} else if (!idPerfil.equals(other.idPerfil))
			return false;
		return true;
	}
	
	
}
