package br.gov.pa.prodepa.persistence.querybuilder.where;

import java.util.ArrayList;
import java.util.List;

import br.gov.pa.prodepa.persistence.querybuilder.Clause;

public class WhereClause implements Clause {
	
	private List<WhereExpression> expressions = new ArrayList<WhereExpression>();
	private List<Parameter> parameters = new ArrayList<Parameter>(); 

	public WhereClause(WhereExpression[] expressions) {
		for(WhereExpression we : expressions){
			if(we instanceof ComparisonOperator){
				ComparisonOperator co = (ComparisonOperator) we;
				this.parameters.add(co.getParameter());
			}
			this.expressions.add(we);
		}
	}

	public void buildHql(StringBuilder hql) {
		
		if(expressions == null || expressions.size() == 0){
			return;
		}
		
		hql.append("where ");
		
		for(int i=0; i<expressions.size();i++){
			this.expressions.get(i).buildHql(hql);
			hql.append(" ");
		}
	}

	public static WhereExpression eq(String atributo, Object valor) {
		return Eq.build(atributo, valor);
	}

	public static WhereExpression or(WhereExpression... whereExpressions) {
		return Or.build(whereExpressions);
	}
	
	public static WhereExpression and(WhereExpression... whereExpressions) {
		return And.build(whereExpressions);
	}

}
