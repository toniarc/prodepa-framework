package br.gov.pa.prodepa.persistence.generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import br.gov.pa.prodepa.domain.Model;

public class JoinClause {

	private Map<String, RootJoin<? extends Model>> joins = new HashMap<String, RootJoin<? extends Model>>();
	private Map<String, Join<? extends Model, ? extends Model>> criteriaJoins = new HashMap<String, Join<? extends Model, ? extends Model>>();
	
	/**
	 * Este método adiciona um join a partir da entidade raiz, Ex: <br/>
	 * <b>select a from EntidadeA a join a.attributeNameEntidadeB joinAlias<b>
	 * @param otherClass representa a entidade que irá fazer a junção
	 * @param joinAlias apelido da junção
	 * @param joinAttributeName nome do atributo usado para realizar a junção
	 */
	public <Y extends Model> void innerJoin(Class<Y> otherClass, String joinAlias, String joinAttributeName){
		RootJoin<Y> rootJoin = new RootJoin<Y>(otherClass, joinAlias, joinAttributeName);
		joins.put(joinAlias, rootJoin);
	}
	
	public <X extends Model, Y extends Model> void innerJoin(Class<X> baseJoinClass, String baseJoinAlias, Class<Y> otherClass, String otherJoinAlias, String joinAttributeName){
		
	}

	public void build(Root<? extends Model> root){
		Iterator<Entry<String, RootJoin<? extends Model>>> it = joins.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<String, RootJoin<? extends Model>> pairs = it.next();
	        RootJoin<? extends Model> rj = pairs.getValue();
	        
	        buildJoinFromRoot(root, rj.getOtherClass(), rj.getJoinAlias(), rj.getJoinAttributeName());
	    }
	}
	
	private <T extends Model, Y extends Model> void buildJoinFromRoot(Root<T> root, Class<Y> otherClass, String alias, String attribute){
		Join<T, Y> join = root.join(attribute);
		criteriaJoins.put(alias, join);
	}
	
	public Map<String, Join<? extends Model, ? extends Model>> getJoins() {
		return criteriaJoins;
	}
}
