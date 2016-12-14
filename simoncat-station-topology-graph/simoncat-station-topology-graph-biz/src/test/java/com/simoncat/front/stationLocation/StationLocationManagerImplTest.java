package com.simoncat.front.stationLocation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simoncat.front.StationTopologyTestSettingConfig;
import com.simoncat.front.station.LocationDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { StationLocationConfig.class, StationTopologyTestSettingConfig.class })
public class StationLocationManagerImplTest {

	private static final int EXPECTED_TEST_COUNT = 5;
	private static final String[] EXPECTED_TEST_STATION_NAME = { "Station A", "Station B", "Station C", "Station D", "Station E" };
	private static final double[] EXPECTED_TEST_STATION_LONGITUDE = { 121.123456D, 121.123457D, 121.123458D, 121.123452D, 121.12346D };
	private static final double[] EXPECTED_TEST_STATION_LATITUDE = { 31.30445D, 31.28445D, 31.26445D, 31.24445D, 31.22445D };

	@Autowired
	private StationLocationManager stationLocationManager;

	@Test
	public void testGetAllFromFile() {
		List<LocationDto> results = stationLocationManager.getAll();
		assertThat("There should be expected size of instances in the list.", results.size(), is(EXPECTED_TEST_COUNT));
		IntStream.range(0, EXPECTED_TEST_COUNT - 1).forEach(count -> {
			assertThat("Check Station Name of instance " + count, results.get(count).getStationName(), is(EXPECTED_TEST_STATION_NAME[count]));
			assertThat("Check longitude of instance " + count, results.get(count).getLongitude(), is(EXPECTED_TEST_STATION_LONGITUDE[count]));
			assertThat("Check latitude of instance " + count, results.get(count).getLatitude(), is(EXPECTED_TEST_STATION_LATITUDE[count]));
		});

	}
}
