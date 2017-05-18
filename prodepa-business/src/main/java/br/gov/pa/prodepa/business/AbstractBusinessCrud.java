package br.gov.pa.prodepa.business;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;

import br.gov.pa.prodepa.business.validation.BusinessValidations;
import br.gov.pa.prodepa.controleacesso.commons.dto.UsuarioDtoWS;
import br.gov.pa.prodepa.domain.Model;
import br.gov.pa.prodepa.persistence.DaoCrud;
import br.gov.pa.prodepa.util.Beans;
import br.gov.pa.prodepa.util.PropertiesUtil;

public abstract class AbstractBusinessCrud<T extends Model, S extends DaoCrud<T>> implements BusinessCrud<T> {

	private static final long serialVersionUID = -7665267812002039845L;

	@Inject
	protected UsuarioDtoWS usuarioAutenticado;

	protected PropertiesUtil pu;
	
	@Inject
	protected BusinessValidations businessValidations;
	
	private Class<T> beanClass;
	
	private Class<S> daoClass;
	
	private S dao;
	
	private enum Operacao {INSERT, UPDATE, REMOVE, ENABLE, DISABLE};
	
	public AbstractBusinessCrud() {
		try {
			pu = new PropertiesUtil();
			try {
				beanClass = (Class<T>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0];
				daoClass = (Class<S>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[1];
			} catch (Exception e) {
				beanClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
				daoClass = (Class<S>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
			}
			
			dao = Beans.getReference(daoClass);
			
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public void insert(T bean){
		dao.insert(bean);
	}
	
	public T update(T bean){
		return dao.update(bean);
	}
	
	public void remove(Object id){
		dao.remove(id);
	}
	
	public T load(Object id){
		return dao.load(id);
	}
	
	public List<T> search(T bean){
		return dao.search(bean);
	}
	
	public List<T> search(T bean, Integer first, Integer maxResults){
		return dao.search(bean, first, maxResults);
	}
	
	public Integer count(T bean){
		return dao.count(bean);
	}
	
	protected void validateInsert(T t) throws Exception{}
	protected void validateUpdate(T t) throws Exception{}
	protected void validateDelete(T t) throws Exception{}
	
	protected void afterLoad(T t) throws Exception {}
	protected void afterInsert(T t) throws Exception {}
	protected void afterUpdate(T t) throws Exception {}
	protected void afterDelete(T t) throws Exception {}
	
	protected void beforeLoad(Object id, Class<T> clazz) {}
	protected void beforeInsert(T t) throws Exception{}
	protected void beforeUpdate(T t) throws Exception{}
	protected void beforeDelete(T t) throws Exception{}
}
