package br.gov.pa.prodepa.rest;

import java.util.List;

import javax.ws.rs.core.Response;

public class RestMessage {
	
	private int status;
	private String[] messages;
	
	private RestMessage(int status, String message) {
		this.status = status;
		this.messages = new String[]{message};
	}
	
	private RestMessage(int status, List<Error> errors) {
		this.status = status;
		this.messages = new String[errors.size()];
		
		int index = 0;
		for(Error e : errors){
			messages[index] = e.getMessage();
			index++;
		}
	}

	public static Response success(String message){
		RestMessage msg = new RestMessage(200, message);
		return Response.ok(msg).build();
	}
	
	public static Response error(String message){
		RestMessage msg = new RestMessage(500, message);
		return Response.status(500).entity(msg).build();
	}
	
	public static Response error(List<Error> errors){
		RestMessage msg = new RestMessage(500, errors);
		return Response.status(500).entity(msg).build();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String[] getMessage() {
		return messages;
	}

	public void setMessage(String[] message) {
		this.messages = message;
	}
	
}
