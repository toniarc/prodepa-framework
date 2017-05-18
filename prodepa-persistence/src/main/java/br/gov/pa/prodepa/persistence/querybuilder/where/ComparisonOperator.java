package br.gov.pa.prodepa.persistence.querybuilder.where;

public abstract class ComparisonOperator implements WhereExpression{

	abstract Parameter getParameter();
	
	protected boolean isEmpty(Object valor) {
		if(valor == null) return true;
		if(valor instanceof String && ((String) valor).trim().length() == 0) return true;
		return false;
	}
}
