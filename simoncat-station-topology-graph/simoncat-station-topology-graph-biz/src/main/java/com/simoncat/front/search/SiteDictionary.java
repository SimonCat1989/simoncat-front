package com.simoncat.front.search;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.simoncat.front.station.StationDto;

public class SiteDictionary {

	private Map<String, StationDto> siteNamesMap = Maps.newConcurrentMap();

	public List<String> fuzzySearch(String keywords) {
		return Lists.newArrayList();
	}

	public void add(StationDto newSite) {
		siteNamesMap.putIfAbsent(newSite.getName(), newSite);
	}
}
