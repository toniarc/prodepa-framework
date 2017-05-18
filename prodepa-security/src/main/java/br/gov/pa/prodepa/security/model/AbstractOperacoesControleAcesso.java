package br.gov.pa.prodepa.security.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractOperacoesControleAcesso {
	
	
	public Map<String, String> exportRoles() throws Exception {
		
		try {
			Map<String, String> roles = new HashMap<String, String>();
			
			for(Field f :this.getClass().getFields()){
				roles.put(f.getName(), (String) f.get(this));
			}
			
			return roles;
		} catch (Exception e) {
			throw e;
		}
		
	}

}
