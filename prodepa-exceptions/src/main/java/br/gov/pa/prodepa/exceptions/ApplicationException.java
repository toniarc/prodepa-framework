package br.gov.pa.prodepa.exceptions;

@javax.ejb.ApplicationException(rollback=true, inherited=true)
public class ApplicationException extends Exception {

	private static final long serialVersionUID = -8999932578270387947L;
	
	/** 
	 * contains redundantly the HTTP status of the response sent back to the client in case of error, so that
	 * the developer does not have to look into the response headers. If null a default 
	 */
	private Integer status;
	
	public ApplicationException(int status, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
	}

	public ApplicationException() { }

	public ApplicationException(Exception e) {
		super(e.getMessage(), e.getCause());
		this.status = 500;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}