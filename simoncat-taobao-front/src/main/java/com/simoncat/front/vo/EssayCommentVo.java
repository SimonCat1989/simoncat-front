package com.simoncat.front.vo;

import java.util.Set;
import java.util.stream.Collectors;

import lombok.Getter;

import com.simoncat.front.dto.BookPriceDto;
import com.simoncat.front.dto.EssayCommentDto;

@Getter
public class EssayCommentVo {

    private final long bookId;
    private final String bookName;
    private final String bookAuthor;
    private final BookTypeVo bookType;
    private final String bookCover;
    private final String bookDescription;
    private final double bookCheapestPrice;
    private final Set<BookPriceVo> bookPrices;
    private final String comment;

    public EssayCommentVo(EssayCommentDto dto) {
        this.bookId = dto.getBook().getId();
        this.bookName = dto.getBook().getName();
        this.bookAuthor = dto.getBook().getAuthor();
        this.bookType = new BookTypeVo(dto.getBook().getType());
        this.bookCover = dto.getBook().getCover();
        this.bookDescription = dto.getBook().getDescription();
        this.bookCheapestPrice = dto.getBook().getPrices().stream().map(BookPriceDto::getPrice)
                .mapToDouble(Double::doubleValue).min().orElse(0.0);
        this.bookPrices = dto.getBook().getPrices().stream().map(BookPriceVo::new).collect(Collectors.toSet());
        this.comment = dto.getComment();
    }
}
