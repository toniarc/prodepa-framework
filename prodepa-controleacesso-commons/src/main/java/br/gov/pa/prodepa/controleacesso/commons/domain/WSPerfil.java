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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.pa.prodepa.domain.Audit;
import br.gov.pa.prodepa.domain.CanEnableOrDisable;

/**
 * WSPerfil.
 */
@Entity
@Table(name = "ws_perfil", schema = "controleacesso")
public class WSPerfil extends Audit implements Comparable<WSPerfil>, CanEnableOrDisable {

	private static final long serialVersionUID = 8657124074696739500L;

	private Long id;

	private String descricao;

	private Boolean ativo;
	
	private String codigo;

	private Aplicacao aplicacao;

	private List<WSPerfilWSOperacao> wsOperacoes;
	
	private List<WSUsuarioWSPerfil> usuarios;
	
	public WSPerfil() {
		super();
	}

	public WSPerfil(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public WSPerfil(Long id, String codigo, String descricao, Boolean ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ativo = ativo;
		this.codigo = codigo;
	}
	
	public WSPerfil(Long id, String codigo, String descricao, Long idAplicacao, String nomeAplicacao, Boolean ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ativo = ativo;
		this.codigo = codigo;
		this.aplicacao = new Aplicacao(idAplicacao, nomeAplicacao);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="wsperfil_generator")
	@SequenceGenerator(name="wsperfil_generator", sequenceName="controleacesso.sq_ws_perfil",allocationSize=1)
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
	
	@Column(name="codigo")
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_APLICACAO", nullable = false)
	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	@OneToMany(mappedBy="perfil", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	public List<WSPerfilWSOperacao> getWsOperacoes() {
		return wsOperacoes;
	}

	public void setWsOperacoes(List<WSPerfilWSOperacao> wsOperacoes) {
		this.wsOperacoes = wsOperacoes;
	}
	
	@OneToMany(mappedBy="wsPerfil", fetch=FetchType.LAZY)
	public List<WSUsuarioWSPerfil> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<WSUsuarioWSPerfil> usuarios) {
		this.usuarios = usuarios;
	}

	public int compareTo(WSPerfil o) {
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
		WSPerfil other = (WSPerfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WSPerfil [descricao=" + descricao + "]";
	}
}