package com.simoncat.front.service;

import java.util.Optional;

import com.simoncat.front.vo.EssayVo;
import com.simoncat.front.vo.SinglePageEssayListVo;

public interface EssayService {

    SinglePageEssayListVo loadAll(EssayListOrderType type);

    SinglePageEssayListVo loadAll(EssayListOrderType type, int page);
    
    Optional<EssayVo> loadEssay(long essayId);
}
