package com.simoncat.front.cableaccess.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StationDto {

	private final String name;
	private final ConnectionDto prev;
	private final ConnectionDto next;
}
