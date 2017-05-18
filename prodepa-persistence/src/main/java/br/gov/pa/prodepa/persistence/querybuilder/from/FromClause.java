package br.gov.pa.prodepa.persistence.querybuilder.from;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.gov.pa.prodepa.domain.Model;
import br.gov.pa.prodepa.persistence.querybuilder.Clause;

public class FromClause implements Clause {
	
	private List<FromExpression> expressions = new ArrayList<FromExpression>();

	public <T extends Model> FromClause(Class<T> rootEntity, String rootAlias, FromExpression[] expressions) {
		this.expressions.add(new RootEntity<T>(rootEntity, rootAlias));
		this.expressions.addAll(Arrays.asList(expressions));
	}

	public <T extends Model> FromClause(Class<T> rootEntity, String rootAlias) {
		this.expressions.add(new RootEntity<T>(rootEntity, rootAlias));
	}

	public void buildHql(StringBuilder hql) {
		hql.append("from ");
		
		for(int i=0; i<expressions.size();i++){
			this.expressions.get(i).buildHql(hql);
			hql.append(" ");
		}
	}

	public static FromExpression innerJoin(String ownerAlias, String attributeJoin, String alias) {
		return new InnerJoin(ownerAlias, attributeJoin, alias);
	}

	public static FromExpression leftJoin(String ownerAlias, String attributeJoin, String alias) {
		return new LeftJoin(ownerAlias, attributeJoin, alias);
	}

}
