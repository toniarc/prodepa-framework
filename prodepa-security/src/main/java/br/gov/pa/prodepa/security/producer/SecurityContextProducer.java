package br.gov.pa.prodepa.security.producer;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

import br.gov.pa.prodepa.security.SecurityContext;

@SessionScoped
public class SecurityContextProducer implements Serializable {

	private static final long serialVersionUID = 4810469052069746963L;

	@Produces
	@SessionScoped
	public SecurityContext createContext(@New SecurityContext sc){
		return sc;
	}
}
