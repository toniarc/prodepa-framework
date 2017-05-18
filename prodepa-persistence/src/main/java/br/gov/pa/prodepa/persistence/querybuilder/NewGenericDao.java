package br.gov.pa.prodepa.persistence.querybuilder;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.gov.pa.prodepa.domain.Model;
import br.gov.pa.prodepa.persistence.querybuilder.Expression;
import br.gov.pa.prodepa.persistence.querybuilder.QueryBuilder;
import br.gov.pa.prodepa.persistence.querybuilder.where.WhereExpression;

public class NewGenericDao {

	@Inject
	private EntityManager entityManager;

	public List getResultList(QueryBuilder qb){
		Query query = entityManager.createQuery(qb.build());
		
		for(Expression e : qb.getExpressions()){
			if(e instanceof WhereExpression){
				WhereExpression we = (WhereExpression)e;
				//Map<String, Object> parameterValues = we.getParameterValues();
			}
		}
		return null;
	}
	
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

	public <T> T find(Class<T> clazz, Object id) {
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
