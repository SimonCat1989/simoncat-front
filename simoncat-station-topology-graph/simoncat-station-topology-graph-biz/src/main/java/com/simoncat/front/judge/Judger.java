package com.simoncat.front.judge;

import com.simoncat.framework.graph.elements.Path;
import com.simoncat.front.connection.ConnectionDto;
import com.simoncat.front.station.StationDto;

public interface Judger {

	void calculateScore(Path<StationDto, ConnectionDto> path);
}
