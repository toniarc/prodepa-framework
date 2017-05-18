package br.gov.pa.prodepa.controleacesso.commons.constants;

public class ControleAcesso {

	public static final boolean DEBUG = false;

	public static final String DEFAULT_PERSISTENCE_UNIT = "java:jboss/datasources/controleacessoDS";

	public static final String CHECK_XHTML = "/check.xhtml";
	public static final String CHECK_SEAM = "/index.html";
	public static final String CHECK_JSF = "/check.xhtml";

	// Client

	public static final String CLIENT_ERROR_XHTML = "/error.xhtml";

	public static final String CLIENT_REDIRECT_PARAMETER = "redirect";
	public static final String CLIENT_APPLICATION_ID_PARAMETER = "sso.APPLICATION_ID";
	public static final String CLIENT_MAIN_XHTML_PARAMETER = "sso.MAIN_XHTML";

	// Server

	public static final String SERVER_CONTEXT = "/governodigital";
	public static final String SERVER_CHECK_SEAM = SERVER_CONTEXT
			+ "/check.seam";
	public static final Long SERVER_APPLICATION_ID = 7L;

	// Cookie

	public static final String COOKIE_PATH = "/";
	public static final String SESSION_COOKIE = "KSESSIONID";

	public final static Long ID_PERFIL_GERENTE_SISTEMA = 5L;
	public final static Long ID_PERFIL_GERENTE_SISTEMA_ORGAO = 6L;

	public final static String CODIGO_PERFIL_GERENTE_SISTEMA = "1.107";
	public final static String CODIGO_PERFIL_GERENTE_SISTEMA_ORGAO = "1.108";

	public static final String CLIENT_LOGIN_WS_PARAMETER = "sso.LOGIN_WS";
	public static final String CLIENT_PASSWORD_WS_PARAMETER = "sso.PASSWORD_WS";

	public static final Long CLIENT_APPLICATION_ID_VALUE = 92L;
	public static final String CLIENT_MAIN_XHTML_VALUE = "/private/index.xhtml";
}
