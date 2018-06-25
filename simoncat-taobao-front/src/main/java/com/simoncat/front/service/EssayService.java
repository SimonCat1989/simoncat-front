package com.simoncat.front.service;

import java.util.Optional;

import com.simoncat.front.vo.EssayVo;
import com.simoncat.front.vo.SinglePageEssayListVo;

public interface EssayService {

    SinglePageEssayListVo loadAll();

    SinglePageEssayListVo loadAll(int page);
    
    Optional<EssayVo> loadEssay(long essayId);
}
