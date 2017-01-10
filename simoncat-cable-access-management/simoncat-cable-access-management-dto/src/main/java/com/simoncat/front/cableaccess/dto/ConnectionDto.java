package com.simoncat.front.cableaccess.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionDto {

	public static final ConnectionDto EMPTY = new ConnectionDto("", new ArrayList<Integer>(0), -1);

	private String name;
	private List<Integer> ports;
	private int status;

}
