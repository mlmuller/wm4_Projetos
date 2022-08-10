package br.com.gvdexport.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.gvdexport.model.Construcao;

public class DataServiceDao {
	
	@Inject
	private EntityManager em;
	public List<Construcao> getConstrucaoList(int start, int size, Map<String, Object> filters) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Construcao> criteriaQuery = cb.createQuery(Construcao.class);
		Root<Construcao> root = criteriaQuery.from(Construcao.class);
		CriteriaQuery<Construcao> select = criteriaQuery.select(root);

		if (filters != null && filters.size() > 0) {
			List<Predicate> predicates = new ArrayList<>();
			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				String field = entry.getKey();
				Object value = entry.getValue();
				if (value == null) {
					continue;
				}

				Expression<String> expr = root.get(field).as(String.class);
				Predicate p = cb.like(cb.lower(expr), "%" + value.toString().toLowerCase() + "%");
				predicates.add(p);
			}
			if (predicates.size() > 0) {
				criteriaQuery.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
			}
		}

		TypedQuery<Construcao> query = em.createQuery(select);
		query.setFirstResult(start);
		query.setMaxResults(size);
		List<Construcao> list = query.getResultList();
		return list;
	}

	public int getConstrucaoTotalCount() {
		Query query = em.createQuery("Select count(e.id) From Construcao e");
		return ((Long) query.getSingleResult()).intValue();
	}

	public int getFilteredRowCount(Map<String, Object> filters) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
		Root<Construcao> root = criteriaQuery.from(Construcao.class);
		CriteriaQuery<Long> select = criteriaQuery.select(cb.count(root));

		if (filters != null && filters.size() > 0) {
			List<Predicate> predicates = new ArrayList<>();
			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				String field = entry.getKey();
				Object value = entry.getValue();
				if (value == null) {
					continue;
				}

				Expression<String> expr = root.get(field).as(String.class);
				Predicate p = cb.like(cb.lower(expr), "%" + value.toString().toLowerCase() + "%");
				predicates.add(p);
			}
			if (predicates.size() > 0) {
				criteriaQuery.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
			}
		}
		Long count = em.createQuery(select).getSingleResult();
		return count.intValue();
	}

}
