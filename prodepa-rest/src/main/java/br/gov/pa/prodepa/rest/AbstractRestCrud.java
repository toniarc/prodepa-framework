package br.gov.pa.prodepa.rest;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.gov.pa.prodepa.business.BusinessCrud;
import br.gov.pa.prodepa.domain.CanEnableOrDisable;
import br.gov.pa.prodepa.domain.Model;
import br.gov.pa.prodepa.exceptions.ApplicationException;
import br.gov.pa.prodepa.exceptions.BusinessException;
import br.gov.pa.prodepa.security.anotations.RestCrudMethod;
import br.gov.pa.prodepa.util.Beans;
import br.gov.pa.prodepa.util.ReflectionUtils;

public abstract class AbstractRestCrud<T extends Model, S extends BusinessCrud<T>> implements Serializable {

	private static final long serialVersionUID = -3377803061879604819L;

	private Object id;

	private Class<T> beanClass;
	
	private Class<S> businessClass;
	
	@Inject Instance<S> businessInstance;

	@SuppressWarnings("unchecked")
	public AbstractRestCrud(){
		try {
			beanClass = (Class<T>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0];
			businessClass = (Class<S>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[1];
		} catch (Exception e){
			beanClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			businessClass = (Class<S>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		}
	}
	
	/**********************
	 * Crud methods
	 * @throws ApplicationException 
	 **********************/
	@GET
    @Path("/load/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
	@RestCrudMethod
    public T load(@PathParam("id") Long id) throws ApplicationException {
    	try {
    		T bean = null;
    		if(getFieldsToLoad() != null){
    			bean = getBusiness().load(id);
    		} else {
    			bean = getBusiness().load(id);
    		}
    		afterBeanLoad(bean);
    		return bean;
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
    }
	
	
	@POST
	@Path("/search")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@RestCrudMethod
    public Map<String, Object> search(T bean, @QueryParam("first") Integer first, @QueryParam("maxResults") Integer maxResults) throws ApplicationException {
		try {
			beforeSearch(bean);
			Map<String, Object> result = new HashMap<String, Object>();
	        result.put("count", getBusiness().count(bean));
	        result.put("list", getBusiness().search(bean, first, maxResults));
	        afterSearch(bean);
	        return result;
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
    }
	
	@POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@RestCrudMethod
    public Response insert(T bean) throws BusinessException, ApplicationException{
    	try {
    		beforeInsert(bean);
    		getBusiness().insert(bean);
    		Response response = RestMessage.success(getInsertSuccessMessage(bean));
    		afterInsert(bean);
    		return response;
		} catch (BusinessException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
    }
	
	@POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@RestCrudMethod
    public Response update(T bean) throws BusinessException, ApplicationException{
    	try {
    		beforeUpdate(bean);
    		getBusiness().update(bean);
    		afterUpdate(bean);
    		return RestMessage.success(getUpdateSuccessMessage(bean));
		} catch (BusinessException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
    }
	
	@POST
    @Path("/delete/{id:[0-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@RestCrudMethod
	public Response remove(@PathParam("id") Long id) throws BusinessException, ApplicationException{
		try {
			beforeDelete();
			getBusiness().remove(id);
			afterDelete();
			return RestMessage.success(getDeleteSuccessMessage(null));
		} catch (BusinessException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}
	
	@POST
    @Path("/enable")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@RestCrudMethod
    public Response enable(T bean) throws BusinessException, ApplicationException{
		try {
			beforeEnable(bean);
			CanEnableOrDisable d = (CanEnableOrDisable) bean;
			d.setEnable(true);
			bean = getBusiness().update(bean);
			afterEnable(bean);
			return RestMessage.success(getEnableSuccessMessage(bean));
		} catch (BusinessException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}
	
	@POST
    @Path("/disable")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@RestCrudMethod
    public Response disable(T bean) throws BusinessException, ApplicationException{
		try {
			beforeDisable(bean);
			CanEnableOrDisable d = (CanEnableOrDisable) bean;
			d.setEnable(false);
			bean = getBusiness().update(bean);
			afterDisable(bean);
			return RestMessage.success(getDisableSuccessMessage(bean));
		} catch (BusinessException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}
	
	/*************************
	 * User Messages Methods
	 *************************/
	
	public String getInsertSuccessMessage(T t){
		return "Cadastro efetuado com sucesso.";
	}
	
	public String getUpdateSuccessMessage(T t){
		return "Alteração efetuada com sucesso.";
	}
	
	public String getDeleteSuccessMessage(T t){
		return "Exclusão efetuada com sucesso.";
	}
	
	public String getEnableSuccessMessage(T t){
		return "Ativação efetuada com sucesso.";
	}
	
	public String getDisableSuccessMessage(T t){
		return "Desativação efetuada com sucesso.";
	}
	
	/*************************
	 * Callback Methods
	 *************************/
	
	public void afterBeanLoad(T bean) throws Exception{}
	
	public void beforeInsert(T bean) throws Exception{}
	
	public void afterInsert(T bean) throws Exception {}
	
	public void beforeUpdate(T bean) throws Exception{}
	
	public void afterUpdate(T bean) throws Exception {}
	
	public void beforeDelete() throws Exception{}
	
	public void afterDelete() throws Exception {}
	
	public void beforeEnable(T bean) throws Exception{}
	
	public void afterEnable(T bean) throws Exception{}
	
	public void beforeDisable(T bean) throws Exception{}
	
	public void afterDisable(T bean) throws Exception{}
	
	public void afterSearch(T bean) throws Exception{}
	
	public void beforeSearch(T bean) throws Exception{}
	
	/*************************
	 * Getters/Setters
	 *************************/
	
	protected Class<T> getBeanClass() {
		return this.beanClass;
	}
	
	protected Class<S> getBusinessClass(){
		return this.businessClass;
	}

	public S getBusiness() {
		//return Beans.getReference(getBusinessClass());
		return businessInstance.get();
	}

	public String[] getFieldsToLoad() {
		return null;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}
}