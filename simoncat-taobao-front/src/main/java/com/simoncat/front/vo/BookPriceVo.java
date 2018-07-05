package com.simoncat.front.vo;

import lombok.Getter;

import com.simoncat.front.dto.BookPriceDto;

@Getter
public class BookPriceVo {

    private final long id;
    private final BookSellerVo seller;
    private final String advertisement;
    private final Double price;
    private final String link;

    public BookPriceVo(BookPriceDto dto) {
        this.id = dto.getId();
        this.seller = new BookSellerVo(dto.getSeller());
        this.advertisement = dto.getAdvertisement();
        this.price = dto.getPrice();
        this.link = dto.getLink();
    }
}
