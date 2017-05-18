package br.gov.pa.prodepa.exceptions.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.gov.pa.prodepa.exceptions.ApplicationException;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<ApplicationException> {

	public Response toResponse(ApplicationException ex) {
		ex.printStackTrace();
		return Response.status(ex.getStatus()).entity(ex).type(MediaType.APPLICATION_JSON).build();
	}
}