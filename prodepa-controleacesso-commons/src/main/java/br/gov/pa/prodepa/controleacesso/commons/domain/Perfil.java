package br.gov.pa.prodepa.controleacesso.commons.domain;

import java.util.List;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.gov.pa.prodepa.controleacesso.commons.dto.PerfilDto;
import br.gov.pa.prodepa.domain.Audit;
import br.gov.pa.prodepa.domain.CanEnableOrDisable;

/**
 * Perfil.
 */
@Entity
@Table(name = "PERFIL", schema = "controleacesso")
public class Perfil extends Audit implements CanEnableOrDisable, Comparable<Perfil> {

	private static final long serialVersionUID = 8657124074696739500L;

	private Long id;

	private String descricao;

	private Boolean ativo;

	private Boolean delegavelPeloGerenteDoOrgao;

	private Boolean delegavelPeloGerenteDoSistema;

	private String codigo;

	private Aplicacao aplicacao;

	private List<PerfilOperacao> operacoes;

	private PerfilDto dto = new PerfilDto();
	
	public Perfil() {
		super();
	}

	public Perfil(Long id, String codigo, String descricao, Long idAplicacao, String nomeAplicacao, Boolean ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ativo = ativo;
		this.codigo = codigo;
		this.aplicacao = new Aplicacao(idAplicacao, nomeAplicacao);
	}

	public Perfil(Long idPerfil, String descricao) {
		this.id = idPerfil;
		this.descricao = descricao;
	}
	
	public Perfil(Long idPerfil, String codigoPerfil, String descricao) {
		this.id = idPerfil;
		this.codigo = codigoPerfil;
		this.descricao = descricao;
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

	@Column(name = "DESCRICAO", nullable = false, length = 200)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ATIVO", nullable = false)
	public Boolean getEnable() {
		return ativo;
	}

	public void setEnable(Boolean ativo) {
		this.ativo = ativo;
	}

	@ManyToOne
	@JoinColumn(name = "ID_APLICACAO", nullable = false)
	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	@Column(name = "CODIGO")
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@OneToMany(mappedBy="perfil", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	public List<PerfilOperacao> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<PerfilOperacao> operacoes) {
		this.operacoes = operacoes;
	}

	@Column(name = "GERENTE_ORGAO_DELEGA", nullable = false)
	public Boolean getDelegavelPeloGerenteDoOrgao() {
		return delegavelPeloGerenteDoOrgao;
	}

	public void setDelegavelPeloGerenteDoOrgao(Boolean delegavelPeloGerenteDoOrgao) {
		this.delegavelPeloGerenteDoOrgao = delegavelPeloGerenteDoOrgao;
	}

	@Column(name = "GERENTE_DELEGA", nullable = false)
	public Boolean getDelegavelPeloGerenteDoSistema() {
		return delegavelPeloGerenteDoSistema;
	}

	public void setDelegavelPeloGerenteDoSistema(Boolean delegavelPeloGerenteDoSistema) {
		this.delegavelPeloGerenteDoSistema = delegavelPeloGerenteDoSistema;
	}

	@Transient
	public PerfilDto getDto() {
		return dto;
	}

	public void setDto(PerfilDto dto) {
		this.dto = dto;
	}

	public int compareTo(Perfil o) {
		return this.descricao.compareTo(o.getDescricao());
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
		Perfil other = (Perfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}
}