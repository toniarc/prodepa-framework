package br.gov.pa.prodepa.business;

import java.io.Serializable;
import java.util.List;

import br.gov.pa.prodepa.domain.Model;
import br.gov.pa.prodepa.persistence.generic.QueryParameter;

public interface BusinessCrud<T extends Model> extends Serializable {

	List<T> search(T bean);

	List<T> search(T bean, Integer first, Integer maxResults);

	T load(Object id);

	Integer count(T bean);

	void insert(T bean);

	T update(T bean);

	void remove(Object id);
}