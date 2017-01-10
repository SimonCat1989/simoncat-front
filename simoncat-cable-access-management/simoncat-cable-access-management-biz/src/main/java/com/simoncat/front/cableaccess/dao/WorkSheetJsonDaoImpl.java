package com.simoncat.front.cableaccess.dao;

import java.io.File;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.simoncat.framework.json.api.JsonOperator;
import com.simoncat.framework.json.exception.InvalidJsonConversionException;
import com.simoncat.front.cableaccess.dao.vo.WorkSheetJsonVo;
import com.simoncat.front.cableaccess.dto.WorkSheetDto;
import com.simoncat.front.cableaccess.setting.WorkSheetSetting;
import com.simoncat.front.cableaccess.status.WorkSheetStatus;

@Slf4j
public class WorkSheetJsonDaoImpl implements WorkSheetDao {

	private static final Function<WorkSheetDto, WorkSheetStatus> FUNCTION_GET_KEY = (workSheetDto) -> {
		switch (workSheetDto.getStatus()) {
		case 0:
			return WorkSheetStatus.PENDDING;
		case 1:
			return WorkSheetStatus.WORKING;
		case 2:
			return WorkSheetStatus.SUBMITTING;
		case 3:
			return WorkSheetStatus.SUBMITTED;
		default:
			return WorkSheetStatus.ILLEGAL;
		}
	};

	private Multimap<WorkSheetStatus, WorkSheetDto> cache;

	@Autowired
	WorkSheetJsonDaoImpl(WorkSheetSetting workSheetSetting, JsonOperator jsonOperator) {
		if (Objects.isNull(cache)) {
			cache = ArrayListMultimap.<WorkSheetStatus, WorkSheetDto> create();
			try {
				jsonOperator
				        .read(new File(workSheetSetting.getJsonFileRootPath(),
				                workSheetSetting.getJsonWorkSheetFileName()), WorkSheetJsonVo.class)
				        .getSheets().forEach((workSheetDto) -> {
					        cache.put(FUNCTION_GET_KEY.apply(workSheetDto), workSheetDto);
				        });
			} catch (InvalidJsonConversionException e) {
				log.error("Can not init working sheet data.", e);
			}
		}
	}

	@Override
	public Collection<WorkSheetDto> getSheets(WorkSheetStatus status) {
		return cache.get(status);
	}
}
