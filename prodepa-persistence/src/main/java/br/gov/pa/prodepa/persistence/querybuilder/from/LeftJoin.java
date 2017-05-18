package br.gov.pa.prodepa.persistence.querybuilder.from;

public class LeftJoin implements FromExpression {

	private String attributeJoin;
	private String alias;
	private String ownerAlias;

	public LeftJoin(String ownerAlias, String attributeJoin, String alias) {
		this.ownerAlias = ownerAlias;
		this.attributeJoin = attributeJoin;
		this.alias = alias;
	}

	public void buildHql(StringBuilder hql) {
		hql.append(" left join ").append(ownerAlias).append(".").append(attributeJoin).append(" ").append(alias);
	}

}
