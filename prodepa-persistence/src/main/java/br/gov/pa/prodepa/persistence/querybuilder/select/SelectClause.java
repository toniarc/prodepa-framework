package br.gov.pa.prodepa.persistence.querybuilder.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.gov.pa.prodepa.persistence.querybuilder.Clause;

public class SelectClause implements Clause {
	
	private List<SelectExpression> expressions = new ArrayList<SelectExpression>();

	public SelectClause(SelectExpression[] expressions) {
		this.expressions.addAll(Arrays.asList(expressions));
	}

	public void buildHql(StringBuilder hql) {
		hql.append("select ");
		
		for(int i=0; i<expressions.size();i++){
			expressions.get(i).buildHql(hql);
			
			if(expressions.size() != i+1){
				hql.append(", ");
			} else {
				hql.append(" ");
			}
		}
		
	}

}
