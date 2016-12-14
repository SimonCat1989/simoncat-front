package com.simoncat.front.model;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Route {

	private String fileName;
	private String sheetName;
	private int rowPos;
	private Site start;
	private Site next;
	private String cableType;
	private String cablePurpose;
	private String name;
	private int totalCableCount;
	private int usedCableCount;
	private int brokenCableCount;
	private double distance;

	public static final Route EMPTY = new Route(StringUtils.EMPTY, StringUtils.EMPTY, 0, Site.EMPTY, Site.EMPTY, StringUtils.EMPTY,
			StringUtils.EMPTY, StringUtils.EMPTY, -1, -1, -1, -1);

	@Override
	protected Route clone() {
		return new Route(fileName, sheetName, rowPos, start.clone(), next.clone(), cableType, cablePurpose, name, totalCableCount, usedCableCount,
				brokenCableCount, distance);
	}
}
