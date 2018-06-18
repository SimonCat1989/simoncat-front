package com.simoncat.front.service;

import com.simoncat.front.vo.EssayVo;
import com.simoncat.front.vo.SinglePageEssayListVo;

public interface EssayService {

    SinglePageEssayListVo loadAll();

    SinglePageEssayListVo loadAll(int page);
    
    EssayVo loadEssay(String essayId);
}
