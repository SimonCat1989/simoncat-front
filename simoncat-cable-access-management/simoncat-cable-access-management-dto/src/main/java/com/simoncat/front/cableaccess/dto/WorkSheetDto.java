package com.simoncat.front.cableaccess.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkSheetDto {

	private boolean plugMode;
	private String group;
	private String id;
	private String title;
	private String userKind;
	private Date deadline;
	private String channelKind;
	private int status;
	private List<StationDto> stations;

}
