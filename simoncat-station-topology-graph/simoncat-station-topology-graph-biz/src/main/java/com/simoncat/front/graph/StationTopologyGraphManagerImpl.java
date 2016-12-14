package com.simoncat.front.graph;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.simoncat.framework.core.tuple.Couple;
import com.simoncat.framework.excel.api.ExcelOperator;
import com.simoncat.framework.excel.api.Parameter;
import com.simoncat.framework.filemanager.api.FileManager;
import com.simoncat.framework.graph.elements.Graph;
import com.simoncat.framework.graph.elements.GraphFactory;
import com.simoncat.front.connection.ConnectionDto;
import com.simoncat.front.setting.StationTopologySetting;
import com.simoncat.front.station.StationDto;

public class StationTopologyGraphManagerImpl implements StationTopologyGraphManager {

	@Autowired
	private StationTopologySetting stationTopologySetting;

	@Autowired
	private FileManager fileManager;

	@Autowired
	private GraphFactory generater;

	@Autowired
	private ExcelOperator excelOperator;

	@Override
	public Graph<StationDto, ConnectionDto> generate() {
		Collection<ConnectionDto> connectionInfo = fileManager.getAll(stationTopologySetting.getSourceFolder()).stream()
				.map(datasourceFileName -> new Parameter(stationTopologySetting.getSourceFolder(), datasourceFileName))
				.filter(Parameter::isExcelFile).map(parameter -> excelOperator.readAll(parameter, ConnectionDto.class))
				.flatMap(dataList -> dataList.stream()).collect(Collectors.toList());
		return generater.createUnDirectedGraph(generateStationMap(connectionInfo), generateConnectionMap(connectionInfo));
	}

	private Map<String, StationDto> generateStationMap(Collection<ConnectionDto> connectionInfo) {
		return connectionInfo.stream().map(connectionDto -> Arrays.asList(connectionDto.getStartStationName(), connectionDto.getNextStationName()))
				.flatMap(stationNameList -> stationNameList.stream()).distinct()
				.collect(Collectors.toMap(stationName -> stationName, stationName -> new StationDto(stationName)));
	}

	private Map<Couple<String>, ConnectionDto> generateConnectionMap(Collection<ConnectionDto> connectionInfo) {
		return connectionInfo.stream().filter(StationTopologyGraphManagerImpl::isNotEmptyStringOfStationName)
				.collect(Collectors.toMap(dto -> Couple.of(dto.getStartStationName(), dto.getNextStationName()).get(), dto -> dto));
	}

	private static boolean isNotEmptyStringOfStationName(ConnectionDto dto) {
		return StringUtils.isNotBlank(dto.getStartStationName()) && StringUtils.isNotBlank(dto.getNextStationName());
	}
}
