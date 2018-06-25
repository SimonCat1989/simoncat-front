package com.simoncat.front.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simoncat.front.service.EssayService;
import com.simoncat.front.vo.EssayVo;

@Controller
public class HomeController {

    @Autowired
    private EssayService essayService;

    @RequestMapping(value = "/home.do", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
            throws Exception {
        final String page = request.getParameter("page");
        modelMap.put("essays", essayService.loadAll(StringUtils.isBlank(page) ? 1 : Integer.parseInt(page)));
        return new ModelAndView("/home", modelMap);
    }

    @RequestMapping(value = "/home/essay.do", method = RequestMethod.GET)
    public ModelAndView essay(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
            throws Exception {
        final String essayId = request.getParameter("essayId");
        if (StringUtils.isNotBlank(essayId) && StringUtils.isNumeric(essayId)) {
            Optional<EssayVo> essay = essayService.loadEssay(Long.parseLong(essayId));
            if (essay.isPresent()) {
                modelMap.put("essay", essay.get());
                return new ModelAndView("/essay", modelMap);
            }
        }
        // TODO redirect to error page
        return new ModelAndView("/error", modelMap);
    }
}
