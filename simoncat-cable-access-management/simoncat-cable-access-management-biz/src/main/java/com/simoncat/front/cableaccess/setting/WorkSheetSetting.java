package com.simoncat.front.cableaccess.setting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkSheetSetting {

	/**
	 * Please choose from "json", "excel" or "database"
	 */
	private WorkSheetDataSourceType dataSourceType = WorkSheetDataSourceType.JSON;

	private String jsonFileRootPath = "/home/simoncat/Develop-My/WorkSpace/test_data/";
	private String jsonWorkSheetFileName = "work_sheet.json";

	private String excelFileRootPath = "/home/simoncat/Develop-My/WorkSpace/test_data/";
	private String excelWorkSheetFileName = "work_sheet.xsl";
}
