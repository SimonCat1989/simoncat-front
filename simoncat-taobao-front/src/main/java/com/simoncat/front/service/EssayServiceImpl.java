package com.simoncat.front.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.simoncat.front.dao.EssayDao;
import com.simoncat.front.vo.EssayVo;
import com.simoncat.front.vo.SinglePageEssayListVo;
import com.simoncat.front.vo.SinglePageEssayVo;

public class EssayServiceImpl implements EssayService {

    @Autowired
    private EssayDao essayDao;

    @Override
    public SinglePageEssayListVo loadAll() {
        return SinglePageEssayListVo.of(essayDao.getTotalCount(), 0,
                essayDao.loadAll().stream().map(SinglePageEssayVo::new).collect(Collectors.toList()));
    }

    @Override
    public SinglePageEssayListVo loadAll(int page) {
        return SinglePageEssayListVo.of(essayDao.getTotalCount(), page,
                essayDao.loadAll(page).stream().map(SinglePageEssayVo::new).collect(Collectors.toList()));
    }

    @Override
    public Optional<EssayVo> loadEssay(long essayId) {
        return essayDao.loadEssay(essayId).map(EssayVo::new);
    }
}
