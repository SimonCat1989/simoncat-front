package com.simoncat.front.controller;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simoncat.front.service.RecommendationDetailService;
import com.simoncat.front.service.RecommendationService;
import com.simoncat.front.vo.RecommendationVo;

@Controller
public class RecommendationController {

	@Autowired
	private RecommendationService recommendationService;
	
	@Autowired
	private RecommendationDetailService recommendationDetailService;
	
	@RequestMapping(value = "/recommendation.do", method = RequestMethod.GET)
	public ModelAndView recommendation(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws Exception {
		RecommendationVo recommendationVo = recommendationService.loadAll();
		modelMap.put("vo", recommendationVo);
		
		modelMap.put("books", recommendationVo.getData().stream().map(dto -> recommendationDetailService.load(dto.getContentId()).getData()).collect(Collectors.toList()));
		
		return new ModelAndView("/recommendation", modelMap);
	}
}
