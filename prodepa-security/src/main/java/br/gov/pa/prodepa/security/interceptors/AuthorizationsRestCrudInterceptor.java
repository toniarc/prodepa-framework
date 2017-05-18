package br.gov.pa.prodepa.security.interceptors;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.gov.pa.prodepa.exceptions.ApplicationException;
import br.gov.pa.prodepa.exceptions.SecurityException;
import br.gov.pa.prodepa.security.SecurityContext;
import br.gov.pa.prodepa.security.anotations.AuthorizationsRestCrud;
import br.gov.pa.prodepa.security.anotations.RestCrudMethod;

@Interceptor
@AuthorizationsRestCrud
public class AuthorizationsRestCrudInterceptor {

	@Inject
	private SecurityContext securityContext;
	
    @AroundInvoke
    public Object aroundInvoke(InvocationContext ic) throws SecurityException, ApplicationException, Exception {
        
    	if(!securityContext.isLoggedIn()){
    		throw new SecurityException("Usuário não autenticado.");
    	}
    	
    	AuthorizationsRestCrud authorizations = ic.getTarget().getClass().getSuperclass().getAnnotation(AuthorizationsRestCrud.class);
    	
    	if(authorizations != null){
    		
    		String methodName = ic.getMethod().getName();
    		
    		if(methodName != null && ic.getMethod().isAnnotationPresent(RestCrudMethod.class)){
    			
    			boolean hasPermission = true;
    			
    			if(methodName.equals("search") && authorizations.search() != null){
    				hasPermission = securityContext.hasOperation(authorizations.search());
    			}
    			
    			if(methodName.equals("insert") && authorizations.insert() != null){
    				hasPermission = securityContext.hasOperation(authorizations.insert());
    			}
    			
    			if(methodName.equals("update") && authorizations.update() != null){
    				hasPermission = securityContext.hasOperation(authorizations.update());
    			}
    			
    			if(methodName.equals("remove") && authorizations.remove() != null){
    				hasPermission = securityContext.hasOperation(authorizations.remove());
    			}
    			
    			if(methodName.equals("enable") && authorizations.enable() != null){
    				hasPermission = securityContext.hasOperation(authorizations.enable());
    			}
    			
    			if(methodName.equals("disable") && authorizations.disable() != null){
    				hasPermission = securityContext.hasOperation(authorizations.disable());
    			}
    			
    			if(methodName.equals("load") && authorizations.load() != null){
    				hasPermission = securityContext.hasOperation(authorizations.load());
    			}
    			
    			if(!hasPermission){
    				throw new SecurityException(403, "Usuário sem permissão para acessar este recurso.");
    			}
    		}
        	
    	}
    	
    	
        Object result = ic.proceed();
        
        return result;
    }
}
