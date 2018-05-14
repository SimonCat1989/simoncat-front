package com.simoncat.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoodsController {

	@RequestMapping(value = "/goods.do", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws Exception {
		modelMap.put("good",
				"https://img.alicdn.com/imgextra/i1/1114511827/TB2ykqXpY9YBuNjy0FgXXcxcXXa_!!1114511827.jpg_430x430q90.jpg");
		// modelMap.put("good", request.getParameter("good"));
		modelMap.put("token", request.getParameter("token"));
		return new ModelAndView("/goods", modelMap);
	}
}
