package br.gov.pa.prodepa.util;

import org.apache.commons.lang.StringUtils;

/**
 * Classe responsável por ler as propriedades do sistema (System Properties)
 * que estão configuradas no JBoss EAP. 
 * @author Antônio Junior
 */
public class ProdepaGlobalSystemProperties {

	/**
	 * <p>
	 * Retorna o valor da propriedade de sistema 'prodepa.global.environment'.
	 * Esta propriedade aceita os seguintes valores: <i><b>desenvolvimento</b></i>, <i><b>homologacao</b></i>, <i><b>treinamento</b></i> e <i><b>producao</b></i> 
	 * </p>
	 * 
	 * @return String
	 */
	public static String getEnvironment(){
		String environment = System.getProperty("prodepa.global.environment");
		
		if(StringUtils.isEmpty(environment)){
			throwException("prodepa.global.environment");
		} else {
			if(!environment.equals("desenvolvimento") &&
			   !environment.equals("homologacao") &&
			   !environment.equals("treinamento") &&
			   !environment.equals("producao")){
				
				String msg = "O valor da propriedade 'prodepa.global.environment'";
				msg.concat(" é inválido, os valores possíveis");
				msg.concat(" são: desenvolvimento, homologacao, treinamento e producao");
				
				throw new RuntimeException(msg);
			}
		}
		
		return environment;
	}
	
	/**
	 * <p>
	 * Retorna o valor da propriedade de sistema 'prodepa.global.domain.host'.
	 * </p>
	 * 
	 * @return String
	 */
	public static String getDomainHost(){
		String domain = System.getProperty("prodepa.global.domain.host");
		
		if(StringUtils.isEmpty(domain)){
			throwException("prodepa.global.domain.host");
		}
		
		return domain;
	}
	
	/**
	 * <p>
	 * Retorna o valor da propriedade de sistema 'prodepa.global.domain.protocol'.
	 * <br/>Esta propriedade aceita os seguintes valores: <i><b>http</b></i> e <i><b>https</b></i>.
	 * </p>
	 * 
	 * @return String
	 */
	public static String getDomainProtocol(){
		String protocol = System.getProperty("prodepa.global.domain.protocol");
		
		if(StringUtils.isEmpty(protocol)){
			throwException("prodepa.global.domain.protocol");
		} else {
			validateProtocol(protocol);
		}
		
		return protocol;
	}
	
	/**
	 * <p>
	 * Este método contatena o protocolo e o host do ambiente em questão. <br/>
	 * Ex: https://www2.desenvolver.prodepa.gov.br
	 * </p>
	 * 
	 * @return String
	 */
	public static String getDomainFullUrl(){
		return getDomainProtocol().concat("://").concat(getDomainHost());
	}

	/**
	 * <p>
	 * Retorna o valor da propriedade de sistema 'prodepa.governodigital.image.mapping'.
	 * </p>
	 * 
	 * @return String
	 */
	public static String getImageMapping(){
		String imageMapping = System.getProperty("prodepa.governodigital.image.mapping");
		
		if(StringUtils.isEmpty(imageMapping)){
			throwException("prodepa.governodigital.image.mapping");
		}
		
		return imageMapping;
	}
	
	/**
	 * <p>
	 * Retorna o valor da propriedade de sistema 'prodepa.global.controleacesso.ws.host'.
	 * </p>
	 * 
	 * @return String
	 */
	public static String getControleacessoWSHost(){
		String controleAcessoWsHost = System.getProperty("prodepa.global.controleacesso.ws.host");
		
		if(StringUtils.isEmpty(controleAcessoWsHost)){
			throwException("prodepa.global.controleacesso.ws.host");
		}
		
		return controleAcessoWsHost;
	}
	
	/**
	 * <p>
	 * Retorna o valor da propriedade de sistema 'prodepa.global.controleacesso.ws.protocol'.
	 * <br/>Esta propriedade aceita os seguintes valores: <i><b>http</b></i> e <i><b>https</b></i>.
	 * </p>
	 * 
	 * @return String
	 */
	public static String getControleacessoWSProtocol(){
		String controleAcessoWsProtocol = System.getProperty("prodepa.global.controleacesso.ws.protocol");
		
		if(StringUtils.isEmpty(controleAcessoWsProtocol)){
			throwException("prodepa.global.controleacesso.ws.protocol");
		} else {
			validateProtocol(controleAcessoWsProtocol);
		}
		
		return controleAcessoWsProtocol;
	}
	
	/**
	 * <p>
	 * Este método contatena o protocolo e o host do webservice do controle de acesso. <br/>
	 * Ex: https://www2.desenvolver.prodepa.gov.br
	 * </p>
	 * 
	 * @return String
	 */
	public static String getControleAcessoWsFullUrl(){
		return getControleacessoWSProtocol().concat("://").concat(getControleacessoWSHost());
	}
	
	/**
	 * <p>
	 * Retorna o valor da propriedade de sistema 'prodepa.global.nucleopa.ws.host'.
	 * </p>
	 * 
	 * @return String
	 */
	public static String getNuclePaWsHost(){
		String nucleoPaWsHost = System.getProperty("prodepa.global.nucleopa.ws.host");
		
		if(StringUtils.isEmpty(nucleoPaWsHost)){
			throwException("prodepa.global.nucleopa.ws.host");
		}
		
		return nucleoPaWsHost;
	}
	
	/**
	 * <p>
	 * Retorna o valor da propriedade de sistema 'prodepa.global.nucleopa.ws.protocol'.
	 * <br/>Esta propriedade aceita os seguintes valores: <i><b>http</b></i> e <i><b>https</b></i>.
	 * </p>
	 * 
	 * @return String
	 */
	public static String getNuclePaWsProtocol(){
		String nucleoPaWsProtocol = System.getProperty("prodepa.global.nucleopa.ws.protocol");
		
		if(StringUtils.isEmpty(nucleoPaWsProtocol)){
			throwException("prodepa.global.nucleopa.ws.protocol");
		} else {
			validateProtocol(nucleoPaWsProtocol);
		}
		
		return nucleoPaWsProtocol;
	}
	
	/**
	 * <p>
	 * Este método contatena o protocolo e o host do webservice do Núcleo PA. <br/>
	 * Ex: https://www2.desenvolver.prodepa.gov.br
	 * </p>
	 * 
	 * @return String
	 */
	public static String getNucleoPaWsFullUrl(){
		return getNuclePaWsProtocol().concat("://").concat(getNuclePaWsHost());
	}
	
	private static void throwException(String propertie){
		throw new RuntimeException("A propriedade de sistema '".concat(propertie).concat("' não foi encontrada"));
	}
	
	private static void validateProtocol(String protocol) {
		if(!protocol.equals("http") && !protocol.equals("https")){
			throw new RuntimeException("O valor da propriedade 'prodepa.global.domain.protocol' é inválido, os valores possíveis são: http e https.");
		}
	}
}
