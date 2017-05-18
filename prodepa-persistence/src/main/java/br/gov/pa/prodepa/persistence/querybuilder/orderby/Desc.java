package br.gov.pa.prodepa.persistence.querybuilder.orderby;

public class Desc implements OrderByExpression {

	private String atributo;

	public Desc(String atributo) {
		this.atributo = atributo;
	}

	public void buildHql(StringBuilder hql) {
		hql.append(atributo).append(" desc");
	}

}
