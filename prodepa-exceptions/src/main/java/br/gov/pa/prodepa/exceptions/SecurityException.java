package br.gov.pa.prodepa.exceptions;

public class SecurityException extends ApplicationException {

	private static final long serialVersionUID = 3254071104389477449L;
	
	public SecurityException(String message) {
		super(401, message, null);
	}

	public SecurityException(int httpStatusCode, String message) {
		super(httpStatusCode, message, null);
	}
}
