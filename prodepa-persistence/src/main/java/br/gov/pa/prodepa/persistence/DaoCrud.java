package br.gov.pa.prodepa.persistence;

import java.io.Serializable;
import java.util.List;

public interface DaoCrud<T> extends Serializable {

	List<T> search(T bean);

	List<T> search(T bean, Integer first, Integer maxResults);

	Integer count(T bean);

	T load(Object id);

	void insert(T bean);

	T update(T bean);

	void remove(Object id);

}
