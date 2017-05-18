package br.gov.pa.prodepa.persistence.generic;

import java.util.Map;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import br.gov.pa.prodepa.domain.Model;

public class Clause {

	protected <T> Expression<T> getExpression(Root<? extends Model> root, Map<String, Join<? extends Model, ? extends Model>> joins, String attribute, Class<T> valueClass) {
		String[] parts = attribute.split("\\.");
		Expression<T> expression;
		if(parts.length == 1) {
			expression = root.<T>get(attribute);
		} else {
			String alias = parts[0];
			String attributeName = parts[1];
			Join<?, ?> join = joins.get(alias);
			expression = join.<T>get(attributeName);
		}
		return expression;
	}
}
