package br.gov.pa.prodepa.security.interceptors;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.gov.pa.prodepa.exceptions.ApplicationException;
import br.gov.pa.prodepa.exceptions.SecurityException;
import br.gov.pa.prodepa.security.SecurityContext;
import br.gov.pa.prodepa.security.anotations.LoggedIn;

@LoggedIn
@Interceptor
public class LoggedInInterceptor {

	@Inject
	private SecurityContext securityContext;
	
    @AroundInvoke
    public Object aroundInvoke(InvocationContext ic) throws SecurityException, ApplicationException, Exception {
        
    	securityContext.updateSession();
    	
        Object result = ic.proceed();
        
        return result;
    }
}
