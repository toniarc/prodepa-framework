package br.gov.pa.prodepa.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static String camelCaseToDotSeparator(String text){
		return camelCaseToNormalText(text, ".");
	}
	
	public static String camelCaseToUnderscoreSeparator(String text) {
		return camelCaseToNormalText(text, "_");
	}

	public static String camelCaseToNormalText(String text, String separator) {
		
		StringBuilder sb = new StringBuilder(text);
		for(int i=0;  sb.length() > i ; i++){
			
			if(Character.isUpperCase(sb.charAt(i))){
				if(sb.length() > (i+1) ){
					if(!Character.isUpperCase(sb.charAt(i+1)) && i != 0 && sb.charAt(i-1) != '_'){
						sb.insert(i, separator);
						i++;
					}	
				}
			}
			
			if(!Character.isUpperCase(sb.charAt(i))){
				if(sb.length() > (i+1) ){
					if(Character.isUpperCase(sb.charAt(i+1))){
						sb.insert(i+1, separator);
						i++;
					}	
				}
			}
		}
		return sb.toString().toLowerCase();
		
	}
	
	public static String splitWords(String text) {
		StringBuilder test = new StringBuilder(text);
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(test.toString());
		int correcaoIndex = 0;
		while (matcher.find()) {
			test.insert(matcher.start() + correcaoIndex, " ");
			correcaoIndex++;
		}
		return test.toString().trim();
	}
	
	public static void main(String[] args) {
		System.out.println(camelCaseToDotSeparator("WSUsuarioDTO"));
		System.out.println(camelCaseToUnderscoreSeparator("WSUsuarioDTO"));
	}
}
