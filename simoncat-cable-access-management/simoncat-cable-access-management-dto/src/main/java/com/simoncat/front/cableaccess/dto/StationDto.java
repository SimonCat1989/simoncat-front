package com.simoncat.front.cableaccess.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationDto {

	private String name;
	private ConnectionDto prev;
	private ConnectionDto next;
}
