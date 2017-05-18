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
import javax.persistence.Transient;

import br.gov.pa.prodepa.controleacesso.commons.dto.WSUsuarioDto;
import br.gov.pa.prodepa.domain.Audit;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;
import br.gov.pa.prodepa.nucleopa.commons.domain.Orgao;

/**
 * Entity WSUsuario
 */
@Entity
@Table(name = "ws_usuario", schema = "controleacesso")
public class WSUsuario extends Audit {

	private static final long serialVersionUID = 813234259433372458L;

	private Long id;

	private String login;

	private String descricao;

	private String senha;

	private TipoBoleano ativo;

	private Orgao orgao;

	private List<WSUsuarioWSPerfil> wsPerfis;
	
	private WSUsuarioDto dto = new WSUsuarioDto();

	public WSUsuario() {
		super();
	}

	public WSUsuario(String login) {
		super();
		this.login = login;
	}

	public WSUsuario(Long id, String descricao, String login, TipoBoleano ativo, Long idOrgao, String siglaOrgao) {
		super();
		this.id = id;
		this.login = login;
		this.descricao = descricao;
		this.ativo = ativo;
		this.orgao = new Orgao(idOrgao, siglaOrgao);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wsusuario_generator")
	@SequenceGenerator(name = "wsusuario_generator", sequenceName = "controleacesso.sq_ws_usuario", allocationSize = 1)
	@Column(name = "id", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "login", nullable = false)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "descricao", nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "senha", nullable = false)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ativo", nullable = false)
	public TipoBoleano getAtivo() {
		return ativo;
	}

	public void setAtivo(TipoBoleano ativo) {
		this.ativo = ativo;
	}

	@ManyToOne
	@JoinColumn(name = "id_orgao", nullable = false)
	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	@OneToMany(mappedBy="wsUsuario", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<WSUsuarioWSPerfil> getWsPerfis() {
		return wsPerfis;
	}

	public void setWsPerfis(List<WSUsuarioWSPerfil> wsPerfis) {
		this.wsPerfis = wsPerfis;
	}

	@Transient
	public WSUsuarioDto getDto() {
		return dto;
	}

	public void setDto(WSUsuarioDto dto) {
		this.dto = dto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		WSUsuario other = (WSUsuario) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
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