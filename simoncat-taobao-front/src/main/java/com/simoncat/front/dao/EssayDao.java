package com.simoncat.front.dao;

import java.util.Optional;

import com.simoncat.front.vo.EssayListVo;

public interface EssayDao {

    Optional<EssayListVo> loadAll();

    Optional<EssayListVo> loadAll(int page);
}
