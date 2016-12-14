package com.simoncat.front.pathfinder;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import com.google.common.collect.Lists;
import com.simoncat.front.graph.GraphOld;
import com.simoncat.front.judge.Judger;
import com.simoncat.front.judge.JudgerImpl;
import com.simoncat.front.model.MidStatus;
import com.simoncat.front.model.Path;
import com.simoncat.front.model.PathCalc;
import com.simoncat.front.model.RouteCalc;
import com.simoncat.front.model.Site;

@Slf4j
public class CableTopologyPathFinder implements PathFinder {

	private int maxRouteCount = 3;

	private static final Judger judger = new JudgerImpl();

	public void setMaxRouteCount(int maxRouteCount) {
		this.maxRouteCount = maxRouteCount;
	}

	public List<Path> getPath(GraphOld cableTopology, Site start, Site destination) {
		Objects.requireNonNull(start, "We can not get path with an empty starter site.");
		Objects.requireNonNull(destination, "We can not get path with an empty destination site.");

		int[] visitedSite = new int[cableTopology.getNumOfSites()];
		visitedSite[start.getIndex()] = 1;
		List<PathCalc> pathList = Lists.newArrayList();
		Deque<MidStatus> workingStack = new ArrayDeque<MidStatus>();
		MidStatus startStatus = new MidStatus(new PathCalc(Lists.newArrayList()), start, visitedSite);
		workingStack.push(startStatus);

		doFindPath(cableTopology, workingStack, destination, pathList);

		List<Path> resultList = pathList.stream().map(path -> path.toPathList()).flatMap(list -> list.stream())
				.collect(Collectors.toList());
		resultList.parallelStream().forEach(judger::calculateScore);
		Collections.sort(resultList);

		return resultList;
	}

	public List<Path> getPath(GraphOld cableTopology, Site start, Site destination, int cableCountMin) {
		List<Path> result = getPath(cableTopology, start, destination).stream()
				.filter(path -> path.getTotalAvailableCableCount() >= cableCountMin).collect(Collectors.toList());
		List<Path> disusedResult = getPath(cableTopology, start, destination).stream()
				.filter(path -> path.getTotalAvailableCableCount() < cableCountMin).map(path -> {
					path.setDisuse(true);
					return path;
				}).collect(Collectors.toList());
		result.addAll(disusedResult);
		return result;
	}

	private void doFindPath(GraphOld cableTopology, Deque<MidStatus> workingStack, Site destination,
			List<PathCalc> pathList) {
		if (!workingStack.isEmpty()) {
			MidStatus curStatus = workingStack.pop();
			if (curStatus.getCurPath().getRoutes().size() < maxRouteCount) {
				List<RouteCalc> allNextRoutes = cableTopology.getAllRoutesForAdjacentSites(curStatus.getCurSite());
				allNextRoutes.stream().forEach(route -> {
					Site nextSite = route.getNext();
					MidStatus newMidStatus = curStatus.clone();
					if (destination.equals(nextSite)) {
						newMidStatus.addRoute(route);
						log.info("Find one path: [{}]", newMidStatus.getCurPath().getRoutes().toString());
						pathList.add(newMidStatus.getCurPath());
					} else if (!curStatus.isVisited(nextSite)) {
						newMidStatus.addRoute(route);
						newMidStatus.setCurSite(nextSite);
						workingStack.push(newMidStatus);
					}
				});
			}
			doFindPath(cableTopology, workingStack, destination, pathList);
		}
	}

}
