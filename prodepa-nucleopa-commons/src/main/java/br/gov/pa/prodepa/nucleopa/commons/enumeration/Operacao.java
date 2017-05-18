package br.gov.pa.prodepa.nucleopa.commons.enumeration;

public enum Operacao {

	  //////////////////
	 // 2 - NucleoPA //
	////////////////////////////////////////

	// 828 - Pais
	PAIS_SEARCH("2.828.2795", "Pesquisa de Países"),
	PAIS_INSERT("2.828.2796", "Cadastro de País"),
	PAIS_UPDATE("2.828.2797", "Alteração de País"),
	PAIS_VIEW  ("2.828.2798", "Visualização de País"),
	PAIS_STATUS("2.828.2799", "Ativação/Desativação de País"),

	// 829 - Regiao
	REGIAO_SEARCH("2.829.2800", "Pesquisa de Regiões"),
	REGIAO_INSERT("2.829.2801", "Cadastro de Região"),
	REGIAO_UPDATE("2.829.2802", "Alteração de Região"),
	REGIAO_VIEW  ("2.829.2803", "Visualização de Região"),

	// 731 - Estado
	ESTADO_SEARCH("2.731.2259", "Pesquisa de Estados"),
	ESTADO_INSERT("2.731.2247", "Cadastro de Estado"),
	ESTADO_UPDATE("2.731.2248", "Alteração de Estado"),
	ESTADO_VIEW  ("2.731.2246", "Visualização de Estado"),
	ESTADO_STATUS("2.731.2789", "Ativação/Desativação de Estado"),

	// 830 - Mesorregiao
	MESORREGIAO_SEARCH("2.830.2804", "Pesquisa de Mesorregiões"),
	MESORREGIAO_INSERT("2.830.2805", "Cadastro de Mesorregião"),
	MESORREGIAO_UPDATE("2.830.2806", "Alteração de Mesorregião"),
	MESORREGIAO_VIEW  ("2.830.2807", "Visualização de Mesorregião"),

	// 831 - Microrregiao
	MICRORREGIAO_SEARCH("2.831.2808", "Pesquisa de Microrregiões"),
	MICRORREGIAO_INSERT("2.831.2809", "Cadastro de Microrregião"),
	MICRORREGIAO_UPDATE("2.831.2810", "Alteração de Microrregião"),
	MICRORREGIAO_VIEW  ("2.831.2811", "Visualização de Microrregião"),

	// 832 - Regional
	REGIONAL_SEARCH("2.832.2822", "Pesquisa de Regionais"),
	REGIONAL_INSERT("2.832.2823", "Cadastro de Regional"),
	REGIONAL_UPDATE("2.832.2824", "Alteração de Regional"),
	REGIONAL_VIEW  ("2.832.2825", "Visualização de Regional"),

	// 732 - Municipio
	MUNICIPIO_SEARCH("2.732.2257", "Pesquisa de Municípios"),
	MUNICIPIO_INSERT("2.732.2249", "Cadastro de Município"),
	MUNICIPIO_UPDATE("2.732.2251", "Alteração de Município"),
	MUNICIPIO_VIEW  ("2.732.2250", "Visualização de Município"),
	MUNICIPIO_STATUS("2.732.2788", "Ativação/Desativação de Município"),

	// 833 - Localidade
	LOCALIDADE_SEARCH("2.833.2812", "Pesquisa de Localidades"),
	LOCALIDADE_INSERT("2.833.2813", "Cadastro de Localidade"),
	LOCALIDADE_UPDATE("2.833.2814", "Alteração de Localidade"),
	LOCALIDADE_VIEW  ("2.833.2815", "Visualização de Localidade"),
	LOCALIDADE_STATUS("2.833.2816", "Ativação/Desativação de Localidade"),

	// 834 - Bairro
	BAIRRO_SEARCH("2.834.2817", "Pesquisa de Bairros"),
	BAIRRO_INSERT("2.834.2818", "Cadastro de Bairro"),
	BAIRRO_UPDATE("2.834.2819", "Alteração de Bairro"),
	BAIRRO_VIEW  ("2.834.2820", "Visualização de Bairro"),
	BAIRRO_STATUS("2.834.2821", "Ativação/Desativação de Bairro"),

	////////////////////////////////////////

