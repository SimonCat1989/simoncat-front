package com.simoncat.front.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.simoncat.front.dao.EssayDao;
import com.simoncat.front.utils.HibernateUtil;
import com.simoncat.front.vo.EssayVo;
import com.simoncat.front.vo.SinglePageEssayListVo;
import com.simoncat.front.vo.SinglePageEssayVo;

public class EssayServiceImpl implements EssayService {

    @Autowired
    private EssayDao essayDao;

    @Override
    public SinglePageEssayListVo loadAll(EssayListOrderType type) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            switch (type) {
            case BY_CREATION:
                return SinglePageEssayListVo.of(essayDao.getTotalCount(session), 1, essayDao.loadAllByCreation(session)
                        .stream().map(SinglePageEssayVo::new).collect(Collectors.toList()));
            case BY_HEART:
                return SinglePageEssayListVo.of(essayDao.getTotalCount(session), 1, essayDao.loadAllByCreation(session)
                        .stream().map(SinglePageEssayVo::new).collect(Collectors.toList()));
            default:
                return SinglePageEssayListVo.of(essayDao.getTotalCount(session), 1, essayDao.loadAllByHostest(session)
                        .stream().map(SinglePageEssayVo::new).collect(Collectors.toList()));
            }
        }
    }

    @Override
    public SinglePageEssayListVo loadAll(EssayListOrderType type, int page) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            switch (type) {
            case BY_CREATION:
                return SinglePageEssayListVo.of(
                        essayDao.getTotalCount(session),
                        page,
                        essayDao.loadAllByCreation(session, page).stream().map(SinglePageEssayVo::new)
                                .collect(Collectors.toList()));
            case BY_HEART:
                return SinglePageEssayListVo.of(
                        essayDao.getTotalCount(session),
                        page,
                        essayDao.loadAllByCreation(session, page).stream().map(SinglePageEssayVo::new)
                                .collect(Collectors.toList()));
            default:
                return SinglePageEssayListVo.of(
                        essayDao.getTotalCount(session),
                        page,
                        essayDao.loadAllByHostest(session, page).stream().map(SinglePageEssayVo::new)
                                .collect(Collectors.toList()));
            }
        }
    }

    @Override
    public Optional<EssayVo> loadEssay(long essayId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return essayDao.loadEssay(session, essayId).map(EssayVo::new);
        }
    }
}
