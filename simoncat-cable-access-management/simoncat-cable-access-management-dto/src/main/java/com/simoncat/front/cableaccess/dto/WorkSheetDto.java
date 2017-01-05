package com.simoncat.front.cableaccess.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkSheetDto {

	private final boolean plugMode;
	private final String group;
	private final String id;
	private final String title;
	private final String userKind;
	private final Date deadline;
	private final String channelKind;
	private final int status;
	private final List<StationDto> stations;
}
