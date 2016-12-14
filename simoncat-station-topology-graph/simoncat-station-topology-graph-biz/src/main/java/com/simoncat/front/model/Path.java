package com.simoncat.front.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Path implements Comparable<Path> {

	private List<Route> routes;
	private double totalDistance;
	private int totalAvailableCableCount = Integer.MAX_VALUE;
	private double score;
	private boolean disuse;

	public void addRoute(Route route) {
		Objects.requireNonNull(route, "Can NOT add a null route into current Path");

		totalDistance += route.getDistance();
		int newAvailableCableCount = route.getTotalCableCount() - route.getBrokenCableCount()
				- route.getUsedCableCount();
		if (totalAvailableCableCount > newAvailableCableCount) {
			totalAvailableCableCount = newAvailableCableCount;
		}
		this.routes.add(route);

		BigDecimal bg = new BigDecimal(totalDistance);
		totalDistance = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	@Override
	protected Path clone() {
		return new Path(routes.parallelStream().map(route -> route.clone()).collect(Collectors.toList()), totalDistance,
				totalAvailableCableCount, score, disuse);
	}

	@Override
	public int compareTo(Path o) {
		return (score == o.getScore()) ? 0 : ((score < o.getScore()) ? -1 : 1);
	}

}
