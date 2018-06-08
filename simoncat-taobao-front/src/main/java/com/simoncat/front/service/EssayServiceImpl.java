package com.simoncat.front.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.simoncat.front.dao.EssayDao;
import com.simoncat.front.vo.EssayListVo;

public class EssayServiceImpl implements EssayService {

    @Autowired
    private EssayDao essayDao;

    @Override
    public Optional<EssayListVo> loadAll() {
        return essayDao.loadAll();
    }

    @Override
    public Optional<EssayListVo> loadAll(int page) {
        return essayDao.loadAll(page);
    }

}
