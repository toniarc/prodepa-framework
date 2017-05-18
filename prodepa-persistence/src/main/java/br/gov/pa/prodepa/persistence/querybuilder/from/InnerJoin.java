package br.gov.pa.prodepa.persistence.querybuilder.from;

public class InnerJoin implements FromExpression {

	private String attributeJoin;
	private String alias;
	private String ownerAlias;

	public InnerJoin(String ownerAlias, String attributeJoin, String alias) {
		this.ownerAlias = ownerAlias;
		this.attributeJoin = attributeJoin;
		this.alias = alias;
	}

	public void buildHql(StringBuilder hql) {
		hql.append(" inner join ").append(ownerAlias).append(".").append(attributeJoin).append(" ").append(alias);
	}

}
