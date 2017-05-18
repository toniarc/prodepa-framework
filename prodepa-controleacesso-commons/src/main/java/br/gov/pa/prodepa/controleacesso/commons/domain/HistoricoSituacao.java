package br.gov.pa.prodepa.controleacesso.commons.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.pa.prodepa.domain.Audit;
import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;

/*
 * TODO falta adicionar o campo data_manut na tabela historico_situacao
 */
@Entity
@Table(name = "historico_situacao", schema = "controleacesso")
public class HistoricoSituacao extends Audit {

	private static final long serialVersionUID = -8131710043011388328L;

	private Long id;

	private Usuario usuario;

	private Date data;

	private String motivo;

	private TipoBoleano ativo;
	
	public HistoricoSituacao() {
		super();
	}

	public HistoricoSituacao(Long id, Date data, String motivo, TipoBoleano situacao) {
		super();
		this.id = id;
		this.data = data;
		this.motivo = motivo;
		this.ativo = situacao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historico_situacao_generator")
	@SequenceGenerator(name = "historico_situacao_generator", sequenceName = "controleacesso.sq_historico_situacao", allocationSize = 1)
	@Column(name = "id", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable = false)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Column(name = "motivo", nullable = false)
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "situacao", nullable = false)
	public TipoBoleano getAtivo() {
		return ativo;
	}

	public void setAtivo(TipoBoleano situacao) {
		this.ativo = situacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		HistoricoSituacao other = (HistoricoSituacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}