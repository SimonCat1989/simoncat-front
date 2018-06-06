package com.simoncat.front.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simoncat.front.vo.RecommendationVo;

@Slf4j
public class RecommendationServiceImpl implements RecommendationService {

	private static final ObjectMapper LOCAL_MAPPER = new ObjectMapper();
	
	@Override
	public RecommendationVo loadAll() {
		File contentFile = Paths.get(this.getClass().getResource("/").getPath(), "assets", "recommend.json").toFile();
		try {
			return LOCAL_MAPPER.readValue(contentFile, RecommendationVo.class);
		} catch (IOException e) {
			log.error("Can not read data from file {}", contentFile, e);
		}
		return RecommendationVo.EMPTY;
	}
}
