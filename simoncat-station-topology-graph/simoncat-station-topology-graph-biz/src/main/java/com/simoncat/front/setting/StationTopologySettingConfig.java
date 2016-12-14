package com.simoncat.front.setting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StationTopologySettingConfig {

	@Bean
	public StationTopologySetting stationTopologySetting() {
		return new StationTopologySetting();
	}
}
