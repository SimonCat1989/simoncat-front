package com.simoncat.front.graph;

import com.simoncat.framework.graph.elements.Graph;
import com.simoncat.front.connection.ConnectionDto;
import com.simoncat.front.station.StationDto;

public interface StationTopologyGraphManager {

	Graph<StationDto, ConnectionDto> generate();
}
