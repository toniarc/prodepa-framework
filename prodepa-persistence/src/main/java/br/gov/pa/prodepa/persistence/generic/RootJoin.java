package br.gov.pa.prodepa.persistence.generic;

import br.gov.pa.prodepa.domain.Model;


public class RootJoin<T extends Model> {

	private Class<T> otherClass;
	private String joinAlias;
	private String joinAttributeName;
	
	public RootJoin(Class<T> otherClass, String joinAlias, String joinAttributeName) {
		this.otherClass = otherClass;
		this.joinAlias = joinAlias;
		this.joinAttributeName = joinAttributeName;
	}

	public Class<T> getOtherClass() {
		return otherClass;
	}

	public void setOtherClass(Class<T> otherClass) {
		this.otherClass = otherClass;
	}

	public String getJoinAlias() {
		return joinAlias;
	}

	public void setJoinAlias(String joinAlias) {
		this.joinAlias = joinAlias;
	}

	public String getJoinAttributeName() {
		return joinAttributeName;
	}

	public void setJoinAttributeName(String joinAttributeName) {
		this.joinAttributeName = joinAttributeName;
	}
	
}
