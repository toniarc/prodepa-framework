package br.gov.pa.prodepa.nucleopa.commons.dto.ws;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.gov.pa.prodepa.domain.enumeration.TipoBoleano;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.Sexo;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.TipoInscricaoGenerica;
import br.gov.pa.prodepa.nucleopa.commons.enumeration.TipoPessoa;

public class PessoaDtoWs implements Serializable {

	private static final long serialVersionUID = -5618295980905104386L;

	private String nome;
	private String sigla;
	private String commonDocument;

	/*
	 * Pessoa
	 */
	private Long id;
	private TipoPessoa tipoPessoa;
	private TipoBoleano isOrgao;
	private TipoBoleano isFornecedor;
	private EnderecoDtoWs enderecoDto;
	private List<EmailDtoWs> emails;
	private List<TelefoneDtoWs> telefones;
	private EmailDtoWs emailPrincipal;
	private Integer versao;
	
	private Date dataManutPessoa;
	private Long idUsuarioManutPessoa;
	private Long idAplicacaoManutPessoa;
	
	
	/*
	 * Pessoa Fisica
	 */
	private String cpf;
	private Sexo sexo;
	private Date dataManutPessoaFisica;
	private Long idUsuarioManutPessoaFisica;
	private Long idAplicacaoManutPessoaFisica;
	private Integer versaoPessoaFisica;

	/*
	 * Pessoa Juridica
	 */
	private String cnpj;
	private String nomeFantasia;
	private NaturezaJuridicaDtoWs tipoPessoaJuridica;
	private Date dataManut;
	private Long idUsuarioManut;
	private Long idAplicacaoManut;
	private List<AreaTematicaDtoWs> areasTematicas;
	private Integer versaoPessoaJuridica;
	
	/*
	 * Pessoa generica
	 */
	private String documento;
	private String observacao;
	private TipoInscricaoGenerica tipoPessoaGenerico;
	private Date dataManutPessoaGenerico;
	private Long idUsuarioManutPessoaGenerico;
	private Long idAplicacaoManutPessoaGenerico;
	private TipoInscricaoSiafemDtoWs tipoInscricaoSiafemDtoWs;
	private Integer versaoInscricaoGenerica;

	public PessoaDtoWs() {
		super();
	}

	public PessoaDtoWs(Long id, TipoPessoa tipoPessoa, String nome) {
		super();
		this.id = id;
		this.tipoPessoa = tipoPessoa;
		this.nome = nome;
	}

	public PessoaDtoWs(Long id) {
		super();
		this.id = id;
	}

	public PessoaDtoWs(TipoPessoa tipoPessoa) {
		super();
		this.tipoPessoa = tipoPessoa;
	}

