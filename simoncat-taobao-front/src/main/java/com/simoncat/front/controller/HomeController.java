package com.simoncat.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simoncat.front.service.EssayListOrderType;
import com.simoncat.front.service.EssayService;

@Controller
public class HomeController {

	@Autowired
	private EssayService essayService;

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws Exception {
		final String page = request.getParameter("page");
		modelMap.put("essays", essayService.loadAll(EssayListOrderType.BY_CREATION,
				StringUtils.isBlank(page) ? 1 : Integer.parseInt(page)));
		modelMap.put("sideMenu", 1);
		return new ModelAndView("/home", modelMap);
	}
	
	@RequestMapping(value = "/home/hotest.do", method = RequestMethod.GET)
	public ModelAndView hotest(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws Exception {
		final String page = request.getParameter("page");
		modelMap.put("essays", essayService.loadAll(EssayListOrderType.BY_HEART,
				StringUtils.isBlank(page) ? 1 : Integer.parseInt(page)));
		modelMap.put("sideMenu", 2);
		return new ModelAndView("/hotest", modelMap);
	}
}
