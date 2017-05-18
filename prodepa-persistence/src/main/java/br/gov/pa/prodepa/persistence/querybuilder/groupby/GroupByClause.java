package br.gov.pa.prodepa.persistence.querybuilder.groupby;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.gov.pa.prodepa.persistence.querybuilder.Clause;

public class GroupByClause implements Clause {
	
	private List<GroupByExpression> expressions = new ArrayList<GroupByExpression>();

	public GroupByClause(GroupByExpression[] expressions) {
		this.expressions.addAll(Arrays.asList(expressions));
	}

	public void buildHql(StringBuilder hql) {
		hql.append("group by ");
		
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
