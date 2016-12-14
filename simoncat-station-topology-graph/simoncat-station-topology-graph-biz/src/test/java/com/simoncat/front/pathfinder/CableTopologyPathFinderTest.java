package com.simoncat.front.pathfinder;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

import com.simoncat.front.graph.StationTopologyGraphGeneratorOld;
import com.simoncat.front.graph.GraphOld;
import com.simoncat.front.model.Path;
import com.simoncat.front.model.Route;
import com.simoncat.front.model.Site;

@Slf4j
public class CableTopologyPathFinderTest {

	private static final GraphOld TEST_CABLE_TOPOLOGY = new StationTopologyGraphGeneratorOld().generate();
	private static final CableTopologyPathFinder TEST_FINDER = new CableTopologyPathFinder();
	private static final String TEST_START_NAME = "卢家湾";
	private static final String TEST_END_NAME = "杨高站";

	@Test
	public void testFindPath() {
		Optional<Site> start = TEST_CABLE_TOPOLOGY.findSiteByname(TEST_START_NAME);
		Optional<Site> end = TEST_CABLE_TOPOLOGY.findSiteByname(TEST_END_NAME);

		if (start.isPresent() && end.isPresent()) {
			List<Path> pathList = TEST_FINDER.getPath(TEST_CABLE_TOPOLOGY, start.get(), end.get());
			pathList.stream().forEach(path -> {
				List<Route> routeList = path.getRoutes();
				StringBuilder sb = new StringBuilder();
				routeList.forEach(route -> {
					sb.append(route.getStart().getName());
					sb.append(" --> ");
					sb.append(route.getName());
					sb.append(" --> ");
				});
				sb.append(routeList.get(routeList.size() - 1).getNext().getName());
				System.out.println("We got one path with Score " + path.getScore() + ": " + sb.toString());
				// log.info("We got one path: {}.", sb.toString());
				});
		} else {
			log.warn("Can NOT find the site by name: [{}], [{}]", TEST_START_NAME, TEST_END_NAME);
		}
	}
}
