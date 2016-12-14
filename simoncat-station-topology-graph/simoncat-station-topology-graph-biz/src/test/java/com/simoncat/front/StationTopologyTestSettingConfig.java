package com.simoncat.front;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simoncat.front.setting.StationTopologySetting;

@Configuration
public class StationTopologyTestSettingConfig {

	@Bean
	public StationTopologySetting stationTopologySetting() {
		StationTopologySetting mockSetting = new StationTopologySetting();
		mockSetting.setLocationFolder(getClass().getResource("/longitude_latitude").getPath());
		mockSetting.setLocationFile("SampleStationLocation.xls");
		mockSetting.setSourceFolder(getClass().getResource("/graph").getPath());
		return mockSetting;
	}
}
