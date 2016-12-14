package com.simoncat.front.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.apache.commons.lang3.StringUtils;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Site {

	private int index;
	private String name;

	public static final Site EMPTY = new Site(-1, StringUtils.EMPTY);

	@Override
	protected Site clone() {
		return new Site(this.index, this.name);
	}
}
