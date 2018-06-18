package com.simoncat.front.vo;

import java.util.List;
import java.util.stream.Collectors;

import com.simoncat.front.dto.EssayCommentDto;
import com.simoncat.front.dto.EssayDto;

import lombok.Getter;

@Getter
public class SinglePageEssayVo {

	private final EssayAbstractVo essay;
	private final List<BookAbstractVo> books;

	public SinglePageEssayVo(EssayDto dto) {
		this.essay = new EssayAbstractVo(dto);
		this.books = dto.getEssayComments().stream().map(EssayCommentDto::getBook).map(BookAbstractVo::new)
				.collect(Collectors.toList());
	}

	public String getAuthor() {
		return essay.getAuthor();
	}

	public String getAuthorAvatar() {
		return essay.getAuthorAvatar();
	}

	public Integer getComment() {
		return essay.getComment();
	}

	public String getCreateDay() {
		return essay.getCreateDay();
	}

	public String getCreateMonth() {
		return essay.getCreateMonth();
	}

	public String getCreateMonthSuffix() {
		return essay.getCreateMonthSuffix();
	}

	public String getCreateYear() {
		return essay.getCreateYear();
	}

	public String getDescription() {
		return essay.getDescription();
	}

	public Integer getFacebook() {
		return essay.getFacebook();
	}

	public Integer getHeart() {
		return essay.getHeart();
	}

	public long getId() {
		return essay.getId();
	}

	public String getKeyword() {
		return essay.getKeyword();
	}

	public String getTitle() {
		return essay.getTitle();
	}

	public Integer getTwitter() {
		return essay.getTwitter();
	}
}
