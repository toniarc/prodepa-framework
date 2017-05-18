package br.gov.pa.prodepa.security.model;

import br.gov.pa.prodepa.controleacesso.client.dto.UsuarioComplementoDtoWS;
import br.gov.pa.prodepa.controleacesso.client.dto.UsuarioDto;

public final class AuthenticatedUser {

	private final Long id;
	private final String login;
	private final String primeiroUltimoNome;
	private final String nomeCompleto;
	private final Long idOrgao;
	private final String siglaOrgao;
	private final String imagemPerfil;
	private final String passaporte;
	private final Long idPessoaJuridica;

	public AuthenticatedUser(UsuarioDto usuarioDto, UsuarioComplementoDtoWS usuarioComplemento) {
		this.id = usuarioDto.getId();
		this.idOrgao = usuarioDto.getIdOrgao();
		this.login = usuarioDto.getLogin();
		this.nomeCompleto = usuarioDto.getNome();
		this.passaporte = usuarioDto.getPassaporte();
		this.siglaOrgao = usuarioDto.getSiglaOrgao();
		
		this.idPessoaJuridica = usuarioComplemento.getIdPessoaJuridica();
		this.imagemPerfil = usuarioComplemento.getImagem();
		
		String[] nameParts = this.nomeCompleto.split(" ");
		if(nameParts.length >= 2){
			this.primeiroUltimoNome = nameParts[0] + " " + nameParts[nameParts.length - 1];
		} else {
			this.primeiroUltimoNome = this.nomeCompleto;
		}
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public Long getIdOrgao() {
		return idOrgao;
	}

	public String getSiglaOrgao() {
		return siglaOrgao;
	}

	public String getImagemPerfil() {
		return imagemPerfil;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public Long getIdPessoaJuridica() {
		return idPessoaJuridica;
	}

	public String getPrimeiroUltimoNome() {
		return primeiroUltimoNome;
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
		AuthenticatedUser other = (AuthenticatedUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuthenticatedUser [id=" + id + ", nome=" + nomeCompleto + ", siglaOrgao=" + siglaOrgao + "]";
	}
	
}
