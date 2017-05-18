package br.gov.pa.prodepa.security.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractPageSecurity {

	private List<Page> pages = new ArrayList<Page>();
	
	public void add(Page page){
		pages.add(page);
	}
	
	public List<Page> getPages(){
		return Collections.unmodifiableList(pages);
	}
}
