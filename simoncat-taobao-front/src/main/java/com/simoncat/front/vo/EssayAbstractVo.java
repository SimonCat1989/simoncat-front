package com.simoncat.front.vo;

import java.util.List;
import java.util.stream.Collectors;

import com.simoncat.front.dto.EssayCommentDto;
import com.simoncat.front.dto.EssayDto;

import lombok.Data;

@Data
public class EssayAbstractVo {

	private long id;
	private String title;
	private String author;
	private String authorAvatar;
	private String createMonth;
	private String createMonthSuffix;
	private String createDay;
	private String createYear;
	private Integer comment;
	private Integer heart;
	private Integer twitter;
	private Integer facebook;
	private String keyword;
	private String description;
	private List<BookAbstractVo> books;

	public EssayAbstractVo(EssayDto dto) {
        this.id = dto.getId();
        this.title = dto.getTitle();
        this.author = dto.getAuthor();
        this.authorAvatar = dto.getAuthorAvatar();
        this.createMonth = dto.getCreateMonth();
        this.createMonthSuffix = dto.getCreateMonthSuffix();
        this.createDay = dto.getCreateDay();
        this.createYear = dto.getCreateYear();
        this.comment = dto.getComment();
        this.heart = dto.getHeart();
        this.twitter = dto.getTwitter();
        this.facebook = dto.getFacebook();
        this.keyword = dto.getKeyword();
        this.description = dto.getDescription();
        this.books = dto.getEssayComments().stream().map(EssayCommentDto::getBook).map(BookAbstractVo::new).collect(Collectors.toList());
    }
}
