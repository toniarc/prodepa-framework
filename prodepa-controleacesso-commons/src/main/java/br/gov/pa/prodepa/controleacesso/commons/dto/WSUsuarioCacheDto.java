package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

public class WSUsuarioCacheDto implements Serializable{

	private static final long serialVersionUID = -4195130913216622757L;
	
	public String login;
	public String senha;
	public HashSet<String> operacoes;
	public Date validade;

	public WSUsuarioCacheDto(String login, String senha, List<String> operacoes) {
		super();
		this.login = login;
		this.senha = senha;
		this.operacoes = new HashSet<String>(operacoes);
		this.validade = DateUtils.addMinutes(new Date(), 10);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public HashSet<String> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(HashSet<String> operacoes) {
		this.operacoes = operacoes;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}
	
	public boolean jaExpirou(){
		Date currentDate = new Date();
		return currentDate.after(validade);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		WSUsuarioCacheDto other = (WSUsuarioCacheDto) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	
}
