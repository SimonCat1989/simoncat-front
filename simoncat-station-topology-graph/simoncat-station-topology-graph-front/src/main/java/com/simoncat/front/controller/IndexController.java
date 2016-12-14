package com.simoncat.front.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.simoncat.framework.graph.elements.Graph;
import com.simoncat.front.connection.ConnectionDto;
import com.simoncat.front.graph.StationTopologyGraphManager;
import com.simoncat.front.pathfinder.StationTopologyPathFinder;
import com.simoncat.front.station.StationDto;
import com.simoncat.front.stationLocation.StationLocationManager;

@Controller
public class IndexController {

	@Autowired
	private StationTopologyGraphManager stationTopologyGraphManager;

	// private CableTopologyOperator cableTopologyOperator = new CableTopologyOperator();

	@Autowired
	private StationTopologyPathFinder stationTopologyPathFinder;

	@Autowired
	private StationLocationManager stationLocationManager;

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		// load data
		return new ModelAndView("/index", modelMap);
	}

	@RequestMapping(value = "/index/load.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> loadSiteInfo(@RequestParam("site_name") String siteName) {
		Map<String, Object> modelMap = Maps.newHashMap();
		Graph<StationDto, ConnectionDto> stationTopology = stationTopologyGraphManager.generate();
		stationTopology.getVertexByName(siteName).ifPresent(startStation -> modelMap.put("data", stationTopology.getAllAdjacentEdges(startStation)));
		return modelMap;
	}

	@RequestMapping(value = "/index/update.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> updateSiteRelatedRoute(@RequestParam("routeName") String routeName, @RequestParam("distance") double distance,
			@RequestParam("cableCountUsed") int cableCountUsed, @RequestParam("cableTypeName") String cableTypeName,
			@RequestParam("cablePurpose") String cablePurpose, @RequestParam("cableCountTotal") int cableCountTotal,
			@RequestParam("cableCountBroken") int cableCountBroken, @RequestParam("fileName") String fileName,
			@RequestParam("sheetName") String sheetName, @RequestParam("rowPos") int rowPos, @RequestParam("startSiteName") String startSiteName,
			@RequestParam("nextSiteName") String nextSiteName) {
		// Do save
		// cableTopologyOperator.update(fileName, sheetName, rowPos, startSiteName, nextSiteName, routeName, cableTypeName, cablePurpose,
		// cableCountTotal, cableCountUsed, cableCountBroken, distance);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("data", "succ");
		return modelMap;
	}

	@RequestMapping(value = "/index/remove.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> removeSiteRelatedRoute(@RequestParam("fileName") String fileName, @RequestParam("sheetName") String sheetName,
			@RequestParam("rowPos") int rowPos) {
		// Do save
		// cableTopologyOperator.delete(fileName, sheetName, rowPos);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("data", "succ");
		return modelMap;
	}

	@RequestMapping(value = "/index/search.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> loadRouteInfo(@RequestParam("start_site_name") String startSiteName,
			@RequestParam("next_site_name") String nextSiteName, @RequestParam("cable_count_min") int cableCountMin) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// Load data
		Graph<StationDto, ConnectionDto> stationTopology = stationTopologyGraphManager.generate();
		modelMap.put("data",
				stationTopologyPathFinder.searchPaths(stationTopology, new StationDto(startSiteName), new StationDto(nextSiteName), cableCountMin));
		return modelMap;
	}

	@RequestMapping(value = "/index/loadGeo.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> loadRouteInfo() {
		return ImmutableMap.<String, Object> builder().put("route", stationTopologyGraphManager.generate().getAllRoutes())
				.put("geo", stationLocationManager.getAll()).build();
	}
}
