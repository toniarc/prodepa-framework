package br.gov.pa.prodepa.persistence.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import br.gov.pa.prodepa.domain.Model;

public class OrderByClause extends Clause {

	private List<OrderBy> orderByFields = new ArrayList<OrderBy>();
	
	public void asc(String attribute){
		orderByFields.add(new OrderBy(OrderByType.ASC, attribute));
	}
	
	public void desc(String attribute){
		orderByFields.add(new OrderBy(OrderByType.DESC, attribute));
	}

	public void build(CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery, Root<? extends Model> root, Map<String, Join<? extends Model, ? extends Model>> joins) {

		if (orderByFields == null) {
			return;
		}
		
		List<Order> jpaOrders = new ArrayList<Order>();
		
		for (OrderBy order : orderByFields) {
			
			Expression<?> expression = getExpression(root, joins, order.getAttribute(), order.getAttribute().getClass());
			
			if(order.getOrderByType().equals(OrderByType.ASC)){
				jpaOrders.add(criteriaBuilder.asc(expression));
			} else {
				jpaOrders.add(criteriaBuilder.desc(expression));
			}
		}
		
		criteriaQuery.orderBy(jpaOrders);
	}

}
