package br.gov.pa.prodepa.persistence.generic;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.gov.pa.prodepa.domain.Model;

public class GenericDAO implements Serializable {

	private static final long serialVersionUID = 6305846642887196162L;

	@Inject
	private EntityManager entityManager;

	public <T extends Model> void insert(T bean) {
		entityManager.persist(bean);
	}

	public <T extends Model> T update(T bean) {
		return entityManager.merge(bean);
	}

	public <T extends Model> void delete(T bean) {
		bean = entityManager.merge(bean);
		entityManager.remove(bean);
	}

	@SuppressWarnings("unchecked")
	public <T extends Model> T load(QueryParameter queryParameter, T entityExample) throws Exception {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(entityExample.getClass());
		Root<T> root = (Root<T>) criteriaQuery.from(entityExample.getClass());
		
		if (queryParameter != null) {
			queryParameter.join().build(root);
			
			queryParameter.select().build(queryParameter, criteriaQuery, root);
			
			fetchLazyFields(queryParameter, root);
			queryParameter.where().build(entityExample, criteriaBuilder, root, criteriaQuery, queryParameter.join().getJoins());
			queryParameter.orderBy().build(criteriaBuilder, criteriaQuery, root, queryParameter.join().getJoins());
		}
		
		TypedQuery<T> q = entityManager.createQuery(criteriaQuery);
		return q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public <FROM extends Model, RETURN> RETURN load(QueryParameter queryParameter, FROM entityExample, Class<RETURN> returnType) throws Exception {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<RETURN> criteriaQuery = (CriteriaQuery<RETURN>) criteriaBuilder.createQuery(returnType);
		Root<FROM> root = (Root<FROM>) criteriaQuery.from(entityExample.getClass());
		
		if (queryParameter != null) {
			queryParameter.join().build(root);
			
			queryParameter.select().build(queryParameter, criteriaQuery, root);
			
			fetchLazyFields(queryParameter, root);
			queryParameter.where().build(entityExample, criteriaBuilder, root, criteriaQuery, queryParameter.join().getJoins());
			queryParameter.orderBy().build(criteriaBuilder, criteriaQuery, root, queryParameter.join().getJoins());
		}
		
		TypedQuery<RETURN> q = entityManager.createQuery(criteriaQuery);
		return q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public <FROM extends Model, RETURN> List<RETURN> findAll(QueryParameter queryParameter, FROM entityExample, Class<RETURN> returnType) throws Exception {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<RETURN> criteriaQuery = (CriteriaQuery<RETURN>) criteriaBuilder.createQuery(returnType);
		Root<FROM> root = (Root<FROM>) criteriaQuery.from(entityExample.getClass());
		
		if (queryParameter != null) {
			queryParameter.join().build(root);
			
			queryParameter.select().build(queryParameter, criteriaQuery, root);
			
			fetchLazyFields(queryParameter, root);
			queryParameter.where().build(entityExample, criteriaBuilder, root, criteriaQuery, queryParameter.join().getJoins());
			queryParameter.orderBy().build(criteriaBuilder, criteriaQuery, root, queryParameter.join().getJoins());
		}
		
		TypedQuery<RETURN> q = entityManager.createQuery(criteriaQuery);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public <T extends Model> List<T> findAll(QueryParameter queryParameter, T entityExample) throws Exception {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(entityExample.getClass());
		Root<T> root = (Root<T>) criteriaQuery.from(entityExample.getClass());
		
		if (queryParameter != null) {
			queryParameter.join().build(root);
			
			queryParameter.select().build(queryParameter, criteriaQuery, root);
			
			fetchLazyFields(queryParameter, root);
			queryParameter.where().build(entityExample, criteriaBuilder, root, criteriaQuery, queryParameter.join().getJoins());
			queryParameter.orderBy().build(criteriaBuilder, criteriaQuery, root, queryParameter.join().getJoins());
		}
		TypedQuery<T> q = entityManager.createQuery(criteriaQuery);
		if (queryParameter != null) {
			if (queryParameter.getFirstResult() != null) {
				q.setFirstResult(queryParameter.getFirstResult());
			}
			if (queryParameter.getMaxResult() != null) {
				q.setMaxResults(queryParameter.getMaxResult());
			}
		}
		
		List<T> result = q.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	public <T extends Model> Long count(QueryParameter queryParameter, T entityExample) throws Exception {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = (CriteriaQuery<Long>) criteriaBuilder.createQuery(Long.class);
		Root<T> root = (Root<T>) criteriaQuery.from(entityExample.getClass());
		
		String idAttributeName = "";
		Method[] methods = entityExample.getClass().getDeclaredMethods();
		for(int i=0;i<methods.length;i++){
			Method m = methods[i];
			if(m.isAnnotationPresent(javax.persistence.Id.class)){
				String finalPart = m.getName().substring(4, m.getName().length());
				String initialPart = m.getName().substring(3, 4);
				idAttributeName = initialPart.toLowerCase() + finalPart;
				break;
			}
		}
		
		criteriaQuery.select(criteriaBuilder.count(root.get(idAttributeName)));
		
		if (queryParameter != null) {
			queryParameter.join().build(root);
			queryParameter.where().build(entityExample, criteriaBuilder, root, criteriaQuery, queryParameter.join().getJoins());
		}
		TypedQuery<Long> q = entityManager.createQuery(criteriaQuery);
		return q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public <T extends Model> Number max(QueryParameter queryParameter, T entityExample) throws Exception {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Number> criteriaQuery = (CriteriaQuery<Number>) criteriaBuilder.createQuery(Number.class);
		Root<T> root = (Root<T>) criteriaQuery.from(entityExample.getClass());
		
		if (queryParameter != null) {
			queryParameter.join().build(root);
			
			queryParameter.select().build(queryParameter, criteriaQuery, root);
			
			fetchLazyFields(queryParameter, root);
			queryParameter.where().build(entityExample, criteriaBuilder, root, criteriaQuery, queryParameter.join().getJoins());
			queryParameter.orderBy().build(criteriaBuilder, criteriaQuery, root, queryParameter.join().getJoins());
		}
		
		TypedQuery<Number> q = entityManager.createQuery(criteriaQuery);
		return q.getSingleResult();
	}

	private void fetchLazyFields(QueryParameter queryParameter, Root<?> root) {
		if (queryParameter.getLazyFieldToLoad() != null) {
			for (String field : queryParameter.getLazyFieldToLoad()) {
				root.fetch(field, JoinType.LEFT);
			}
		}
	}

	public <T> T findById(Class<T> clazz, Object id) {
		return entityManager.find(clazz, id);
	}
	
	public void detachEntity(Object entity){
		entityManager.detach(entity);
	}

	public void clearPersistentContext() {
		entityManager.clear();
	}
	
	public void flushAndClearPersistentContext() {
		entityManager.flush();
		entityManager.clear();
	}

}
