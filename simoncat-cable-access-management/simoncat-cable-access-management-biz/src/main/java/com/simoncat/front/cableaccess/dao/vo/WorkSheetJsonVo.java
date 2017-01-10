package com.simoncat.front.cableaccess.dao.vo;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.simoncat.front.cableaccess.dto.WorkSheetDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkSheetJsonVo {

	private Collection<WorkSheetDto> sheets;
}
