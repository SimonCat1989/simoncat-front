package com.simoncat.front.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.apache.commons.lang3.StringUtils;

@Data
@AllArgsConstructor
public class RouteInfo {

	private int rowPos;
	private String cableType;
	private String cablePurpose;
	private String name;
	private int totalCableCount;
	private int usedCableCount;
	private int brokenCableCount;
	private double distance;
	

	public static final RouteInfo EMPTY = new RouteInfo(-1, StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY, -1, -1, -1, -1);

	@Override
	protected RouteInfo clone() {
		return new RouteInfo(rowPos, cableType, cablePurpose, name, totalCableCount, usedCableCount, brokenCableCount, distance);
	}

}
