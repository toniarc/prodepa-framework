package br.gov.pa.prodepa.security.producer;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

import br.gov.pa.prodepa.controleacesso.client.ControleAcessoClient;
import br.gov.pa.prodepa.util.PropertiesUtil;

@SessionScoped
public class ControleAcessoClientProducer implements Serializable{

	private static final long serialVersionUID = 5052290182755043363L;

	PropertiesUtil properties = new PropertiesUtil();
	
	@Produces
	@SessionScoped
	public ControleAcessoClient createClient(){
		String login = properties.getProperty("application.controleacesso.ws.user");
		String password = properties.getProperty("application.controleacesso.ws.password");
		
		return new ControleAcessoClient(login, password);
	}
}
