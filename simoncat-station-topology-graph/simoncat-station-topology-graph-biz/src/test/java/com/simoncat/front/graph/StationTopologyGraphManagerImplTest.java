package com.simoncat.front.graph;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simoncat.framework.graph.elements.Graph;
import com.simoncat.front.StationTopologyTestSettingConfig;
import com.simoncat.front.connection.ConnectionDto;
import com.simoncat.front.station.StationDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { StationTopologyGraphConfig.class, StationTopologyTestSettingConfig.class })
public class StationTopologyGraphManagerImplTest {

	private static final String[] EXPECTED_STATION_NAME = { "Station A", "Station B", "Station C", "Station D", "Station E" };

	@Autowired
	private StationTopologyGraphManager stationTopologyGraphManager;

	@Test
	public void testGenerate() {
		Graph<StationDto, ConnectionDto> graph = stationTopologyGraphManager.generate();
		assertNotNull(graph);
		assertThat("There should be 5 stations", graph.getAllVertexes().size(), is(5));
		assertTrue("The station name should be as same as expected station names.",
				Arrays.equals(EXPECTED_STATION_NAME, graph.getAllVertexes().stream().map(vertex -> vertex.getName()).toArray()));
	}
}
