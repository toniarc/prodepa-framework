package br.gov.pa.prodepa.persistence.generic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;

import br.gov.pa.prodepa.domain.Model;
import br.gov.pa.prodepa.util.ReflectionUtils;

public class WhereClause extends Clause {

	private List<Restriction> restrictions = new ArrayList<Restriction>();
	
	private List<Predicate> predicates = new ArrayList<Predicate>();
	
	public void notEqual(String attribute, Object value){
		restrictions.add(new Restriction(Operator.NOT_EQUAL, attribute, value));
	}
	
	public void equal(String attribute, Object value){
		restrictions.add(new Restriction(Operator.EQUAL, attribute, value));
	}
	
	public void in(String attribute, List<?> value) {
		restrictions.add(new Restriction(Operator.IN, attribute, value));
	}
	
	public void between(String attribute, Object start, Object end) {
		restrictions.add(new Restriction(Operator.BETWEEN, attribute, start, end));
	}

	public void build(Object entityExample, CriteriaBuilder criteriaBuilder, Root<? extends Model> root, CriteriaQuery<?> criteriaQuery, Map<String, Join<? extends Model, ? extends Model>> joins) throws Exception{
		
		createPredicatesByExample(entityExample, criteriaBuilder, root);
		
		createPredicates(criteriaBuilder, root, joins);
		
		criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
	}

	private void createPredicates(CriteriaBuilder criteriaBuilder, Root<? extends Model> root, Map<String, Join<? extends Model, ? extends Model>> joins) throws Exception {
		for(Restriction r : restrictions){
			
			if(r.getValue() == null){
				continue;
			}
			
			createPredicate(criteriaBuilder, root, joins, r, r.getValue().getClass());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private <T> void createPredicate(CriteriaBuilder criteriaBuilder, Root<? extends Model> root, Map<String, Join<? extends Model, ? extends Model>> joins, Restriction r, Class<T> valueClass) throws Exception {
		Expression<T> expression = getExpression(root, joins, r.getAttribute(), valueClass);
		
		if(r.getOperator().equals(Operator.NOT_EQUAL)){
			if(r.getValue() instanceof String){
				predicates.add(criteriaBuilder.notEqual(criteriaBuilder.lower((Expression<String>)expression), ((String)r.getValue()).toLowerCase()));
			} else {
				predicates.add(criteriaBuilder.notEqual(expression,r.getValue()));
			}
		}
		
		if(r.getOperator().equals(Operator.EQUAL)){
			if(r.getValue() instanceof String){
				predicates.add(criteriaBuilder.equal(criteriaBuilder.lower((Expression<String>)expression), ((String)r.getValue()).toLowerCase()));
			} else {
				predicates.add(criteriaBuilder.equal(expression,r.getValue()));
			}
		}
		
		if(r.getOperator().equals(Operator.IN)){
			predicates.add(expression.in(r.getValue()));
		}
		
		if(r.getOperator().equals(Operator.BETWEEN)){
			if(!(r.getValue() instanceof Comparable<?>)){
				throw new Exception("O operador 'between' só é aplicado para objetos que extendam a interface Comparable.");
			} else {
				Path<Comparable<T>> path = (Path<Comparable<T>>) expression;
				predicates.add(criteriaBuilder.between(path, (Comparable)r.getValue(), (Comparable)r.getOtherValue()));
			}
		}
		
	}

	private void createPredicatesByExample(Object entityExample, CriteriaBuilder criteriaBuilder, Root<? extends Model> root) throws Exception {
		List<Field> fields = ReflectionUtils.getNonStaticFields(entityExample.getClass());
		for(Field f : fields) {
			f.setAccessible(true);
			Object value = f.get(entityExample);
			if(value != null){
				
				//verifica se o atributo é transiente
				Method method = entityExample.getClass().getMethod("get" + StringUtils.capitalize(f.getName()));
				if(method.isAnnotationPresent(Transient.class)){
					continue;
				}
				
				if(value instanceof Model && ((Model)value).getId() != null ){
					predicates.add(criteriaBuilder.equal(root.get(f.getName()),value));
					continue;
				}
				
				if(value instanceof Integer 
						|| value instanceof Long
						|| value instanceof Double
						|| value instanceof Boolean
						|| value instanceof Date
						|| value instanceof Enum
						|| value instanceof BigDecimal
						|| value instanceof BigInteger) {
					predicates.add(criteriaBuilder.equal(root.get(f.getName()),value));
					continue;
				}
				
				if((value instanceof String && ((String)value).trim().length() > 0)){
					predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.<String>get(f.getName())), "%" + ((String)value).toLowerCase() + "%" ));
					continue;
				}
				
				System.out.println("O atributo " + f.getName() + " foi ignorado");
			}
		}
	}

}
