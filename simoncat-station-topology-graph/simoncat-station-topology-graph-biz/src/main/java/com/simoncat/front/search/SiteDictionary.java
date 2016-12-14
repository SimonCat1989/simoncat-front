package com.simoncat.front.search;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.simoncat.front.model.Site;

public class SiteDictionary {

	private Map<String, Site> siteNamesMap = Maps.newConcurrentMap();
	
	public List<String> fuzzySearch(String keywords) {
		return Lists.newArrayList();
	}
	
	public void add(Site newSite) {
		siteNamesMap.putIfAbsent(newSite.getName(), newSite);
	}
}
