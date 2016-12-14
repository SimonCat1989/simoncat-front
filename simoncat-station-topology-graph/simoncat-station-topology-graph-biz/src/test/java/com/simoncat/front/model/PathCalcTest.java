package com.simoncat.front.model;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.simoncat.front.model.Path;
import com.simoncat.front.model.PathCalc;
import com.simoncat.front.model.Route;
import com.simoncat.front.model.RouteCalc;
import com.simoncat.front.model.RouteInfo;
import com.simoncat.front.model.Site;

public class PathCalcTest {
	@Test
	public void testToPathList() {
		List<Path> pathes = getPathData().toPathList();
		for (Path path : pathes) {
			StringBuilder sb = new StringBuilder();
			for (Route route : path.getRoutes()) {
				sb.append(route.getRowPos());
				sb.append(" -> ");
			}

			System.out.println(sb.toString());
		}
	}

	private PathCalc getPathData() {
		List<RouteCalc> routeCalcList = Lists.newArrayList();
		for (int i = 0; i < 3; i++) {
			routeCalcList.add(getData());
		}
		return new PathCalc(routeCalcList);
	}

	private RouteCalc getData() {
		List<RouteInfo> infoList = Lists.newArrayList();
		for (int i = 0; i < 3; i++) {
			infoList.add(new RouteInfo(i, "", "", Integer.toString(i), 0, 0, 0, 0));
		}

		return new RouteCalc("", "", Site.EMPTY, Site.EMPTY, infoList);
	}
}
