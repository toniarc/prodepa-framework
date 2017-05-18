package br.gov.pa.prodepa.persistence.querybuilder.orderby;

public class Asc implements OrderByExpression {

	private String atributo;

	public Asc(String atributo) {
		this.atributo = atributo;
	}

	public void buildHql(StringBuilder hql) {
		hql.append(atributo).append(" asc");
	}

}
