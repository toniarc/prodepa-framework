package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.util.Date;
import java.util.List;

import br.gov.pa.prodepa.controleacesso.commons.domain.Funcionalidade;
import br.gov.pa.prodepa.controleacesso.commons.domain.Perfil;
import br.gov.pa.prodepa.domain.Model;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;
import br.gov.pa.prodepa.nucleopa.commons.domain.Orgao;

/**
 * Objeto utilizado no transporte de dados sobre uma aplicacao.
 * 
 * @author Bruno Ribeiro
 */
public class AplicacaoDto implements Model {

	private static final long serialVersionUID = 188123637125419L;

	/** Identificador da aplicacao. */
	private Long id;

	/** Nome da aplicacao. */
	private String nome;

	/** Orgao da aplicacao. */
	private Orgao orgao;

	/** Descricao de uma aplicacao. */
	private String descricao;

	/** Contexto de uma aplicacao. */
	private String contexto;

	/** Indica se uma aplicacao esta ativa ou nao. */
	private TipoBoleano ativo;

	/** Funcionalidades da aplicacao. */
	private List<Perfil> perfis;

	/** Perfis da aplicacao. */
	private List<Funcionalidade> funcionalidades;

	/** Imagem da aplicacao. */
	private byte[] logo;
	
	private Long idUsuarioManut;
	
	private Date dataManut;
	
	private String codigoOperacaoManut; 
	

	/** Construtor padrao. */
	public AplicacaoDto() {
		super();
	}
	
	//Construtor incluindo fields idUsuarioManut, dataManut, codigoOperacaoManut - Desenvolvimento: 14/01/2013
	public AplicacaoDto(Long id, String nome, Orgao orgao, String descricao,
			String contexto, TipoBoleano ativo, List<Perfil> perfis,
			List<Funcionalidade> funcionalidades, byte[] logo,
			Long idUsuarioManut, Date dataManut, String codigoOperacaoManut) {
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
		this.idUsuarioManut = idUsuarioManut;
		this.dataManut = dataManut;
		this.codigoOperacaoManut = codigoOperacaoManut;
	}


	/**
	 * Construtor para inicicar os atributos.
	 */
	public AplicacaoDto(Long id, String nome, Orgao orgao, String descricao, String contexto, TipoBoleano ativo, List<Perfil> perfis, List<Funcionalidade> funcionalidades, byte[] logo) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoBoleano getAtivo() {
		return ativo;
	}

	public void setAtivo(TipoBoleano ativo) {
		this.ativo = ativo;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public List<Funcionalidade> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<Funcionalidade> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public boolean hasLogo() {
		return (logo != null);
	}
	

	public Long getIdUsuarioManut() {
		return idUsuarioManut;
	}

	public void setIdUsuarioManut(Long idUsuarioManut) {
		this.idUsuarioManut = idUsuarioManut;
	}

	public Date getDataManut() {
		return dataManut;
	}

	public void setDataManut(Date dataManut) {
		this.dataManut = dataManut;
	}

	public String getCodigoOperacaoManut() {
		return codigoOperacaoManut;
	}

	public void setCodigoOperacaoManut(String codigoOperacaoManut) {
		this.codigoOperacaoManut = codigoOperacaoManut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
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
		AplicacaoDto other = (AplicacaoDto) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return this.nome;
	}
}