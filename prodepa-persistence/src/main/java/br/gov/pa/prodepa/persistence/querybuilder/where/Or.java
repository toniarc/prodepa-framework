package br.gov.pa.prodepa.persistence.querybuilder.where;

import java.util.Arrays;

public class Or extends LogicalOperator {
	
	private Or(WhereExpression[] whereExpressions) {
		this.expressions.addAll(Arrays.asList(whereExpressions));
	}
	
	public static Or build(WhereExpression[] whereExpressions){
		return new Or(whereExpressions);
	}

	public void buildHql(StringBuilder hql) {
		hql.append("(");
		for(int i=0; i<expressions.size();i++){
			expressions.get(i).buildHql(hql);
			
			if(expressions.size() != i+1){
				hql.append(" or ");
			} else { 
				hql.append(" ");
			}
		}
		hql.append(")");
	}

}
