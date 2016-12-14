package com.simoncat.front.graph;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.google.common.collect.Lists;
import com.simoncat.framework.excel.api.ExcelOperator;
import com.simoncat.framework.excel.api.Parameter;
import com.simoncat.front.vo.SourceDataWrapper;

@Slf4j
public class StationTopologyGraphGeneratorOld implements GraphGenerator {

	// All these positions are started from 0
	public static final int ROW_START = 1;
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

	private String folderPath;

	public StationTopologyGraphGeneratorOld() {
		this.folderPath = getClass().getClassLoader().getResource("data").getFile();
	}

	@Override
	public GraphOld generate() {
		List<SourceDataWrapper> datalist = prepareForData();
		GraphOld cableTopology = new GraphOld(datalist.size() / 2);
		cableTopology.init(datalist);
		return cableTopology;
	}

	private List<SourceDataWrapper> prepareForData() {
		return Arrays.asList(new File(this.folderPath).listFiles()).stream().map(this::getAllFileNames).filter(StringUtils::isNotEmpty)
				.map(fileName -> {
					Parameter excelParam = new Parameter(this.folderPath, fileName);
					// ExcelOperator operator = new ExcelOperatorImpl();
					List<SourceDataWrapper> datasource = Lists.newArrayList();
					// operator.operation(
					// excelParam,
					// document -> {
					// datasource.addAll(getAllSheets(document).stream().filter(Objects::nonNull).map(this::getAllRows)
					// .flatMap(rowList -> rowList.stream()).filter(Objects::nonNull).map(this::generateInstance)
					// .filter(Objects::nonNull).collect(Collectors.toList()));
					// });
					return datasource;
				}).reduce(Lists.newArrayList(), (finalList, currentList) -> {
					finalList.addAll(currentList);
					return finalList;
				});
	}

	private String getAllFileNames(File file) {
		return (file.isFile()) ? file.getName() : StringUtils.EMPTY;
	}

	private Collection<Sheet> getAllSheets(Workbook document) {
		return IntStream.range(0, document.getNumberOfSheets()).mapToObj(sheetPos -> document.getSheetAt(sheetPos)).collect(Collectors.toList());
	}

	private Collection<Row> getAllRows(Sheet sheet) {
		return IntStream.range(ROW_START, sheet.getPhysicalNumberOfRows()).mapToObj(rowPos -> sheet.getRow(rowPos)).collect(Collectors.toList());
	}

	private SourceDataWrapper generateInstance(Row currentRow) {
		Cell id = currentRow.getCell(COL_ID);
		Cell startSite = currentRow.getCell(COL_START_SITE_NAME);
		Cell nextSite = currentRow.getCell(COL_NEXT_SITE_NAME);
		Cell cableType = currentRow.getCell(COL_CABLE_TYPE);
		Cell cablePurpose = currentRow.getCell(COL_CABLE_PURPOSE);
		Cell route = currentRow.getCell(COL_ROUTE_NAME);
		Cell cableCountTotal = currentRow.getCell(COL_CABLE_COUNT_TOTAL);
		Cell cableCountAvailable = currentRow.getCell(COL_CABLE_COUNT_AVAILABLE);
		Cell cableCountBroken = currentRow.getCell(COL_CABLE_COUNT_BROKEN);
		Cell distance = currentRow.getCell(COL_DISTANCE);
		if (Objects.nonNull(id) && Objects.nonNull(startSite) && Objects.nonNull(nextSite) && Objects.nonNull(route)
				&& Objects.nonNull(cableCountTotal) && Objects.nonNull(cableCountAvailable) && Objects.nonNull(cableCountBroken)
				&& Objects.nonNull(distance)) {
			return new SourceDataWrapper("data.xls", currentRow.getSheet().getSheetName(), currentRow.getRowNum(), id.getNumericCellValue(),
					startSite.getStringCellValue(), nextSite.getStringCellValue(), cableType.getStringCellValue(), cablePurpose.getStringCellValue(),
					route.getStringCellValue(), cableCountTotal.getNumericCellValue(), cableCountAvailable.getNumericCellValue(),
					cableCountBroken.getNumericCellValue(), distance.getNumericCellValue());
		} else {
			log.warn(
					"Missing data detected! [ID: {}, Start Site: {}, Next Site: {}, Route: {}, Cable Total: {}, Cable Available: {}, Cable Broken: {}, Distance: {}]",
					id, startSite, nextSite, route, cableCountTotal, cableCountAvailable, cableCountBroken, distance);
			return null;
		}

	}

}
