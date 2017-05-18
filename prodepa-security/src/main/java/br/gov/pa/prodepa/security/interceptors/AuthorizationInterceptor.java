package br.gov.pa.prodepa.security.interceptors;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.gov.pa.prodepa.exceptions.ApplicationException;
import br.gov.pa.prodepa.exceptions.SecurityException;
import br.gov.pa.prodepa.security.SecurityContext;
import br.gov.pa.prodepa.security.anotations.Authorization;
import br.gov.pa.prodepa.security.anotations.AuthorizationsRestCrud;

@Interceptor
@AuthorizationsRestCrud
public class AuthorizationInterceptor {

	@Inject
	private SecurityContext securityContext;
	
    @AroundInvoke
    public Object aroundInvoke(InvocationContext ic) throws SecurityException, ApplicationException, Exception {
        
    	if(!securityContext.isLoggedIn()){
    		throw new SecurityException("Usuário não autenticado.");
    	}
    	
    	Authorization authorization = ic.getMethod().getAnnotation(Authorization.class);
    	
    	if(authorization != null){
    		boolean hasPermission = true;
    		hasPermission = securityContext.hasOperation(authorization.operations());
    		
    		if(!hasPermission){
    			throw new SecurityException(403, "Usuário sem permissão para acessar este recurso.");
    		}
    	}
    		
        Object result = ic.proceed();
        
        return result;
    }
}
