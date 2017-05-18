package br.gov.pa.prodepa.persistence.querybuilder.select;

import br.gov.pa.prodepa.persistence.querybuilder.groupby.GroupByExpression;

public class Column implements SelectExpression, GroupByExpression {

	String columnName;
	
	public Column(String columnName) {
		this.columnName = columnName;
	}

	public void buildHql(StringBuilder hql) {
		hql.append(this.columnName);
	}
	
	public static Column column(String columnName){
		return new Column(columnName);
	}
	
	public static Column[] columns(String... columnNames){
		
		Column[] columns = new Column[columnNames.length];
		
		for(int i=0; i<columnNames.length;i++){
			columns[i] = new Column(columnNames[i]);
		}
		
		return columns;
	}

}
