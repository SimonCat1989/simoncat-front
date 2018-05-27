package com.simoncat.front.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecommendationConfig {

	@Bean
	public RecommendationDetailService recommendationDetailService() {
		return new RecommendationDetailServiceImpl();
	}
	
	@Bean
	public RecommendationService recommendationService() {
		return new RecommendationServiceImpl();
	}
}
