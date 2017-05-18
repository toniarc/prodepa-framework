package br.gov.pa.prodepa.persistence.generic;

import br.gov.pa.prodepa.domain.Model;

public class Join <X extends Model, Y extends Model>{

	private Class<X> baseClass;
	private Class<Y> otherClass;
	private String joinAlias;
	private String joinAttributeName;
	
	public Join(Class<X> baseClass, Class<Y> otherClass, String joinAlias,
			String joinAttributeName) {
		super();
		this.baseClass = baseClass;
		this.otherClass = otherClass;
		this.joinAlias = joinAlias;
		this.joinAttributeName = joinAttributeName;
	}

	public Class<X> getBaseClass() {
		return baseClass;
	}

	public void setBaseClass(Class<X> baseClass) {
		this.baseClass = baseClass;
	}

	public Class<Y> getOtherClass() {
		return otherClass;
	}

	public void setOtherClass(Class<Y> otherClass) {
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
