package br.gov.pa.prodepa.nucleopa.commons.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.pa.prodepa.nucleopa.commons.enumeration.TipoInscricaoGenerica;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.TipoPessoa;
import br.gov.pa.prodepa.persistence.annotation.Equals;
import br.gov.pa.prodepa.persistence.annotation.Like;

@Entity
@Table(name = "inscricao_generica")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class InscricaoGenerica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Equals
	@Enumerated
	@Column(name = "id_tipo_pessoa")
	private TipoInscricaoGenerica tipoInscricaoGenerica;

	@Equals
	@Column(length = 100)
	private String documento;

	@Like
	@Column(length = 100)
	private String sigla;

	@Like
	@Column(length = 200)
	private String observacao;

	@Equals
	@ManyToOne
	@JoinColumn(name = "id_tipo_inscricao_siafem")
	private TipoInscricaoSiafem tipoInscricaoSiafem;

	// Auditoria

	@Equals
	@Column(nullable = false)
	private Integer versao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manut")
	private Date dataManutencao;
	
	@Column(name = "id_usuario_manut")
	private Long idUsuarioManutencao;
	
	@Column(name = "id_aplicacao_manut")
	private Long idAplicacaoManutencao;

	@Column(name ="codigo_operacao_manut", length = 20)
	private String codigoOperacao;

	public InscricaoGenerica() {
		super();
	}

	public InscricaoGenerica(TipoPessoa tipo) {
		super();
		setTipo(tipo);
	}

	public Long getKey() {
		return getId();
	}

	public void setKey(Long key) {
		setId(key);
	}

	public TipoInscricaoGenerica getTipoInscricaoGenerica() {
		return tipoInscricaoGenerica;
	}

	public void setTipoInscricaoGenerica(TipoInscricaoGenerica tipoInscricaoGenerica) {
		this.tipoInscricaoGenerica = tipoInscricaoGenerica;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoInscricaoSiafem getTipoInscricaoSiafem() {
		return tipoInscricaoSiafem;
	}

	public void setTipoInscricaoSiafem(TipoInscricaoSiafem tipoInscricaoSiafem) {
		this.tipoInscricaoSiafem = tipoInscricaoSiafem;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public Long getIdUsuarioManutencao() {
		return idUsuarioManutencao;
	}

	public void setIdUsuarioManutencao(Long idUsuarioManutencao) {
		this.idUsuarioManutencao = idUsuarioManutencao;
	}

	public Long getIdAplicacaoManutencao() {
		return idAplicacaoManutencao;
	}

	public void setIdAplicacaoManutencao(Long idAplicacaoManutencao) {
		this.idAplicacaoManutencao = idAplicacaoManutencao;
	}

	public String getCodigoOperacao() {
		return codigoOperacao;
	}

	public void setCodigoOperacao(String codigoOperacao) {
		this.codigoOperacao = codigoOperacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigoOperacao == null) ? 0 : codigoOperacao.hashCode());
		result = prime * result + ((dataManutencao == null) ? 0 : dataManutencao.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((idAplicacaoManutencao == null) ? 0 : idAplicacaoManutencao.hashCode());
		result = prime * result + ((idUsuarioManutencao == null) ? 0 : idUsuarioManutencao.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		result = prime * result + ((tipoInscricaoGenerica == null) ? 0 : tipoInscricaoGenerica.hashCode());
		result = prime * result + ((tipoInscricaoSiafem == null) ? 0 : tipoInscricaoSiafem.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		InscricaoGenerica other = (InscricaoGenerica) obj;
		if (codigoOperacao == null) {
			if (other.codigoOperacao != null)
				return false;
		} else if (!codigoOperacao.equals(other.codigoOperacao))
			return false;
		if (dataManutencao == null) {
			if (other.dataManutencao != null)
				return false;
		} else if (!dataManutencao.equals(other.dataManutencao))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (idAplicacaoManutencao == null) {
			if (other.idAplicacaoManutencao != null)
				return false;
		} else if (!idAplicacaoManutencao.equals(other.idAplicacaoManutencao))
			return false;
		if (idUsuarioManutencao == null) {
			if (other.idUsuarioManutencao != null)
				return false;
		} else if (!idUsuarioManutencao.equals(other.idUsuarioManutencao))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (tipoInscricaoGenerica != other.tipoInscricaoGenerica)
			return false;
		if (tipoInscricaoSiafem == null) {
			if (other.tipoInscricaoSiafem != null)
				return false;
		} else if (!tipoInscricaoSiafem.equals(other.tipoInscricaoSiafem))
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.getId() == null ? null : super.getId().toString();
	}
}