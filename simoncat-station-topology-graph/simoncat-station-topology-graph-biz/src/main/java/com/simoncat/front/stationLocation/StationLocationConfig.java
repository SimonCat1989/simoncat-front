package com.simoncat.front.stationLocation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.simoncat.framework.excel.config.ExcelConfig;
import com.simoncat.front.setting.StationTopologySettingConfig;

@Configuration
@Import({ ExcelConfig.class, StationTopologySettingConfig.class })
public class StationLocationConfig {

	@Bean
	public StationLocationManager stationLocationManager() {
		return new StationLocationManagerImpl();
	}
}
