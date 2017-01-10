package com.simoncat.front.cableaccess.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.simoncat.framework.json.api.JsonOperator;
import com.simoncat.framework.json.config.JsonConfig;
import com.simoncat.front.cableaccess.setting.WorkSheetSetting;
import com.simoncat.front.cableaccess.setting.WorkSheetSettingConfig;

@Configuration
@Import({ WorkSheetSettingConfig.class, JsonConfig.class })
public class WorkSheetDaoConfig {

	@Autowired
	private WorkSheetSetting workSheetSetting;

	@Autowired
	private JsonOperator jsonOperator;

	@Bean
	public WorkSheetDao workSheetDao() {
		switch (workSheetSetting.getDataSourceType()) {
		case JSON:
			return new WorkSheetJsonDaoImpl(workSheetSetting, jsonOperator);
		default:
			return new WorkSheetJsonDaoImpl(workSheetSetting, jsonOperator);
		}

	}
}
