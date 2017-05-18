package br.gov.pa.prodepa.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.pa.prodepa.domain.Model;
import br.gov.pa.prodepa.util.Beans;
import br.gov.pa.prodepa.util.PropertiesUtil;

public abstract class AbstractDaoCrud<T extends Model> implements DaoCrud<T> {

	private static final long serialVersionUID = -1674149542170215138L;
	
	@Inject
	private EntityManager entityManager;

	private Class<T> beanClass;
	
	public AbstractDaoCrud() {
		try {
			try {
				beanClass = (Class<T>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0];
			} catch (Exception e) {
				beanClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			}
			
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public List<T> search(T bean) {
		return search(bean, null, null);
	}

	public T load(Object id){
		return getEntityManager().find(beanClass, id);
	}

	public void insert(T bean){
		getEntityManager().persist(bean);
	}

	public T update(T bean){
		return getEntityManager().merge(bean);
	}

	public void remove(Object id){
		T entity = this.load(id);
		getEntityManager().remove(entity);
	}
}
