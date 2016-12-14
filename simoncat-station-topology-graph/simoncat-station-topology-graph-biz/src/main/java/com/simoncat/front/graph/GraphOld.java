package com.simoncat.front.graph;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import com.google.common.collect.Lists;
import com.simoncat.front.model.RouteCalc;
import com.simoncat.front.model.RouteInfo;
import com.simoncat.front.model.Site;
import com.simoncat.front.vo.SourceDataWrapper;

@Slf4j
public class GraphOld {

	private List<Site> sites;
	private RouteCalc[][] routes;
	private int numOfRoutes;

	public GraphOld(int n) {
		routes = new RouteCalc[n][n];
		// Keep the original insertion order, so use LinkedList
		sites = Lists.newLinkedList();
		numOfRoutes = 0;
	}

	public int getNumOfSites() {
		return sites.size();
	}

	public int getNumOfRoutes() {
		return numOfRoutes;
	}

	public RouteCalc getRoute(int startSite, int endSite) {
		return routes[startSite][endSite];
	}

	public void insertNewSite(Site newSite) {
		sites.add(newSite);
	}

	public void insertNewRoute(int startSite, int endSite, RouteCalc newRoute) {
		routes[startSite][endSite] = newRoute;
		numOfRoutes++;
	}

	public void deleteRoute(int startSite, int endSite) {
		routes[startSite][endSite] = null;
		numOfRoutes--;
	}

	public List<RouteCalc> getAllRoutesForAdjacentSites(Site startSite) {
		List<RouteCalc> routeList = Lists.newArrayList();
		RouteCalc nextRoute = this.getRouteForFirstAdjacentSite(startSite);
		while (RouteCalc.EMPTY != nextRoute) {
			routeList.add(nextRoute);
			nextRoute = this.getNextRouteForAdjacentSite(startSite, nextRoute.getNext());
		}
		return routeList;
	}

	public RouteCalc getRouteForFirstAdjacentSite(Site startSite) {
		for (int j = 0; j < sites.size(); j++) {
			if (Objects.nonNull(routes[startSite.getIndex()][j])) {
				return routes[startSite.getIndex()][j];
			}
		}
		return RouteCalc.EMPTY;
	}

	public RouteCalc getNextRouteForAdjacentSite(Site start, Site previous) {
		for (int j = previous.getIndex() + 1; j < sites.size(); j++) {
			if (Objects.nonNull(routes[start.getIndex()][j])) {
				return routes[start.getIndex()][j];
			}
		}
		return RouteCalc.EMPTY;
	}

	public void init(Collection<SourceDataWrapper> data) {
		data.stream().forEach(this::init);
	}

	public void init(SourceDataWrapper data) {
		insertSingleRouteIfAbsent(insertVertexesIfAbsent(data.getStartSiteName(), data.getNextSiteName()), data.getCableTypeName(),
				data.getCablePurpose(), data.getRouteName(), (int) data.getCableCountTotal(), (int) data.getCableCountUsed(),
				(int) data.getCableCountBroken(), data.getDistance(), data.getFileName(), data.getSheetName(), data.getRowPos());
	}

	private List<Site> insertVertexesIfAbsent(String... siteNames) {
		return Arrays.asList(siteNames).stream().map(this::insertSingleVertexIfAbsent).collect(Collectors.toList());
	}

	private Site insertSingleVertexIfAbsent(String siteName) {
		Optional<Site> site = findSiteByname(siteName);
		if (site.isPresent()) {
			return site.get();
		}
		Site newSite = new Site(this.sites.size(), siteName);
		this.insertNewSite(newSite);
		return newSite;
	}

	public Optional<Site> findSiteByname(String siteName) {
		return this.sites.parallelStream().filter(site -> siteName.equals(site.getName())).findFirst();
	}

	private void insertSingleRouteIfAbsent(List<Site> sites, String type, String purpose, String name, int totalCableCount, int availableCableCount,
			int brokenCableCount, double distance, String fileName, String sheetName, int rowPos) {
		if (sites.size() != 2) {
			log.warn("Wrong count of Site instance for Route: [{}]", name);
		} else {
			Site start = sites.get(0);
			Site next = sites.get(1);
			if (!isRouteExisted(start.getIndex(), next.getIndex())) {
				this.insertNewRoute(
						start.getIndex(),
						next.getIndex(),
						new RouteCalc(fileName, sheetName, start, next, Lists.newArrayList(new RouteInfo(rowPos, type, purpose, name,
								totalCableCount, availableCableCount, brokenCableCount, distance))));
			} else {
				List<RouteInfo> infoList = this.routes[start.getIndex()][next.getIndex()].getRouteInfoList();
				if (!infoList.parallelStream().anyMatch(info -> info.getName().equals(name))) {
					infoList.add(new RouteInfo(rowPos, type, purpose, name, totalCableCount, availableCableCount, brokenCableCount, distance));
				}
			}

			if (!isRouteExisted(next.getIndex(), start.getIndex())) {
				this.insertNewRoute(
						next.getIndex(),
						start.getIndex(),
						new RouteCalc(fileName, sheetName, next, start, Lists.newArrayList(new RouteInfo(rowPos, type, purpose, name,
								totalCableCount, availableCableCount, brokenCableCount, distance))));
			} else {
				List<RouteInfo> infoList = this.routes[next.getIndex()][start.getIndex()].getRouteInfoList();
				if (!infoList.parallelStream().anyMatch(info -> info.getName().equals(name))) {
					infoList.add(new RouteInfo(rowPos, type, purpose, name, totalCableCount, availableCableCount, brokenCableCount, distance));
				}
			}
		}
	}

	private boolean isRouteExisted(int startSiteIndex, int nextSiteIndex) {
		return Objects.nonNull(this.routes[startSiteIndex][nextSiteIndex]);
	}

	public List<RouteCalc> getAllRoutes() {
		List<RouteCalc> result = Lists.newArrayList();
		for (int i = 0; i < this.getNumOfSites(); i++) {
			RouteCalc[] routeArray = this.routes[i];
			for (int j = i; j < this.getNumOfSites(); j++) {
				if (Objects.nonNull(routeArray[j])) {
					result.add(routeArray[j]);
				}
			}
		}
		return result;
	}
}
