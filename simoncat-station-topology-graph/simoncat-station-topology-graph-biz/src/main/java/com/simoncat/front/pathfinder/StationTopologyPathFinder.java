package com.simoncat.front.pathfinder;

import java.util.List;

import com.simoncat.framework.graph.elements.Graph;
import com.simoncat.framework.graph.elements.Path;
import com.simoncat.front.connection.ConnectionDto;
import com.simoncat.front.station.StationDto;

public interface StationTopologyPathFinder {

	List<Path<StationDto, ConnectionDto>> searchPaths(Graph<StationDto, ConnectionDto> stationTopology, StationDto start, StationDto destination,
			int maxHops);
}
