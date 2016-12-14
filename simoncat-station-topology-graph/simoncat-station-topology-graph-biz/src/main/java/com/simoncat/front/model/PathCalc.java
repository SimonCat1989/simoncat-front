package com.simoncat.front.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PathCalc {

	private List<RouteCalc> routes;

	public void addRoute(RouteCalc route) {
		Objects.requireNonNull(route, "Can NOT add a null route into current Path");

		this.routes.add(route);
	}

	@Override
	protected PathCalc clone() {
		return new PathCalc(routes.parallelStream().map(route -> route.clone()).collect(Collectors.toList()));
	}

	public List<Path> toPathList() {
		int size = routes.size();
		int[] curOfEachList = new int[size];
		int[] sizeOfEachList = new int[size];
		List<Path> pathList = Lists.newArrayList();
		List<List<Route>> routesListList = routes.stream().map(route -> route.toRouteList()).collect(Collectors.toList());
		int pos = 0;
		long totalSize = 1L;
		for (List<Route> routeItems : routesListList) {
			sizeOfEachList[pos++] = routeItems.size();
			totalSize *= routeItems.size();
		}

		for (long p = 0L; p < totalSize; p++) {
			Path temp = new Path(Lists.newArrayList(), 0, Integer.MAX_VALUE, 0, false);
			for (int i = 0; i < size; i++) {
				temp.addRoute(routesListList.get(i).get(curOfEachList[i]).clone());
			}
			pathList.add(temp);

			boolean addOne = true;
			for (int j = size - 1; j >= 0; j--) {
				if (addOne) {
					if (curOfEachList[j] + 1 == sizeOfEachList[j]) {
						curOfEachList[j] = 0;
					} else {
						curOfEachList[j] += 1;
						addOne = false;
					}
				}
			}
		}

		return pathList;

	}
}
