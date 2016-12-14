package com.simoncat.front.judge;

import java.util.List;

import com.simoncat.framework.graph.elements.Edge;
import com.simoncat.framework.graph.elements.Path;
import com.simoncat.front.connection.ConnectionDto;
import com.simoncat.front.model.PathDto;
import com.simoncat.front.station.StationDto;

public class JudgerImpl implements Judger {

	@Override
	public void calculateScore(Path<StationDto, ConnectionDto> path) {
		double score = 0.0;
		PathDto pathValue = (PathDto) path.getValue();
		List<Edge<StationDto, ConnectionDto>> routeList = path.getEdges();
		score += routeList.size() * 10000;
		score += pathValue.getTotalDistance() * 100;
		score += (100 - pathValue.getTotalAvailableEdgeCount()) * 50;
		pathValue.setScore(score);
	}
}
