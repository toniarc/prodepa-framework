package br.gov.pa.prodepa.persistence.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.hibernate.jpa.criteria.path.ListAttributeJoin;
import org.hibernate.jpa.criteria.path.SingularAttributeJoin;

public class SelectClause {

	List<String> columns;
	
	public void columns(String... columnsArray){
		columns = Arrays.asList(columnsArray);
	}
	
	public List<String> getColumns() {
		return columns;
	}
	
	public void build(QueryParameter queryParameter, CriteriaQuery criteriaQuery, Root root){
		if(queryParameter.select().getColumns() == null || queryParameter.select().getColumns().size() == 0){
			criteriaQuery.select(root);
		} else {
			List<Selection<?>> selectFields = new ArrayList<Selection<?>>();
			
			for(String s : queryParameter.select().getColumns()){
				if(!s.contains(".")){
					selectFields.add(root.get(s));
				} else {
					String[] parts = s.split("\\.");
					String aliasJoin = parts[0];
					String attribute = parts[1];
					
					Object obj = queryParameter.join().getJoins().get(aliasJoin);
					
					if(obj instanceof SingularAttributeJoin){
						SingularAttributeJoin saj = (SingularAttributeJoin) queryParameter.join().getJoins().get(aliasJoin);
						selectFields.add(saj.get(attribute));
					} 
					
					if(obj instanceof ListAttributeJoin){
						ListAttributeJoin saj = (ListAttributeJoin) queryParameter.join().getJoins().get(aliasJoin);
						selectFields.add(saj.get(attribute));
					}
				}
			}
			
			criteriaQuery.multiselect(selectFields);
			
			if(queryParameter.getAddGroupByClauseForAllColumns()){
				criteriaQuery.groupBy(selectFields);
			}
		}
	}
}
