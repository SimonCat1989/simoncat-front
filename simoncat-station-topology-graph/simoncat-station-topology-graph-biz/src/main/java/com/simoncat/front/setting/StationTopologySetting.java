package com.simoncat.front.setting;

import lombok.Data;

/**
 * Please set these property values in simoncat-station-topology-graph.properties. Following is an example:
 * <p>
 * ######################################## <br>
 * # Data Source for Station Topology <br>
 * ######################################## <br>
 * station.topology.source.folder=/home/XXX/station_data/stations_info <br>
 * station.topology.location.folder=/home/XXX/station_data/stations_location <br>
 * station.topology.location.file=locations.xls <br>
 */
@Data
public class StationTopologySetting {

	private String sourceFolder = "/home/simoncat/Develop-My/WorkSpace/station_data/stations_info";
	private String locationFolder = "/home/simoncat/Develop-My/WorkSpace/station_data/stations_location";
	private String locationFile = "locations.xls";
}
