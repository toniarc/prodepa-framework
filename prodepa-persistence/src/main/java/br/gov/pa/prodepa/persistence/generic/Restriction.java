package br.gov.pa.prodepa.persistence.generic;

public class Restriction {

	private Operator operator;

	private String attribute;

	private Object value;
	
	private Object otherValue;

	public Restriction(Operator operator, String attribute, Object value) {
		super();
		this.operator = operator;
		this.attribute = attribute;
		this.value = value;
	}

	public Restriction(Operator operator, String attribute, Object value, Object otherValue) {
		this(operator, attribute, value);
		this.otherValue = otherValue;
	}
	
	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Object getOtherValue() {
		return otherValue;
	}

	public void setOtherValue(Object otherValue) {
		this.otherValue = otherValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attribute == null) ? 0 : attribute.hashCode());
		result = prime * result
				+ ((operator == null) ? 0 : operator.hashCode());
		result = prime * result
				+ ((otherValue == null) ? 0 : otherValue.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restriction other = (Restriction) obj;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		if (operator != other.operator)
			return false;
		if (otherValue == null) {
			if (other.otherValue != null)
				return false;
		} else if (!otherValue.equals(other.otherValue))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
