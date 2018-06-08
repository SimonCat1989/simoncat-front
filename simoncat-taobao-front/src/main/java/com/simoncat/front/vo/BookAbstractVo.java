package com.simoncat.front.vo;

import lombok.Data;

import com.simoncat.front.dto.BookDto;

@Data
public class BookAbstractVo {

    private String name;
    private String cover;

    public BookAbstractVo(BookDto dto) {
        this.name = dto.getName();
        this.cover = dto.getCover();
    }
}
