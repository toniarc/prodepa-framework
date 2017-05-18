package br.gov.pa.prodepa.persistence.querybuilder.where;

public class Eq extends ComparisonOperator {

	private String atributo;
	private Object valor;

	private Eq(String atributo, Object valor) {
		this.atributo = atributo;
		this.valor = valor;
	}
	
	public static Eq build(String atributo, Object valor){
		return new Eq(atributo, valor);
	}

	public void buildHql(StringBuilder hql) {
		if(isEmpty(valor)) return;
		
		hql.append(atributo).append(" = ").append(":").append(atributo.replace(".", "_"));
	}

	public Parameter getParameter(){
		if(isEmpty(valor)) return null;
		return new SingleParameter(atributo.replace(".", "_"), valor);
	}

}