	public PessoaDtoWs(String doc, TipoPessoa tipoPessoa) {
		super();

		if (tipoPessoa.equals(TipoPessoa.JURIDICA)){
			this.cnpj = doc;
		} else {
			this.cpf = doc;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<EmailDtoWs> getEmails() {
		return emails;
	}

	public EmailDtoWs getEmailPrincipal() {
		if(emails == null){
			return null;
		}
		
		for (EmailDtoWs email : emails) {
			if (email.getPrincipal().equals(TipoBoleano.VERDADEIRO)) {
				emailPrincipal = email;
				break;
			}
		}
		return emailPrincipal;
	}

	public void setEmails(List<EmailDtoWs> emails) {
		this.emails = emails;
	}

	public List<TelefoneDtoWs> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneDtoWs> telefones) {
		this.telefones = telefones;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public NaturezaJuridicaDtoWs getTipoPessoaJuridica() {
		return tipoPessoaJuridica;
	}

	public void setTipoPessoaJuridica(NaturezaJuridicaDtoWs tipoPessoaJuridica) {
		this.tipoPessoaJuridica = tipoPessoaJuridica;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public TipoInscricaoGenerica getTipoPessoaGenerico() {
		return tipoPessoaGenerico;
	}

	public void setTipoPessoaGenerico(TipoInscricaoGenerica tipoPessoaGenerico) {
		this.tipoPessoaGenerico = tipoPessoaGenerico;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCommonDocument() {
		return commonDocument;
	}

	public void setCommonDocument(String commonDocument) {
		this.commonDocument = commonDocument;
	}

	public TipoBoleano getIsOrgao() {
		return isOrgao;
	}

	public void setIsOrgao(TipoBoleano isOrgao) {
		this.isOrgao = isOrgao;
	}

	public TipoBoleano getIsFornecedor() {
		return isFornecedor;
	}

	public void setIsFornecedor(TipoBoleano isFornecedor) {
		this.isFornecedor = isFornecedor;
	}

	public Date getDataManutPessoa() {
		return dataManutPessoa;
	}

	public void setDataManutPessoa(Date dataManutPessoa) {
		this.dataManutPessoa = dataManutPessoa;
	}

	public Long getIdUsuarioManutPessoa() {
		return idUsuarioManutPessoa;
	}

	public void setIdUsuarioManutPessoa(Long idUsuarioManutPessoa) {
		this.idUsuarioManutPessoa = idUsuarioManutPessoa;
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

	public Long getIdAplicacaoManutPessoa() {
		return idAplicacaoManutPessoa;
	}

	public void setIdAplicacaoManutPessoa(Long idAplicacaoManutPessoa) {
		this.idAplicacaoManutPessoa = idAplicacaoManutPessoa;
	}

	public Long getIdAplicacaoManut() {
		return idAplicacaoManut;
	}

	public void setIdAplicacaoManut(Long idAplicacaoManut) {
		this.idAplicacaoManut = idAplicacaoManut;
	}

	public Long getIdUsuarioManutPessoaFisica() {
		return idUsuarioManutPessoaFisica;
	}

	public void setIdUsuarioManutPessoaFisica(Long idUsuarioManutPessoaFisica) {
		this.idUsuarioManutPessoaFisica = idUsuarioManutPessoaFisica;
	}

	public Long getIdAplicacaoManutPessoaFisica() {
		return idAplicacaoManutPessoaFisica;
	}

	public void setIdAplicacaoManutPessoaFisica(Long idAplicacaoManutPessoaFisica) {
		this.idAplicacaoManutPessoaFisica = idAplicacaoManutPessoaFisica;
	}

	public Long getIdUsuarioManutPessoaGenerico() {
		return idUsuarioManutPessoaGenerico;
	}

	public void setIdUsuarioManutPessoaGenerico(Long idUsuarioManutPessoaGenerico) {
		this.idUsuarioManutPessoaGenerico = idUsuarioManutPessoaGenerico;
	}

	public Long getIdAplicacaoManutPessoaGenerico() {
		return idAplicacaoManutPessoaGenerico;
	}

	public void setIdAplicacaoManutPessoaGenerico(
			Long idAplicacaoManutPessoaGenerico) {
		this.idAplicacaoManutPessoaGenerico = idAplicacaoManutPessoaGenerico;
	}

	public Date getDataManutPessoaFisica() {
		return dataManutPessoaFisica;
	}

	public void setDataManutPessoaFisica(Date dataManutPessoaFisica) {
		this.dataManutPessoaFisica = dataManutPessoaFisica;
	}

	public Date getDataManutPessoaGenerico() {
		return dataManutPessoaGenerico;
	}

	public void setDataManutPessoaGenerico(Date dataManutPessoaGenerico) {
		this.dataManutPessoaGenerico = dataManutPessoaGenerico;
	}

	public EnderecoDtoWs getEnderecoDto() {
		return enderecoDto;
	}

	public void setEnderecoDto(EnderecoDtoWs enderecoDto) {
		this.enderecoDto = enderecoDto;
	}

	public List<AreaTematicaDtoWs> getAreasTematicas() {
		return areasTematicas;
	}

	public void setAreasTematicas(List<AreaTematicaDtoWs> areasTematicas) {
		this.areasTematicas = areasTematicas;
	}

	public TipoInscricaoSiafemDtoWs getTipoInscricaoSiafemDtoWs() {
		return tipoInscricaoSiafemDtoWs;
	}

	public void setTipoInscricaoSiafemDtoWs(
			TipoInscricaoSiafemDtoWs tipoInscricaoSiafemDtoWs) {
		this.tipoInscricaoSiafemDtoWs = tipoInscricaoSiafemDtoWs;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	public Integer getVersaoPessoaFisica() {
		return versaoPessoaFisica;
	}

	public void setVersaoPessoaFisica(Integer versaoPessoaFisica) {
		this.versaoPessoaFisica = versaoPessoaFisica;
	}

	public Integer getVersaoPessoaJuridica() {
		return versaoPessoaJuridica;
	}

	public void setVersaoPessoaJuridica(Integer versaoPessoaJuridica) {
		this.versaoPessoaJuridica = versaoPessoaJuridica;
	}

	public Integer getVersaoInscricaoGenerica() {
		return versaoInscricaoGenerica;
	}

	public void setVersaoInscricaoGenerica(Integer versaoInscricaoGenerica) {
		this.versaoInscricaoGenerica = versaoInscricaoGenerica;
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
		PessoaDtoWs other = (PessoaDtoWs) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
