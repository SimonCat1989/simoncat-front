package com.simoncat.front.cableaccess.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConnectionDto {

	public static final ConnectionDto EMPTY = new ConnectionDto("", new ArrayList<Integer>(), -1);

	private final String name;
	private final List<Integer> ports;
	private final int status;

}
