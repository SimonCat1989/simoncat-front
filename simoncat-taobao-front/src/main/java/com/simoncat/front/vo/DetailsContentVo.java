package com.simoncat.front.vo;

import java.util.Collections;
import java.util.List;

import com.simoncat.front.dto.BookDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailsContentVo {

	public static final DetailsContentVo EMPTY = new DetailsContentVo("", "", "", "", "", "", "", 0, 0, 0, 0, "", "",
			"", Collections.emptyList());

	private final String title;
	private final String author;
	private final String authorAvatar;
	private final String createMonth;
	private final String createMonthSuffix;
	private final String createDay;
	private final String createYear;
	private final int comment;
	private final int heart;
	private final int twitter;
	private final int facebook;
	private final String image;
	private final String keyword;
	private final String description;
	private final List<BookDto> data;
}
