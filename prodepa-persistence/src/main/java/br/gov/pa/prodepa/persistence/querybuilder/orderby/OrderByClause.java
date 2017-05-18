package br.gov.pa.prodepa.persistence.querybuilder.orderby;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.gov.pa.prodepa.persistence.querybuilder.Clause;

public class OrderByClause implements Clause {
	
	private List<OrderByExpression> expressions = new ArrayList<OrderByExpression>();
	
	public OrderByClause(OrderByExpression[] expressions) {
		this.expressions.addAll(Arrays.asList(expressions));
	}

	public void buildHql(StringBuilder hql) {
		hql.append("order by ");
		
		for(int i=0; i<expressions.size();i++){
			expressions.get(i).buildHql(hql);
			
			if(expressions.size() != i+1){
				hql.append(", ");
			} else {
				hql.append(" ");
			}
			
		}
	}
	
	public static OrderByExpression asc(String atributo) {
		return new Asc(atributo);
	}

	public static OrderByExpression desc(String atributo) {
		return new Desc(atributo);
	}

}
