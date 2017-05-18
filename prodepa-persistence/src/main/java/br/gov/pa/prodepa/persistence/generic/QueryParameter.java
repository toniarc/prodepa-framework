package br.gov.pa.prodepa.persistence.generic;


/**
 * 
 * @author antonio_junior
 *
 * @param <T> AS consutas retornarão uma lista/objeto desse tipo
 */

public class QueryParameter  {
	
	private String[] lazyFieldToLoad;
	
	private SelectClause select = new SelectClause();
	
	private WhereClause where = new WhereClause();

	private JoinClause join = new JoinClause();
	
	private OrderByClause orderBy = new OrderByClause(); 
	
	private Integer firstResult;
	
	private Integer maxResult;

	private boolean addGroupByClauseForAllColumns;

//	@SuppressWarnings("unchecked")
//	public <FROM extends Model, RETURN> List<RETURN> findAll(FROM entityExample, Class<RETURN> returnType) throws Exception{
//		
//		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
//		
//		CriteriaQuery<RETURN> criteriaQuery = (CriteriaQuery<RETURN>) criteriaBuilder.createQuery(returnType);
//
//		Root<FROM> root = (Root<FROM>) criteriaQuery.from(entityExample.getClass());
//		
//		Expression<RETURN> expression;
//		for(String column : select.getColumns()){
//			expression = root.get(column);
//			criteriaQuery.select(expression);
//		}
//		
//		join.build(root);
//		
//		fetchLazyFields(root);
//		
//		where().build(entityExample, criteriaBuilder, root, criteriaQuery, join.getJoins());
//		
//		orderBy.build(criteriaBuilder, criteriaQuery, root);
//		
//		TypedQuery<RETURN> q = getEntityManager().createQuery(criteriaQuery);
//		
//		return q.getResultList();
//	}
//	
//	@SuppressWarnings("unchecked")
//	public <T extends Model> List<T> findAll(T entityExample) throws Exception{
//		
//		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
//		
//		CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(entityExample.getClass());
//
//		Root<T> root = (Root<T>) criteriaQuery.from(entityExample.getClass());
//		
//		criteriaQuery.select(root);
//		
//		join.build(root);
//		
//		fetchLazyFields(root);
//		
//		where().build(entityExample, criteriaBuilder, root, criteriaQuery, join.getJoins());
//		
//		orderBy.build(criteriaBuilder, criteriaQuery, root);
//		
//		TypedQuery<T> q = getEntityManager().createQuery(criteriaQuery);
//		
//		return q.getResultList();
//	}

	public void addGroupByClauseForAllColumns(){
		this.addGroupByClauseForAllColumns = true;
	}
	
	public String[] getLazyFieldToLoad() {
		return lazyFieldToLoad;
	}
	
	public void fieldToLoad(String... fields){
		lazyFieldToLoad = fields;
	}
	
	public SelectClause select() {
		return select;
	}
	
	public WhereClause where() {
		return where;
	}
	
	public JoinClause join(){
		return join;
	}
	
	public OrderByClause orderBy() {
		return orderBy;
	}

	public Integer getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}

	public Integer getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}

	public boolean getAddGroupByClauseForAllColumns() {
		return addGroupByClauseForAllColumns;
	}

	public void setAddGroupByClauseForAllColumns(
			boolean addGroupByClauseForAllColumns) {
		this.addGroupByClauseForAllColumns = addGroupByClauseForAllColumns;
	}

}
