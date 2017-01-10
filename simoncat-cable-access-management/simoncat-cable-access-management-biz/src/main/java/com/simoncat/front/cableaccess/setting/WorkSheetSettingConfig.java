package com.simoncat.front.cableaccess.setting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkSheetSettingConfig {

	@Bean
	public WorkSheetSetting workSheetSetting() {
		return new WorkSheetSetting();
	}
}
