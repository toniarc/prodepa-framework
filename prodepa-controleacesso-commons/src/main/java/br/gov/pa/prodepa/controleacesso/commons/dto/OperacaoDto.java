package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import br.gov.pa.prodepa.controleacesso.commons.domain.Aplicacao;
import br.gov.pa.prodepa.controleacesso.commons.domain.Funcionalidade;
import br.gov.pa.prodepa.controleacesso.commons.domain.Perfil;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;

/**
 * Objeto de transporte de dados referente a uma operacao de uma operacao.
 * 
 * @author Bruno Ribeiro
 */
public class OperacaoDto implements Serializable {

	private static final long serialVersionUID = 652723637122319L;

	/** Identificador da operacao. */
	private Long id;

	/** Descricao da operacao. */
	private String descricao;

	/** Codigo de uma operacao. */
	private String codigo;

	/** Indica se uma operacao esta ativa ou nao. */
	private TipoBoleano ativo;

	/** Funcionalidade na qual a operacao esta associada. */
	private Funcionalidade funcionalidade;

	/** Perfis de usuarios associados a uma operacao. */
	private List<Perfil> perfis;

	/** Aplicacao na qual a operacao esta associada. */
	private Aplicacao aplicacao;

	@Transient
	private String codigoReduzido;

	@Transient
	private String codigoReduzidoAlteracao;

	private String codigoOperacaoManut;

	private Date dataManut;

	private Long idUsuarioManut;

	/** Construtor padrao. */
	public OperacaoDto() {
		super();
	}

	public OperacaoDto(Aplicacao aplicacao, Funcionalidade funcionalidade) {
		super();
		this.funcionalidade = funcionalidade;
		this.aplicacao = aplicacao;
	}

	public OperacaoDto(Long id, String descricao, String codigo,
			TipoBoleano ativo, Funcionalidade funcionalidade,
			List<Perfil> perfis, Aplicacao aplicacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigo = codigo;
		this.ativo = ativo;
		this.funcionalidade = funcionalidade;
		this.perfis = perfis;
		this.aplicacao = aplicacao;
	}

	public OperacaoDto(Long id, String descricao, String codigo,
			TipoBoleano ativo, Funcionalidade funcionalidade,
			List<Perfil> perfis, Aplicacao aplicacao, String codigoOperacaoManut,
			Date dataManut, Long idUsuarioManut) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigo = codigo;
		this.ativo = ativo;
		this.funcionalidade = funcionalidade;
		this.perfis = perfis;
		this.aplicacao = aplicacao;
		this.codigoOperacaoManut = codigoOperacaoManut;
		this.dataManut = dataManut;
		this.idUsuarioManut = idUsuarioManut;
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

	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public String getCodigoReduzido() {
		if (this.codigo != null && codigo.length() > 12) {
			return this.codigo.substring(8, 13);
		}
		return "";
	}

	public void setCodigoReduzido(String codigoReduzido) {
		this.codigoReduzido = codigoReduzido;
	}

	public String getCodigoReduzidoAlteracao() {
		return codigoReduzidoAlteracao;
	}

	public void setCodigoReduzidoAlteracao(String codigoReduzidoAlteracao) {
		this.codigoReduzidoAlteracao = codigoReduzidoAlteracao;
	}

	public String getCodigoOperacaoManut() {
		return codigoOperacaoManut;
	}

	public void setCodigoOperacaoManut(String codigoOperacaoManut) {
		this.codigoOperacaoManut = codigoOperacaoManut;
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
		OperacaoDto other = (OperacaoDto) obj;
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
		return this.descricao;
	}
}