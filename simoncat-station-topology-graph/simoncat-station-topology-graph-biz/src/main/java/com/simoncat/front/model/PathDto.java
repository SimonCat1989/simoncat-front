package com.simoncat.front.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.simoncat.framework.graph.elements.Edge;
import com.simoncat.framework.graph.elements.PathAttributes;
import com.simoncat.front.connection.ConnectionDto;
import com.simoncat.front.station.StationDto;

@Data
@AllArgsConstructor
public class PathDto implements PathAttributes<StationDto, ConnectionDto> {

	private double totalDistance;
	private double score;
	private boolean disuse;
	private int totalAvailableEdgeCount;

	public PathDto() {
		totalDistance = 0.0;
		score = 0.0;
		disuse = false;
		totalAvailableEdgeCount = Integer.MAX_VALUE;
	}

	@Override
	public int compareTo(PathAttributes<StationDto, ConnectionDto> o) {
		double oneScore = ((PathDto) o).getScore();
		return (score == oneScore) ? 0 : ((score < oneScore) ? -1 : 1);
	}

	@Override
	public void addNewEdge(Edge<StationDto, ConnectionDto> edge) {
		ConnectionDto connection = edge.getValue();
		totalAvailableEdgeCount = (totalAvailableEdgeCount > connection.getAvailableConnections()) ? connection.getAvailableConnections()
				: totalAvailableEdgeCount;
		totalDistance = new BigDecimal(totalDistance + connection.getConnectionLength()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	@Override
	public PathAttributes<StationDto, ConnectionDto> makeCopy() {
		return new PathDto(totalDistance, score, disuse, totalAvailableEdgeCount);
	}
}
