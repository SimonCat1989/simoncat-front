package com.simoncat.front.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simoncat.front.vo.RecommendationVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RecommendationController {

	private static final ObjectMapper LOCAL_MAPPER = new ObjectMapper();

	@RequestMapping(value = "/recommendation.do", method = RequestMethod.GET)
	public ModelAndView recommendation(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws Exception {
		modelMap.put("vo", loadContent());
		return new ModelAndView("/recommendation", modelMap);
	}

	private RecommendationVo loadContent() {
		File contentFile = Paths.get(this.getClass().getResource("/").getPath(), "assets", "recommend.json").toFile();
		try {
			return LOCAL_MAPPER.readValue(contentFile, RecommendationVo.class);
		} catch (IOException e) {
			log.error("Can not read data from file {}", contentFile, e);
		}
		return RecommendationVo.EMPTY;
	}
}
