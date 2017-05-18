package br.gov.pa.prodepa.persistence.querybuilder.where;

import java.util.Arrays;

public class And extends LogicalOperator{

	private And(WhereExpression[] whereExpressions) {
		this.expressions.addAll(Arrays.asList(whereExpressions));
	}
	
	public static And build(WhereExpression[] whereExpressions){
		return new And(whereExpressions);
	}

	public void buildHql(StringBuilder hql) {
		hql.append("(");
		for(int i=0; i<expressions.size();i++){
			expressions.get(i).buildHql(hql);
			
			if(expressions.size() != i+1){
				hql.append(" and ");
			} else { 
				hql.append(" ");
			}
		}
		hql.append(")");
	}

}
