package com.simoncat.front.cableacess.worksheet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkSheetManagerConfig {

	@Bean
	public WorkSheetManager workSheetManager() {
		return new WorkSheetManagerImpl();
	}
}
