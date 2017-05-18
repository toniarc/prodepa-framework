package br.gov.pa.prodepa.persistence.querybuilder.where;

public class SingleParameter implements Parameter {

	private String replace;
	private Object valor;

	public SingleParameter(String replace, Object valor) {
		this.replace = replace;
		this.valor = valor;
	}

	public String getReplace() {
		return replace;
	}

	public Object getValor() {
		return valor;
	}

}
