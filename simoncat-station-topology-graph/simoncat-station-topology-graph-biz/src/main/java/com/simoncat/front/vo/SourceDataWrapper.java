package com.simoncat.front.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceDataWrapper {

	private String fileName;
	private String sheetName;
	private int rowPos;
	private double id;
	private String startSiteName;
	private String nextSiteName;
	private String cableTypeName;
	private String cablePurpose;
	private String routeName;
	private double cableCountTotal;
	private double cableCountUsed;
	private double cableCountBroken;
	private double distance;

}
