package com.simoncat.front.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.simoncat.front.dto.EssayDto;

@Slf4j
class EssayDaoImpl implements EssayDao {

    private static final String HQL_GET_TOTAL_COUNT = "select count(id) from EssayDto";
    private static final String HQL_GET_ESSAY_BY_CREATION_WITH_PAGE = "From EssayDto as essay order by essay.createAt desc";
    private static final String HQL_GET_ESSAY_BY_HOTEST_WITH_PAGE = "From EssayDto as essay order by essay.heart desc";
    private static final int PAGE_SIZE = 5;

    private List<EssayDto> doLoad(Session session, int firstResult, String queryCommand) {
        @SuppressWarnings("unchecked")
        Query<EssayDto> selectQuery = session.createQuery(queryCommand);
        selectQuery.setFirstResult(firstResult);
        selectQuery.setMaxResults(PAGE_SIZE);
        return selectQuery.list();
    }

    @Override
    public int getTotalCount(Session session) {
        return (int) Math.ceil(((Long) session.createQuery(HQL_GET_TOTAL_COUNT).uniqueResult()) / PAGE_SIZE);
    }

    @Override
    public Optional<EssayDto> loadEssay(Session session, long id) {
        try {
            return Optional.ofNullable(session.load(EssayDto.class, id));
        } catch (Exception e) {
            log.error("Failed to load Essay with id {}", id, e);
            return Optional.empty();
        }
    }

    @Override
    public List<EssayDto> loadAllByCreation(Session session) {
        return doLoad(session, 0, HQL_GET_ESSAY_BY_CREATION_WITH_PAGE);
    }

    @Override
    public List<EssayDto> loadAllByCreation(Session session, int page) {
        return (page >= 1) ? doLoad(session, (page - 1) * PAGE_SIZE, HQL_GET_ESSAY_BY_CREATION_WITH_PAGE) : Collections
                .emptyList();
    }

    @Override
    public List<EssayDto> loadAllByHostest(Session session) {
        return doLoad(session, 0, HQL_GET_ESSAY_BY_HOTEST_WITH_PAGE);
    }

    @Override
    public List<EssayDto> loadAllByHostest(Session session, int page) {
        return (page >= 1) ? doLoad(session, (page - 1) * PAGE_SIZE, HQL_GET_ESSAY_BY_HOTEST_WITH_PAGE) : Collections
                .emptyList();
    }
}
