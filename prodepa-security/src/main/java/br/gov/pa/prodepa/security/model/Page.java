package br.gov.pa.prodepa.security.model;

import java.util.Arrays;

public class Page {

	private String page;
	private String[] operations;

	public Page(String page, String[] operations) {
		this.page = page;
		this.operations = operations;
	}

	public String getPage() {
		return page;
	}

	public String[] getOperations() {
		return operations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(operations);
		result = prime * result + ((page == null) ? 0 : page.hashCode());
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
		Page other = (Page) obj;
		if (!Arrays.equals(operations, other.operations))
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		return true;
	}

}
