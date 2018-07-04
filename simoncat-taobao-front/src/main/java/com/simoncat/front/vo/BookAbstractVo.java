package com.simoncat.front.vo;

import lombok.Getter;

import com.simoncat.front.dto.BookDto;

@Getter
public class BookAbstractVo {

    private final long id;
    private final String name;
    private final String cover;
    private final String author;

    public BookAbstractVo(BookDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.cover = dto.getCover();
        this.author = dto.getAuthor();
    }
}
