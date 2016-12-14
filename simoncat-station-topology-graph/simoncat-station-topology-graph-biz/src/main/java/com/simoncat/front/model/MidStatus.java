package com.simoncat.front.model;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MidStatus {

	private PathCalc curPath;
	private Site curSite;
	private int[] visitedSites;

	public void addRoute(RouteCalc route) {
		Objects.requireNonNull(route, "Can NOT add a null route into current Path");

		this.curPath.addRoute(route);
		visitedSites[route.getNext().getIndex()] = 1;
	}

	public boolean isVisited(Site toBeCheckedSite) {
		return visitedSites[toBeCheckedSite.getIndex()] == 1;
	}

	@Override
	public MidStatus clone() {
		return new MidStatus(curPath.clone(), curSite, Arrays.copyOf(visitedSites, visitedSites.length));
	}
}
