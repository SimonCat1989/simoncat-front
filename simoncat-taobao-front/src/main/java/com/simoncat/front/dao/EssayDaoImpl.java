package com.simoncat.front.dao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.simoncat.front.dto.EssayDto;
import com.simoncat.front.vo.EssayAbstractVo;
import com.simoncat.front.vo.EssayListVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class EssayDaoImpl implements EssayDao {

	private static final String HQL_GET_TOTAL_COUNT = "select count(e.id) from essay e";
	private static final int PAGE_SIZE = 5;

	@Override
	public Optional<EssayListVo> loadAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Integer countResults = (Integer) session.createQuery(HQL_GET_TOTAL_COUNT).uniqueResult();
			if (Objects.nonNull(countResults)) {
				@SuppressWarnings("unchecked")
				Query<EssayDto> selectQuery = session.createQuery("From essay");
				selectQuery.setFirstResult(0);
				selectQuery.setMaxResults(PAGE_SIZE);
				List<EssayAbstractVo> essayList = selectQuery.list().stream().map(EssayAbstractVo::new)
						.collect(Collectors.toList());
				return Optional.of(new EssayListVo((int) Math.ceil(countResults / PAGE_SIZE), 1, essayList));
			} else {
				log.error("Found 0 row from table Essay.");
			}
			return Optional.empty();
		}
	}

	@Override
	public Optional<EssayListVo> loadAll(int page) {
		if (page >= 1) {
			final int firstCount = (page - 1) * PAGE_SIZE;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				Integer countResults = (Integer) session.createQuery(HQL_GET_TOTAL_COUNT).uniqueResult();
				if (Objects.nonNull(countResults) && firstCount < countResults) {
					@SuppressWarnings("unchecked")
					Query<EssayDto> selectQuery = session.createQuery("From essay");
					selectQuery.setFirstResult(firstCount);
					selectQuery.setMaxResults(PAGE_SIZE);
					List<EssayAbstractVo> essayList = selectQuery.list().stream().map(EssayAbstractVo::new)
							.collect(Collectors.toList());
					return Optional.of(new EssayListVo((int) Math.ceil(countResults / PAGE_SIZE), page, essayList));
				} else {
					log.error("Found 0 row from table Essay.");
				}
			}
		}
		return Optional.empty();
	}
}
