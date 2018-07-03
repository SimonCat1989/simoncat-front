package com.simoncat.front.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.simoncat.front.dto.EssayDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class EssayDaoImpl implements EssayDao {

	private static final String HQL_GET_TOTAL_COUNT = "select count(id) from EssayDto";
	private static final String HQL_GET_ESSAY_BY_CREATION_WITH_PAGE = "From EssayDto as essay order by essay.createAt desc";
	private static final String HQL_GET_ESSAY_BY_HOTEST_WITH_PAGE = "From EssayDto as essay order by essay.heart desc";
	private static final int PAGE_SIZE = 5;

	private List<EssayDto> doLoad(int firstResult, String queryCommand) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		Query<EssayDto> selectQuery = session.createQuery(queryCommand);
		selectQuery.setFirstResult(firstResult);
		selectQuery.setMaxResults(PAGE_SIZE);
		return selectQuery.list();
	}

	@Override
	public int getTotalCount() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (int) Math.ceil(((Long) session.createQuery(HQL_GET_TOTAL_COUNT).uniqueResult()) / PAGE_SIZE);
	}

	@Override
	public Optional<EssayDto> loadEssay(long id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			return Optional.ofNullable(session.load(EssayDto.class, id));
		} catch (Exception e) {
			log.error("Failed to load Essay with id {}", id, e);
			return Optional.empty();
		}
	}

	@Override
	public List<EssayDto> loadAllByCreation() {
		return doLoad(0, HQL_GET_ESSAY_BY_CREATION_WITH_PAGE);
	}

	@Override
	public List<EssayDto> loadAllByCreation(int page) {
		return (page >= 1) ? doLoad((page - 1) * PAGE_SIZE, HQL_GET_ESSAY_BY_CREATION_WITH_PAGE)
				: Collections.emptyList();
	}

	@Override
	public List<EssayDto> loadAllByHostest() {
		return doLoad(0, HQL_GET_ESSAY_BY_HOTEST_WITH_PAGE);
	}

	@Override
	public List<EssayDto> loadAllByHostest(int page) {
		return (page >= 1) ? doLoad((page - 1) * PAGE_SIZE, HQL_GET_ESSAY_BY_HOTEST_WITH_PAGE)
				: Collections.emptyList();
	}
}
