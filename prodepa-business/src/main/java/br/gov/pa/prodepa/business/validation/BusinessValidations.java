package br.gov.pa.prodepa.business.validation;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.gov.pa.prodepa.domain.Model;
import br.gov.pa.prodepa.exceptions.BusinessException;
import br.gov.pa.prodepa.persistence.generic.GenericDAO;
import br.gov.pa.prodepa.persistence.generic.QueryParameter;

public class BusinessValidations {

	private BusinessException businessException = new BusinessException();
	
	@Inject
	private GenericDAO genericDao;
	
	public void required(Object object, String message) {
		if (object == null) {
			businessException.addError(message);
		}
	}

	public void required(Object[] object, String message) {
		if (object == null || object.length == 0) {
			businessException.addError(message);
		}
	}

	public void required(List<?> list, String message) {
		if (list == null || list.size() == 0) {
			businessException.addError(message);
		}
	}

	public void validateBeginBeforeEnd(Date dataInicio, Date dataFim, String message) {
		if (dataInicio != null || dataFim != null) {
			if (dataInicio.after(dataFim)) {
				businessException.addError(message);
			}
		}
	}

	public void required(String string, String message) {
		if (string == null || string.trim().length() == 0) {
			businessException.addError(message);
		}
	}
	
	public void required(Long number, String message) {
		if (number == null || number == 0) {
			businessException.addError(message);
		}
	}
	
	public void required(Integer number, String message) {
		if (number == null || number == 0) {
			businessException.addError(message);
		}
	}
	
	public <T extends Model> void validateUniqueField(T bean, String attributeName, Object attributeValue, String message) throws Exception {
		
		QueryParameter q = new QueryParameter();
		q.where().equal(attributeName, attributeValue);
		
		if(bean.getId() != null){
			q.where().notEqual("id", bean.getId());
		}
		
		Long result = genericDao.count(q, bean.getClass().newInstance());
		if(result > 0) {
			businessException.addError(message);
		}
	}
	
	public void validateConstraints(String attributeName, Object attributeValue, Model entity, String message) throws Exception{
		QueryParameter q = new QueryParameter();
		q.where().equal(attributeName, attributeValue);
		
		if(entity.getId() != null){
			q.where().notEqual("id", entity.getId());
		}
		
		Long result = genericDao.count(q, entity.getClass().newInstance());
		if(result > 0) {
			businessException.addError(message);
		}
	}
	
	public void throwBusinessException() throws BusinessException {
		if (businessException.hasErrors()) {
			throw businessException;
		}
	}

	public void addError(String mensagem) {
		businessException.addError(mensagem);
	}
	
}
