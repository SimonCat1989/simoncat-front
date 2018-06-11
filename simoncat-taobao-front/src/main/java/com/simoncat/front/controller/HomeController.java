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
import com.simoncat.front.vo.EssayListVo;

@Controller
public class HomeController {

    @Autowired
    private EssayService essayService;

    @RequestMapping(value = "/home.do", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
            throws Exception {
        String page = request.getParameter("page");
        int pageId = StringUtils.isBlank(page) ? 0 : Integer.parseInt(page);
        Optional<EssayListVo> essays = essayService.loadAll(pageId);
        if (essays.isPresent()) {
            modelMap.put("essays", essays.get());
        }
        return new ModelAndView("/home", modelMap);
    }
}
