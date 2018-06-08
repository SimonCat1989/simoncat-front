package com.simoncat.front.service;

import java.util.Optional;

import com.simoncat.front.vo.EssayListVo;

public interface EssayService {

    Optional<EssayListVo> loadAll();

    Optional<EssayListVo> loadAll(int page);
}
