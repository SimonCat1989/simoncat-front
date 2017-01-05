package com.simoncat.front.cableaccess.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.simoncat.front.cableaccess.dto.WorkSheetDto;
import com.simoncat.front.cableacess.worksheet.WorkSheetManager;

@Controller
public class IndexController {

	@Autowired
	private WorkSheetManager workSheetManager;

	@RequestMapping(value = "/worksheets/pending/load.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> loadPendingWorkSheets() {
		Map<String, Object> modelMap = Maps.newHashMap();
		List<WorkSheetDto> pendingSheets = workSheetManager.fetchPendingSheets();
		modelMap.put("pending", pendingSheets);
		return modelMap;
	}
}
