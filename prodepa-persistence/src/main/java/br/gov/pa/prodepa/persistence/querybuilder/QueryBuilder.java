package br.gov.pa.prodepa.persistence.querybuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.gov.pa.prodepa.domain.Model;
import br.gov.pa.prodepa.persistence.querybuilder.from.FromClause;
import br.gov.pa.prodepa.persistence.querybuilder.from.FromExpression;
import br.gov.pa.prodepa.persistence.querybuilder.groupby.GroupByClause;
import br.gov.pa.prodepa.persistence.querybuilder.groupby.GroupByExpression;
import br.gov.pa.prodepa.persistence.querybuilder.orderby.OrderByClause;
import br.gov.pa.prodepa.persistence.querybuilder.orderby.OrderByExpression;
import br.gov.pa.prodepa.persistence.querybuilder.select.SelectClause;
import br.gov.pa.prodepa.persistence.querybuilder.select.SelectExpression;
import br.gov.pa.prodepa.persistence.querybuilder.where.WhereClause;
import br.gov.pa.prodepa.persistence.querybuilder.where.WhereExpression;

public class QueryBuilder {

	StringBuilder hql = new StringBuilder();
	StringBuilder hqlFormatado = new StringBuilder();
	
	private List<Expression> rootExpressions = new ArrayList<Expression>();
	
	public QueryBuilder select(SelectExpression... expressions){
		rootExpressions.add(new SelectClause(expressions));
		return this;
	}
	
	public <T extends Model> QueryBuilder from(Class<T> rootEntity, String rootAlias){
		rootExpressions.add(new FromClause(rootEntity, rootAlias));
		return this;
	}
	
	public <T extends Model> QueryBuilder from(Class<T> rootEntity, String rootAlias, FromExpression... expressions){
		rootExpressions.add(new FromClause(rootEntity, rootAlias, expressions));
		return this;
	}
	
	public QueryBuilder where(WhereExpression... expressions){
		rootExpressions.add(new WhereClause(expressions));
		return this;
	}
	
	public QueryBuilder groupBy(GroupByExpression... expressions){
		rootExpressions.add(new GroupByClause(expressions));
		return this;
	}
	
	public QueryBuilder orderBy(OrderByExpression... expressions){
		rootExpressions.add(new OrderByClause(expressions));
		return this;
	}
	
	public String build(){
		if(rootExpressions == null || rootExpressions.size() == 0){
			return null;
		}
		
		for(Expression e : rootExpressions){
			e.buildHql(hql);
		}
		
		return hql.toString();
	}

	public List<Expression> getExpressions() {
		return Collections.unmodifiableList(rootExpressions);
	}
	
}
