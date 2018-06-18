package com.simoncat.front.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.simoncat.front.dto.EssayDto;

class EssayDaoImpl implements EssayDao {

	private static final String HQL_GET_TOTAL_COUNT = "select count(id) from EssayDto";
	private static final String HQL_GET_ESSAY_WITH_PAGE = "From EssayDto";
	private static final int PAGE_SIZE = 5;

	@Override
	public List<EssayDto> loadAll() {
		return doLoad(0);
	}

	@Override
	public List<EssayDto> loadAll(int page) {
		return (page >= 1) ? doLoad((page - 1) * PAGE_SIZE) : Collections.emptyList();
	}

	private List<EssayDto> doLoad(int firstResult) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			@SuppressWarnings("unchecked")
			Query<EssayDto> selectQuery = session.createQuery(HQL_GET_ESSAY_WITH_PAGE);
			selectQuery.setFirstResult(firstResult);
			selectQuery.setMaxResults(PAGE_SIZE);
			return selectQuery.list();
		}
	}

	@Override
	public int getTotalCount() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (int) Math.ceil(((Long) session.createQuery(HQL_GET_TOTAL_COUNT).uniqueResult()) / PAGE_SIZE);
		}
	}
}
