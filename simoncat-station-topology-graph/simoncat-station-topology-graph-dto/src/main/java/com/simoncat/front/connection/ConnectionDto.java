package com.simoncat.front.connection;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.simoncat.framework.annotation.excel.ExcelCellMapping;
import com.simoncat.framework.annotation.excel.ExcelCellMapping.Type;
import com.simoncat.framework.annotation.excel.TargetSheets;
import com.simoncat.framework.annotation.excel.ExcelMetaAnnotation;
import com.simoncat.framework.excel.meta.ExcelMeta;

@Data
@AllArgsConstructor
@TargetSheets
public class ConnectionDto {

	@ExcelMetaAnnotation
	private ExcelMeta excelMeta;

	@ExcelCellMapping(index = 0, type = Type.NUMERIC, nameRow = 0)
	private double id;

	@ExcelCellMapping(index = 1, type = Type.STRING, nameRow = 0)
	private String startStationName;

	@ExcelCellMapping(index = 2, type = Type.STRING, nameRow = 0)
	private String nextStationName;

	@ExcelCellMapping(index = 3, type = Type.STRING, nameRow = 0)
	private String connectionType;

	@ExcelCellMapping(index = 4, type = Type.STRING, nameRow = 0)
	private String connectionPurpose;

	@ExcelCellMapping(index = 5, type = Type.STRING, nameRow = 0)
	private String connectionName;

	@ExcelCellMapping(index = 6, type = Type.NUMERIC, nameRow = 0)
	private double totalConnections;

	@ExcelCellMapping(index = 7, type = Type.NUMERIC, nameRow = 0)
	private double availableConnections;

	@ExcelCellMapping(index = 8, type = Type.NUMERIC, nameRow = 0)
	private double brokenConnections;

	@ExcelCellMapping(index = 9, type = Type.NUMERIC, nameRow = 0)
	private double connectionLength;

	public int getTotalConnections() {
		return (int) totalConnections;
	}

	public int getAvailableConnections() {
		return (int) availableConnections;
	}

	public int getBrokenConnections() {
		return (int) brokenConnections;
	}
}
