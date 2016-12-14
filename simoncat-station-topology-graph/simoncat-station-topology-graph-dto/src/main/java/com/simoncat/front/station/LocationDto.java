package com.simoncat.front.station;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.simoncat.framework.annotation.excel.ExcelCellMapping;
import com.simoncat.framework.annotation.excel.ExcelCellMapping.Type;
import com.simoncat.framework.annotation.excel.TargetSheets;

@Data
@AllArgsConstructor
@TargetSheets("0")
public class LocationDto {

	@ExcelCellMapping(index = 1, type = Type.STRING, nameRow = 0)
	private String stationName;

	@ExcelCellMapping(index = 2, type = Type.NUMERIC, nameRow = 0)
	private double longitude;

	@ExcelCellMapping(index = 3, type = Type.NUMERIC, nameRow = 0)
	private double latitude;
}
