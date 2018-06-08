package com.simoncat.front.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.simoncat.front.dao.SimoncatDaoConfig;

@Configuration
@Import({ SimoncatDaoConfig.class })
public class SimoncatServiceConfig {

    @Bean
    public RecommendationDetailService recommendationDetailService() {
        return new RecommendationDetailServiceImpl();
    }

    @Bean
    public EssayService essayService() {
        return new EssayServiceImpl();
    }
}
