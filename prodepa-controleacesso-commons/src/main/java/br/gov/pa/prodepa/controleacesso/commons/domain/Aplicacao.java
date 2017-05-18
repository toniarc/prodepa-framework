package br.gov.pa.prodepa.controleacesso.commons.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.gov.pa.prodepa.domain.Audit;
import br.gov.pa.prodepa.domain.CanEnableOrDisable;
import br.gov.pa.prodepa.nucleopa.commons.domain.Orgao;

/**
 * Aplicacao.
 */
@Entity
@Table(name = "APLICACAO", schema = "controleacesso")
public class Aplicacao extends Audit implements CanEnableOrDisable {

	private static final long serialVersionUID = 5325539986145605090L;

	private Long id;

	private String nome;

	private Orgao orgao;

	private String descricao;

	private String contexto;

	private Boolean ativo;

	private List<Perfil> perfis;
	
	private List<WSPerfil> perfisWebService;

	private List<Funcionalidade> funcionalidades;

	private byte[] logo;
	
	public Aplicacao() {
		super();
	}
	
	public Aplicacao(Long id) {
		super();
		this.id = id;
	}
	
	public Aplicacao(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Aplicacao(Long id, String nome, String descricao, Boolean ativo, Long idOrgao, String sigla){
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.ativo = ativo;
		this.orgao= new Orgao();
		this.orgao.setId(idOrgao);
		this.orgao.setSigla(sigla);
	}
	
	//ap.id, ap.nome, ap.descricao, ap.contexto
	public Aplicacao(Long id, String nome, String descricao, String contexto){
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.contexto = contexto;
	}

	//Construtor incluindo fields idUsuarioManut, dataManut, codigoOperacaoManut - Desenvolvimento: 14/01/2013
	public Aplicacao(Long id, String nome, Orgao orgao, String descricao,
			String contexto, Boolean ativo, List<Perfil> perfis,
			List<Funcionalidade> funcionalidades, Long idUsuarioManut,
			Date dataManut, String codigoOperacaoManut, byte[] logo) {
		super();
		this.id = id;
		this.nome = nome;
		this.orgao = orgao;
		this.descricao = descricao;
		this.contexto = contexto;
		this.ativo = ativo;
		this.perfis = perfis;
		this.funcionalidades = funcionalidades;
		this.setIdUsuarioManut(idUsuarioManut);
		this.setDataManut(dataManut);
		this.setCodigoOperacaoManut(codigoOperacaoManut);
		this.logo = logo;
	}



	public Aplicacao(Long id, String nome, Orgao orgao, String descricao, String contexto, Boolean ativo, List<Perfil> perfis, List<Funcionalidade> funcionalidades, byte[] logo) {
		super();
		this.id = id;
		this.nome = nome;
		this.orgao = orgao;
		this.descricao = descricao;
		this.contexto = contexto;
		this.ativo = ativo;
		this.perfis = perfis;
		this.funcionalidades = funcionalidades;
		this.logo = logo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "descricao", nullable = false, length = 100)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ativo", nullable = false)
	public Boolean getEnable() {
		return ativo;
	}

	public void setEnable(Boolean ativo) {
		this.ativo = ativo;
	}

	@OneToMany(mappedBy = "aplicacao", cascade = CascadeType.REMOVE, fetch=FetchType.LAZY)
	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	@OneToMany(mappedBy = "aplicacao", cascade = CascadeType.REMOVE, fetch=FetchType.LAZY)
	public List<WSPerfil> getPerfisWebService() {
		return perfisWebService;
	}

	public void setPerfisWebService(List<WSPerfil> perfisWebService) {
		this.perfisWebService = perfisWebService;
	}

	@OneToMany(mappedBy = "aplicacao", cascade = CascadeType.REMOVE, fetch=FetchType.LAZY)
	public List<Funcionalidade> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<Funcionalidade> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

	@Column(name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_orgao_gestor")
	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	public boolean hasContexto() {
		return (contexto != null
						&& !contexto.isEmpty()
						&& !contexto.contains(" "));
	}

	@Basic(fetch=FetchType.LAZY)
	@Lob
	@Column(name = "logo")
	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public boolean hasLogo() {
		return (logo != null);
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
		Aplicacao other = (Aplicacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return nome;
	}

}