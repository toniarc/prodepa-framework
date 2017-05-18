package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.List;

import br.gov.pa.prodepa.controleacesso.commons.domain.Aplicacao;
import br.gov.pa.prodepa.controleacesso.commons.domain.HistoricoSituacao;
import br.gov.pa.prodepa.controleacesso.commons.domain.Perfil;

public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = 188123637156989L;

	private String passaporte;

	private List<String> operacoes;
	
	private List<Aplicacao> aplicacoes;
	
	private List<Perfil> perfis;
	
	private List<Aplicacao> aplicacoesGerente;
	
	private List<Aplicacao> aplicacoesGerenteOrgao;
	
	private Aplicacao aplicacao;
	
	private String confirmacaoSenha;
	
	private HistoricoSituacao historicoSituacao = new HistoricoSituacao();

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	public List<String> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<String> operacoes) {
		this.operacoes = operacoes;
	}

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public void setAplicacoes(List<Aplicacao> aplicacoes) {
		this.aplicacoes = aplicacoes;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfils) {
		this.perfis = perfils;
	}

	public List<Aplicacao> getAplicacoesGerente() {
		return aplicacoesGerente;
	}

	public void setAplicacoesGerente(List<Aplicacao> aplicacoesGerente) {
		this.aplicacoesGerente = aplicacoesGerente;
	}

	public List<Aplicacao> getAplicacoesGerenteOrgao() {
		return aplicacoesGerenteOrgao;
	}

	public void setAplicacoesGerenteOrgao(List<Aplicacao> aplicacoesGerenteOrgao) {
		this.aplicacoesGerenteOrgao = aplicacoesGerenteOrgao;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public HistoricoSituacao getHistoricoSituacao() {
		return historicoSituacao;
	}

	public void setHistoricoSituacao(HistoricoSituacao historicoSituacao) {
		this.historicoSituacao = historicoSituacao;
	}
	
}