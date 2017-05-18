package br.gov.pa.prodepa.controleacesso.commons.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.gov.pa.prodepa.controleacesso.commons.dto.UsuarioDto;
import br.gov.pa.prodepa.domain.Audit;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;
import br.gov.pa.prodepa.nucleopa.commons.domain.Orgao;

/**
 * Usuario.
 */
@Entity
@Table(name = "USUARIO", schema = "controleacesso")
public class Usuario extends Audit {

	private static final long serialVersionUID = -8725373075565538482L;

	private Long id;

	private String login;

	private String nome;

	private String senha;

	private String email;

	private String nomeFonetico;
	
	private TipoDocumento tipoDocumento;
	
	private String numeroDocumento;

	private TipoBoleano ativo;
	
	private Orgao orgao;

	private List<UsuarioPerfil> perfis;
	
	private List<HistoricoSituacao> historicoSituacoes;

	private TipoBoleano trocouSenha;
	
	private UsuarioDto atributosComplementares = new UsuarioDto();
	
	public Usuario() {
		super();
	}

	public Usuario(Long id) {
		super();
		this.id = id;
	}
	
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public Usuario(Long id, String login, String nome, Long idOrgao, String siglaOrgao, String numeroDocumento, TipoBoleano trocouSenha, TipoDocumento tipoDocumento, TipoBoleano ativo) {
		super();
		this.id = id;
		this.login = login;
		this.nome = nome;
		this.ativo = ativo;
		this.trocouSenha = trocouSenha;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		
		this.orgao = new Orgao();
		this.orgao.setId(idOrgao);
		this.orgao.setSigla(siglaOrgao);
	}
	
				  //a.id,   a.login,      a.nome,      o.id,         o.sigla,           a.numeroDocumento,      a.trocouSenha,           a.tipoDocumento,             a.ativo,           a.email
	public Usuario(Long id, String login, String nome, Long idOrgao, String siglaOrgao, String numeroDocumento, TipoBoleano trocouSenha, TipoDocumento tipoDocumento, TipoBoleano ativo, String email) {
		super();
		this.id = id;
		this.login = login;
		this.nome = nome;
		this.ativo = ativo;
		this.trocouSenha = trocouSenha;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.email = email;
		
		this.orgao = new Orgao();
		this.orgao.setId(idOrgao);
		this.orgao.setSigla(siglaOrgao);
	}
	
	public Usuario(Long id, String login, String nome, String email, TipoBoleano ativo, TipoBoleano trocouSenha, TipoDocumento documento, String numeroDocumento) {
		super();
		this.id = id;
		this.login = login;
		this.nome = nome;
		this.email = email;
		this.ativo = ativo;
		this.trocouSenha = trocouSenha;
		this.tipoDocumento = documento;
		this.numeroDocumento = numeroDocumento;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "LOGIN", nullable = false, unique = true)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "NOME", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "SENHA", nullable = false)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_ORGAO", nullable = false)
	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	//@OrderBy("perfil.aplicacao.nome, perfil.codigo")
	public List<UsuarioPerfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<UsuarioPerfil> perfis) {
		this.perfis = perfis;
	}

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "SITUACAO", nullable = false)
	public TipoBoleano getAtivo() {
		return ativo;
	}

	public void setAtivo(TipoBoleano situacao) {
		this.ativo = situacao;
	}

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "TROCOU_SENHA", nullable = true)
	public TipoBoleano getTrocouSenha() {
		return trocouSenha;
	}

	public void setTrocouSenha(TipoBoleano trocouSenha) {
		this.trocouSenha = trocouSenha;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "TIPO_DOCUMENTO")
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Column(name = "NUMERO_DOCUMENTO")
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	@Column(name = "NOME_FON")
	public String getNomeFonetico() {
		return nomeFonetico;
	}

	public void setNomeFonetico(String nomeFonetico) {
		this.nomeFonetico = nomeFonetico;
	}

	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	public List<HistoricoSituacao> getHistoricoSituacoes() {
		return historicoSituacoes;
	}

	public void setHistoricoSituacoes(List<HistoricoSituacao> historicoSituacoes) {
		this.historicoSituacoes = historicoSituacoes;
	}

	@Transient
	public UsuarioDto getAtributosComplementares() {
		return atributosComplementares;
	}

	public void setAtributosComplementares(UsuarioDto atributosComplementares) {
		this.atributosComplementares = atributosComplementares;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	public String toString() {
		return this.nome;
	}
}