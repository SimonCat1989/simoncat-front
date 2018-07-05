package com.simoncat.front.vo;

import lombok.Getter;

import com.simoncat.front.dto.BookSellerDto;

@Getter
public class BookSellerVo {

    private final long id;
    private final String name;

    public BookSellerVo(BookSellerDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
    }
}
