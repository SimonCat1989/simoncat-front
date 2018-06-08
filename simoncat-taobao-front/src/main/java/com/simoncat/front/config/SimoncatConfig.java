package com.simoncat.front.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.simoncat.front.service.SimoncatServiceConfig;

@Configuration
@Import({ SimoncatServiceConfig.class })
public class SimoncatConfig {

}
