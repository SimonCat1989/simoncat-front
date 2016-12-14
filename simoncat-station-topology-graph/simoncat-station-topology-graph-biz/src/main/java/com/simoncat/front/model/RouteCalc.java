package com.simoncat.front.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

@Data
@AllArgsConstructor
public class RouteCalc {

	private String fileName;
	private String sheetName;
	private Site start;
	private Site next;
	private List<RouteInfo> routeInfoList;

	public static final RouteCalc EMPTY = new RouteCalc(StringUtils.EMPTY, StringUtils.EMPTY, Site.EMPTY, Site.EMPTY, Lists.newArrayList());

	@Override
	protected RouteCalc clone() {
		return new RouteCalc(fileName, sheetName, start.clone(), next.clone(), routeInfoList.stream().map(route -> route.clone())
				.collect(Collectors.toList()));
	}

	public List<Route> toRouteList() {
		return routeInfoList
				.stream()
				.map(info -> new Route(fileName, sheetName, info.getRowPos(), start.clone(), next.clone(), info.getCableType(), info
						.getCablePurpose(), info.getName(), info.getTotalCableCount(), info.getUsedCableCount(), info.getBrokenCableCount(), info
						.getDistance())).collect(Collectors.toList());
	}
}
