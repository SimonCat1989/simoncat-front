package com.simoncat.front.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimoncatDaoConfig {

    @Bean
    public EssayDao essayDao() {
        return new EssayDaoImpl();
    }
}
