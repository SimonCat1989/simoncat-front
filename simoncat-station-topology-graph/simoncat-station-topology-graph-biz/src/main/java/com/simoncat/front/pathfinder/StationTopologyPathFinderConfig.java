package com.simoncat.front.pathfinder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.simoncat.framework.graph.search.impl.GraphSearcherConfig;

@Configuration
@Import({ GraphSearcherConfig.class })
public class StationTopologyPathFinderConfig {

	@Bean
	public StationTopologyPathFinder stationTopologyPathFinder() {
		return new StationTopologyPathFinderImpl();
	}
}
