package br.gov.pa.prodepa.exceptions;

import java.util.ArrayList;
import java.util.List;

import br.gov.pa.prodepa.exceptions.error.ErrorMessage;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private List<ErrorMessage> messages = new ArrayList<ErrorMessage>();

	public BusinessException() {
		this.messages = new ArrayList<ErrorMessage>();
	}
	
	public BusinessException(List<ErrorMessage> messages) {
		super();
		this.messages = messages;
	}

	public List<ErrorMessage> getMessages() {
		return messages;
	}
	
	public void addError(String mensagem) {
		messages.add(new ErrorMessage(mensagem, null));
	}
	
	public boolean hasErrors() {
		if(messages != null && messages.size() > 0){
			return true;
		}
		return false;
	}
	
	public void throwBusinessException() throws BusinessException {
		if (messages != null && messages.size() > 0) {
			throw this;
		}
	}
}