package com.simoncat.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simoncat.front.service.RecommendationDetailService;

@Controller
public class RecommendationDetailController {

    @Autowired
    private RecommendationDetailService recommendationDetailService;

    @RequestMapping(value = "/recommendation/detail.do", method = RequestMethod.GET)
    public ModelAndView content(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
            throws Exception {
        int recommendationId = Integer.parseInt(request.getParameter("recommendationId"));
        modelMap.put("contents", recommendationDetailService.load(recommendationId));
        return new ModelAndView("/details", modelMap);
    }
}
