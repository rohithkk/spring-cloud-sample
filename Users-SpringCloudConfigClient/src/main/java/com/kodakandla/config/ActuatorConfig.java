package com.kodakandla.config;

import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class ActuatorConfig {

	//we can use this to add specific tag and value to all of the metrics
	@Bean
	MeterRegistryCustomizer<MeterRegistry> metricsCommonTags(){
		//all of the metrics will have the these two key-value pair tags
		//hostName = localhost
		//region = us-east-1
		
		return registry -> registry.config().commonTags("hostName", "localhost", "region", "us-east-1");
	}
}
