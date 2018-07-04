package com.simoncat.front.vo;

import lombok.Getter;

import com.simoncat.front.dto.EssayCommentDto;

@Getter
public class EssayCommentVo {

    private final long bookId;
    private final String bookName;
    private final String bookAuthor;
    private final BookTypeVo bookType;
    private final String bookCover;
    private final String bookDescription;
    private final String comment;

    public EssayCommentVo(EssayCommentDto dto) {
        this.bookId = dto.getBook().getId();
        this.bookName = dto.getBook().getName();
        this.bookAuthor = dto.getBook().getAuthor();
        this.bookType = new BookTypeVo(dto.getBook().getType());
        this.bookCover = dto.getBook().getCover();
        this.bookDescription = dto.getBook().getDescription();
        this.comment = dto.getComment();
    }
}
