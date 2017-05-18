package br.gov.pa.prodepa.exceptions.error;


public class ErrorMessage {
	
	private String message;
	
	private String detailMessage;	

	public ErrorMessage() {
	}
	
	public ErrorMessage(String message, String detailMessage) {
		super();
		this.message = message;
		this.detailMessage = detailMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

}