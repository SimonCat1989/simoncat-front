package com.simoncat.front.operator;


public class CableTopologyOperator {

	public static final int COL_ID = 0;
	public static final int COL_START_SITE_NAME = 1;
	public static final int COL_NEXT_SITE_NAME = 2;
	public static final int COL_CABLE_TYPE = 3;
	public static final int COL_CABLE_PURPOSE = 4;
	public static final int COL_ROUTE_NAME = 5;
	public static final int COL_CABLE_COUNT_TOTAL = 6;
	public static final int COL_CABLE_COUNT_AVAILABLE = 7;
	public static final int COL_CABLE_COUNT_BROKEN = 8;
	public static final int COL_DISTANCE = 9;

	public void update(String fileName, String sheetName, int rowPos, String startSiteName, String endSiteName, String name, String cableType,
			String cablePurpose, int totalCableCount, int usedCableCount, int brokenCableCount, double distance) {
		// String folderName = getClass().getClassLoader().getResource("data").getFile();
		// Parameter excelParam = new Parameter(folderName, fileName);
		// ExcelOperator operator = new ExcelOperatorImpl();
		// operator.update(excelParam, document -> {
		// Sheet sheet = document.getSheet(sheetName);
		// Row row = sheet.getRow(rowPos);
		// row.getCell(COL_START_SITE_NAME).setCellValue(startSiteName);
		// row.getCell(COL_NEXT_SITE_NAME).setCellValue(endSiteName);
		// row.getCell(COL_CABLE_TYPE).setCellValue(cableType);
		// row.getCell(COL_CABLE_PURPOSE).setCellValue(cablePurpose);
		// row.getCell(COL_ROUTE_NAME).setCellValue(name);
		// row.getCell(COL_CABLE_COUNT_TOTAL).setCellValue(totalCableCount);
		// row.getCell(COL_CABLE_COUNT_AVAILABLE).setCellValue(usedCableCount);
		// row.getCell(COL_CABLE_COUNT_BROKEN).setCellValue(brokenCableCount);
		// row.getCell(COL_DISTANCE).setCellValue(distance);
		// });
	}

	public void delete(String fileName, String sheetName, int rowPos) {
		// String folderName = getClass().getClassLoader().getResource("data").getFile();
		// Parameter excelParam = new Parameter(folderName, fileName);
		// ExcelOperator operator = new ExcelOperatorImpl();
		// operator.update(excelParam, document -> {
		// Sheet sheet = document.getSheet(sheetName);
		// Row row = sheet.getRow(rowPos);
		// sheet.removeRow(row);
		// });
	}
}
