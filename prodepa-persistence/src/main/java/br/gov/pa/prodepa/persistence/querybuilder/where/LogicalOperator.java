package br.gov.pa.prodepa.persistence.querybuilder.where;

import java.util.ArrayList;
import java.util.List;

import br.gov.pa.prodepa.persistence.querybuilder.Expression;

public abstract class LogicalOperator implements WhereExpression {

	protected List<Expression> expressions = new ArrayList<Expression>();
	
}
