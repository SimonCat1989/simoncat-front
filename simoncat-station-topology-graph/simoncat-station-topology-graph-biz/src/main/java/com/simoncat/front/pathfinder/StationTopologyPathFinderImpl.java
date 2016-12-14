package com.simoncat.front.pathfinder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.simoncat.framework.graph.elements.Graph;
import com.simoncat.framework.graph.elements.Path;
import com.simoncat.framework.graph.elements.Vertex;
import com.simoncat.framework.graph.search.GraphSearcher;
import com.simoncat.front.connection.ConnectionDto;
import com.simoncat.front.judge.Judger;
import com.simoncat.front.judge.JudgerImpl;
import com.simoncat.front.model.PathDto;
import com.simoncat.front.station.StationDto;

class StationTopologyPathFinderImpl implements StationTopologyPathFinder {

	@Autowired
	private GraphSearcher<StationDto, ConnectionDto> graphSearcher;
	
	private static final Judger judger = new JudgerImpl();
	
	@Override
	public List<Path<StationDto, ConnectionDto>> searchPaths(Graph<StationDto, ConnectionDto> stationTopology, StationDto start,
			StationDto destination, int maxHops) {

		Optional<Vertex<StationDto>> startVertex = stationTopology.getVertexByValue(start);
		Optional<Vertex<StationDto>> destinationVertex = stationTopology.getVertexByValue(destination);
		List<Path<StationDto, ConnectionDto>> resultList = (startVertex.isPresent() && destinationVertex.isPresent()) ? graphSearcher.depthFirstSearch(stationTopology, startVertex.get(),
				destinationVertex.get(), maxHops, new PathDto()) : Collections.emptyList();
		resultList.parallelStream().forEach(judger::calculateScore);
		Collections.sort(resultList);
		return resultList;
	}

}