	// 733 - Pessoa Fisica
	PESSOA_FISICA_SEARCH ("2.733.2256", "Pesquisa de Pessoas Físicas"),
	PESSOA_FISICA_INSERT ("2.733.2244", "Cadastro de Pessoa Física"),
	PESSOA_FISICA_UPDATE ("2.733.2243", "Correção de Pessoa Física"),
	PESSOA_FISICA_VIEW   ("2.733.2242", "Visualização de Pessoa Física"),
	PESSOA_FISICA_VERSION("2.733.2245", "Alteração de Pessoa Física"),

	// 728 - Pessoa Juridica (Organizacao)
	PESSOA_JURIDICA_SEARCH ("2.728.2229", "Pesquisa de Organizações"),
	PESSOA_JURIDICA_INSERT ("2.728.2230", "Cadastro de Organização"),
	PESSOA_JURIDICA_UPDATE ("2.728.2231", "Correção de Organização"),
	PESSOA_JURIDICA_VIEW   ("2.728.2237", "Visualização de Organização"),
	PESSOA_JURIDICA_STATUS ("2.728.2232", "Ativação/Desativação de Organização"),
	PESSOA_JURIDICA_VERSION("2.728.2826", "Alteração de Organização"),

	// 827 - Inscricao Generica
	INSCRICAO_GENERICA_SEARCH ("2.827.2791", "Pesquisa de Inscrições Genéricas"),
	INSCRICAO_GENERICA_INSERT ("2.827.2792", "Cadastro de Inscrição Genérica"),
	INSCRICAO_GENERICA_UPDATE ("2.827.2793", "Correção de Inscrição Genérica"),
	INSCRICAO_GENERICA_VIEW   ("2.827.2794", "Visualização de Inscrição Genérica"),
	INSCRICAO_GENERICA_VERSION("2.827.2827", "Alteração de Inscrição Genérica"),

	////////////////////////////////////////

	// 730 - Area Tematica
	AREA_TEMATICA_SEARCH("2.730.2233", "Pesquisa de Áreas Temáticas"),
	AREA_TEMATICA_INSERT("2.730.2234", "Cadastro de Área Temática"),
	AREA_TEMATICA_UPDATE("2.730.2238", "Alteração de Área Temática"),
	AREA_TEMATICA_VIEW  ("2.730.2235", "Visualização de Área Temática"),
	AREA_TEMATICA_STATUS("2.730.2236", "Ativação/Desativação de Área Temática"),

	// 734 - Categoria
	CATEGORIA_SEARCH("2.734.2258", "Pesquisa de Categorias"),
	CATEGORIA_INSERT("2.734.2241", "Cadastro de Categoria"),
	CATEGORIA_UPDATE("2.734.2240", "Alteração de Categoria"),
	CATEGORIA_VIEW  ("2.734.2239", "Visualização de Categoria"),
	CATEGORIA_STATUS("2.734.2790", "Ativação/Desativação de Categoria"),

	// 729 - Natureza Juridica
	NATUREZA_JURIDICA_SEARCH("2.729.2225", "Pesquisa de Naturezas Jurídicas"),
	NATUREZA_JURIDICA_INSERT("2.729.2226", "Cadastro de Natureza Jurídica"),
	NATUREZA_JURIDICA_UPDATE("2.729.2224", "Alteração de Natureza Jurídica"),
	NATUREZA_JURIDICA_VIEW  ("2.729.2223", "Visualização de Natureza Jurídica"),
	NATUREZA_JURIDICA_STATUS("2.729.2227", "Ativação/Desativação de Natureza Jurídica"),

	// 836 - Tipo de Inscricao do SIAFEM
	TIPO_INSCRICAO_SIAFEM_SEARCH("2.836.2837", "Pesquisa de Tipos de Inscrições do SIAFEM"),
	TIPO_INSCRICAO_SIAFEM_INSERT("2.836.2838", "Cadastro de Tipo de Inscrição do SIAFEM"),
	TIPO_INSCRICAO_SIAFEM_UPDATE("2.836.2839", "Alteração de Tipo de Inscrição do SIAFEM"),
	TIPO_INSCRICAO_SIAFEM_VIEW  ("2.836.2840", "Visualização de Tipo de Inscrição do SIAFEM"),
	TIPO_INSCRICAO_SIAFEM_STATUS("2.836.2841", "Ativação/Desativação de Tipo de Inscrição do SIAFEM"),

	////////////////////////////////////////

	// 735 - Relatorio
	REPORT_ORGAO("2.735.2228", "Relatório de Órgãos");

	private String codigo;
	private String descricao;

	private Operacao(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}