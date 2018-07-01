package com.simoncat.front.vo;

import com.simoncat.front.dto.EssayDto;
import com.simoncat.front.utils.EssayDateConvertor;
import com.simoncat.front.utils.EssayDateConvertor.EssayDate;

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

	public EssayAbstractVo(EssayDto dto) {
		this.id = dto.getId();
		this.title = dto.getTitle();
		this.author = dto.getAuthor();
		this.authorAvatar = dto.getAuthorAvatar();
		final EssayDate createAt = EssayDateConvertor.convertToMonth(dto.getCreateAt());
		this.createMonth = createAt.getMonth();
		this.createMonthSuffix = createAt.getMonthSuffix();
		this.createDay = createAt.getDay();
		this.createYear = createAt.getYear();
		this.comment = dto.getComment();
		this.heart = dto.getHeart();
		this.twitter = dto.getTwitter();
		this.facebook = dto.getFacebook();
		this.keyword = dto.getKeyword();
		this.description = dto.getDescription();
	}
}
