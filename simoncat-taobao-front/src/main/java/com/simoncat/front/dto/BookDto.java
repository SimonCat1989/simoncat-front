package com.simoncat.front.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {

	private final String name;
	private final String author;
	private final String image;
	private final String content;
}
