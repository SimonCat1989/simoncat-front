package com.simoncat.front.cableaccess.worksheet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.simoncat.front.cableaccess.dao.WorkSheetDaoConfig;

@Configuration
@Import({ WorkSheetDaoConfig.class })
public class WorkSheetManagerConfig {

	@Bean
	public WorkSheetManager workSheetManager() {
		return new WorkSheetManagerImpl();
	}
}
