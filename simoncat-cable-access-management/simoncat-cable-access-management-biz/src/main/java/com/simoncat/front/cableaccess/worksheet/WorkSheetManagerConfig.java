package com.simoncat.front.cableaccess.worksheet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkSheetManagerConfig {

	@Bean
	public WorkSheetManager workSheetManager() {
		return new WorkSheetManagerImpl();
	}
}
