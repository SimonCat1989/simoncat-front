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
import com.simoncat.front.vo.DetailsContentVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ContentController {
	
	private static final ObjectMapper LOCAL_MAPPER = new ObjectMapper();

	@RequestMapping(value = "/content.do", method = RequestMethod.GET)
	public ModelAndView content(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws Exception {
		String contentId = request.getParameter("contentId");
		modelMap.put("contents", loadContent(contentId));
		return new ModelAndView("/details", modelMap);
	}
	
	private DetailsContentVo loadContent(String contentId) {
		File contentFile = Paths.get(this.getClass().getResource("/").getPath(),"assets", contentId + ".json").toFile();
		try {
			return LOCAL_MAPPER.readValue(contentFile, DetailsContentVo.class);
		} catch (IOException e) {
			log.error("Can not read data from file {}", contentFile, e);
		}
		return DetailsContentVo.EMPTY;
	}
}
