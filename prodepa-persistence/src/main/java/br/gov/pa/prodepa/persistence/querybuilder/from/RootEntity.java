package br.gov.pa.prodepa.persistence.querybuilder.from;

import br.gov.pa.prodepa.domain.Model;

public class RootEntity<T extends Model> implements FromExpression {

	private Class<T> rootEntity;
	private String rootAlias;
	
	public RootEntity(Class<T> rootEntity, String rootAlias) {
		this.rootEntity = rootEntity;
		this.rootAlias = rootAlias;
	}

	public void buildHql(StringBuilder hql) {
		hql.append(rootEntity.getSimpleName()).append(" ").append(rootAlias);
	}

}
