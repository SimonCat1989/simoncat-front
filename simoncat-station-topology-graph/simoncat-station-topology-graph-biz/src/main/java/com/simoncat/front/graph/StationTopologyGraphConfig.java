package com.simoncat.front.graph;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.simoncat.framework.excel.config.ExcelConfig;
import com.simoncat.framework.filemanager.config.FileManagerConfig;
import com.simoncat.framework.graph.elements.GraphConfig;
import com.simoncat.front.setting.StationTopologySettingConfig;

@Configuration
@Import({ StationTopologySettingConfig.class, FileManagerConfig.class, ExcelConfig.class, GraphConfig.class })
public class StationTopologyGraphConfig {

	@Bean
	public StationTopologyGraphManager stationTopologyGraphManager() {
		return new StationTopologyGraphManagerImpl();
	}
}
