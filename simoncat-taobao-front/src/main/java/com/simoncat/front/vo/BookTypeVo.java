package com.simoncat.front.vo;

import lombok.Getter;

import com.simoncat.front.dto.BookTypeDto;

@Getter
public class BookTypeVo {

    private final long id;
    private final String type;

    public BookTypeVo(BookTypeDto dto) {
        this.id = dto.getId();
        this.type = dto.getType();
    }
}
