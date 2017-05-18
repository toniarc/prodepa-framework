package br.gov.pa.prodepa.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private Properties prop = new Properties();
	
	public PropertiesUtil() {
		try {			
			loadPropertyFileFromResourceFolder("prodepa.properties");
		} catch (Exception e) {
			throw new RuntimeException("O Arquivo /{APP_ROOT}/src/main/resources/prodepa.properties não foi encontrado.");
		}
	}
	
	public String getProperty(String property) {
		String value = prop.getProperty(property);
		
		if(value == null || value.trim().length() == 0){
			throw new RuntimeException("A propriedade " + property + " não foi encontrada.");
		}
		
		return value;
	}

	private void loadPropertyFileFromResourceFolder(String propFileName) throws IOException, FileNotFoundException {

		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);
 
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		
	}
}

