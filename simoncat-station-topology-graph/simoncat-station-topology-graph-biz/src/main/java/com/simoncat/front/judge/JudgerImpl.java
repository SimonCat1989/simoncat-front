package com.simoncat.front.judge;

import java.util.List;

import com.simoncat.front.model.Path;
import com.simoncat.front.model.Route;

public class JudgerImpl implements Judger {

	@Override
	public void calculateScore(Path path) {
		double score = 0.0;
		List<Route> routeList = path.getRoutes();
		score += routeList.size() * 10000;
		score += path.getTotalDistance() * 100;
		score += (100 - path.getTotalAvailableCableCount()) * 50;
		path.setScore(score);
	}

}
