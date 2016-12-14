package com.simoncat.front.stationLocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.simoncat.framework.excel.api.ExcelOperator;
import com.simoncat.framework.excel.api.Parameter;
import com.simoncat.front.setting.StationTopologySetting;
import com.simoncat.front.station.LocationDto;

public class StationLocationManagerImpl implements StationLocationManager {

	@Autowired
	private ExcelOperator operator;

	@Autowired
	private StationTopologySetting stationTopologySetting;

	@Override
	public List<LocationDto> getAll() {
		return operator.readAll(new Parameter(stationTopologySetting.getLocationFolder(), stationTopologySetting.getLocationFile()),
				LocationDto.class);
	}

}
