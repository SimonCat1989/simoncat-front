package com.simoncat.front.vo;

import com.simoncat.front.dto.EssayDto;

import lombok.Getter;

@Getter
public class EssayVo {

	private final EssayAbstractVo essay;

    public EssayVo(EssayDto dto) {
        this.essay = new EssayAbstractVo(dto);
    }
}
