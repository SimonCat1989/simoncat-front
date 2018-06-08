package com.simoncat.front.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simoncat.front.vo.RecommendationDetailVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecommendationDetailServiceImpl implements RecommendationDetailService {

	private static final ObjectMapper LOCAL_MAPPER = new ObjectMapper();
	
	@Override
	public RecommendationDetailVo load(long recommendationId) {
		File contentFile = Paths.get(this.getClass().getResource("/").getPath(),"assets", recommendationId + ".json").toFile();
		try {
			return LOCAL_MAPPER.readValue(contentFile, RecommendationDetailVo.class);
		} catch (IOException e) {
			log.error("Can not read data from file {}", contentFile, e);
		}
		return RecommendationDetailVo.EMPTY;
	}

}
