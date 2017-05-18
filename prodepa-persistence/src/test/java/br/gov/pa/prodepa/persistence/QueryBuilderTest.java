package br.gov.pa.prodepa.persistence;

import static br.gov.pa.prodepa.persistence.querybuilder.from.FromClause.innerJoin;
import static br.gov.pa.prodepa.persistence.querybuilder.from.FromClause.leftJoin;
import static br.gov.pa.prodepa.persistence.querybuilder.orderby.OrderByClause.asc;
import static br.gov.pa.prodepa.persistence.querybuilder.orderby.OrderByClause.desc;
import static br.gov.pa.prodepa.persistence.querybuilder.where.WhereClause.and;
import static br.gov.pa.prodepa.persistence.querybuilder.where.WhereClause.eq;
import static br.gov.pa.prodepa.persistence.querybuilder.where.WhereClause.or;

import org.junit.Test;

import br.gov.pa.prodepa.persistence.querybuilder.QueryBuilder;
import br.gov.pa.prodepa.persistence.querybuilder.select.Column;

public class QueryBuilderTest {

	/**
	 * public List<EntityTest> buscarEntdades() {
	 * 
	 *    StringBuilder hql = new StringBuilder(); 
	 *    hql.append(" select teste1, teste2, teste3 ");
	 *    hql.append(" from EntityTest et ");
	 *    hql.append(" inner join et.atributoJoin1 aj1 ");
	 *    hql.append(" left join et.atributoJoin2 aj2 ");
	 *    hql.append(" where 1=1 ");
	 * 
	 *    hql.append(" ( ") //inicio do bloco AND
	 * 
	 *    if(atributo1 != null){
	 *       hql.append(" et.atributo1 = :valor1 and ");
	 *    }
	 *    
	 *    if(atributo2 != null){
	 *       hql.append(" et.atributo2 = :valor2 and ");
	 *    }
	 *    
	 *    hql.append(" ( ") //inicio do bloco OR
	 *    
	 *    if(atributo3 != null){
	 *       hql.append(" et.atributo3 = :valor3 or ");
	 *    }
	 *    
	 *    if(atributo4 != null){
	 *       hql.append(" et.atributo4 = :valor4 ");
	 *    }
	 *    
	 *    hql.append(" ) ") //fim do bloco OR
	 *    
	 *    hql.append(" ) ") //fim do bloco AND
	 * 
	 *    Query q = em.createQuery(hql.toString());
	 * 
	 *    if(atributo1 != null){
	 *       q.setParameter("valor1", atributo1);
	 *    }
	 * 
	 * 	  if(atributo2 != null){
	 *       q.setParameter("valor2", atributo2);
	 *    }
	 *    
	 *    if(atributo3 != null){
	 *       q.setParameter("valor3", atributo3);
	 *    }
	 *    
	 *    if(atributo4 != null){
	 *       q.setParameter("valor4", atributo4);
	 *    }
	 * 
	 *    return q.getResultList();
	 * }
	 */
	@Test
	public void testeInicial(){
		String hql = new QueryBuilder()
			.select(Column.columns("teste1", "teste2", "teste3"))
			.from(
				EntityTest.class, "et",
				innerJoin("et", "atributoJoin1", "aj1"),
				leftJoin("et", "atributoJoin1", "aj2")
			)
			.where(
				and(
					eq("et.atributo1", new Object()), 
					eq("et.atributo2", new Object()),
					or(
						eq("et.atributo3", 1),
						eq("et.atributo4", 2)
					)
				)
			)
			.groupBy(Column.columns("teste1", "teste2", "teste3"))
			.orderBy(asc("et.atributo1"), desc("et.atributo2"))
			.build();
		
		System.out.println(hql);
	}
}
