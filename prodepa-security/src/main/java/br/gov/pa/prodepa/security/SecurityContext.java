package br.gov.pa.prodepa.security;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import br.gov.pa.prodepa.controleacesso.client.ControleAcessoClient;
import br.gov.pa.prodepa.controleacesso.client.dto.AtualizarAcessoEnvDto;
import br.gov.pa.prodepa.controleacesso.client.dto.AutorizarEnvDto;
import br.gov.pa.prodepa.controleacesso.client.dto.PassaporteEnvDto;
import br.gov.pa.prodepa.controleacesso.client.dto.UsuarioComplementoDtoWS;
import br.gov.pa.prodepa.controleacesso.client.dto.UsuarioDto;
import br.gov.pa.prodepa.exceptions.ApplicationException;
import br.gov.pa.prodepa.exceptions.BusinessException;
import br.gov.pa.prodepa.exceptions.SecurityException;
import br.gov.pa.prodepa.security.model.AbstractOperacoesControleAcesso;
import br.gov.pa.prodepa.security.model.AbstractPageSecurity;
import br.gov.pa.prodepa.security.model.AuthenticatedUser;
import br.gov.pa.prodepa.security.model.Page;
import br.gov.pa.prodepa.util.PropertiesUtil;

public class SecurityContext implements Serializable {
	
	private static final long serialVersionUID = -2594587325579469917L;

	public static final String KSESSION_ID = "KSESSIONID"; 
	
	@Inject
	private ControleAcessoClient controleAcessoClient;
	
	@Inject
	private HttpServletRequest request;
	
	private PropertiesUtil properties = new PropertiesUtil();
	
	private UsuarioDto usuarioDto;
	
	private UsuarioComplementoDtoWS usuarioComplemento;
	
	@Inject Instance<AbstractPageSecurity> pageSecurity;
	
	@Inject Instance<AbstractOperacoesControleAcesso> operacoesCA;
	
	private boolean isLoggedIn;
	
	public SecurityContext() {
		System.out.println("Inicou o contexto de segurança."); 
	}
	
	public void login() throws ApplicationException, BusinessException {
		
		AutorizarEnvDto autorizarEnvDto = new AutorizarEnvDto(getApplicationId(), getSessionCookie());
		usuarioDto = controleAcessoClient.autorizar(autorizarEnvDto);
		usuarioComplemento = controleAcessoClient.buscarDadosComplementaresUsuario(new UsuarioComplementoDtoWS(usuarioDto.getId()));
		
		this.isLoggedIn = true;
	}

	public void updateSession() throws SecurityException, ApplicationException {
		try {
			AtualizarAcessoEnvDto dto = new AtualizarAcessoEnvDto(getApplicationId(), null, getSessionCookie());
			Boolean isLoggedIn = controleAcessoClient.atualizarAcesso(dto);
			
			if(!isLoggedIn){
				throw new SecurityException("Usuário não autenticado.");
			}
			
		} catch (SecurityException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}

	public Map<String, Object> exportSecurityContext() throws Exception {
		Map<String, Object> securityContextExported = new HashMap<String, Object>();
		securityContextExported.put("authenticatedUser", getAuthenticatedUser());
		securityContextExported.put("allRoles", operacoesCA.get().exportRoles());
		securityContextExported.put("userRoles", usuarioDto.getOperacoes());
	
		return securityContextExported;
	}
	
	public boolean checkPageAcess(String page){
		Page sp = getSecurityPage(page);
		
		if(sp != null){
			return hasOperation(sp.getOperations());
		}
		
		//se não for encontrada a page requisitada então subentende-se que a mesma não precisa de checagem de acesso.
		return true;
	}
	
	private Page getSecurityPage(String page) {
		for(Page sp : pageSecurity.get().getPages()){
			if(sp.getPage().startsWith(page)){
				return sp;
			}
		}
		return null;
	}
	
	public void logout() throws SecurityException, BusinessException, ApplicationException{
		controleAcessoClient.encerrarSessao(new PassaporteEnvDto(getSessionCookie()));
		usuarioDto = null;
		usuarioComplemento = null;
		this.isLoggedIn = false;
	}
	
	private Long getApplicationId() {
		return Long.parseLong(properties.getProperty("application.id"));
	}

	private String getSessionCookie() throws SecurityException {
		
		String sessionCookie = null;
		
		for(Cookie c : request.getCookies()){
			if(c.getName().equals(KSESSION_ID)){
				sessionCookie = c.getValue();
			}
		}
		
		if(sessionCookie == null || sessionCookie.trim().length() == 0){
			throw new SecurityException("Usuário não autenticado.");
		}
		
		return sessionCookie;
	}
	
	public Boolean isLoggedIn(){
		return this.isLoggedIn;
	}

	public AuthenticatedUser getAuthenticatedUser() {
		return new AuthenticatedUser(usuarioDto, usuarioComplemento);
	}

	public boolean hasOperation(String[] operations){
		for(String op : operations){
			if(hasOperation(op)){
				return true;
			}
		}
		return false;
	}
	
	public boolean hasOperation(String operation) {
		for(String op : usuarioDto.getOperacoes()){
			if(op.equals(operation)){
				return true;
			}
		}
		return false;
	}

}
