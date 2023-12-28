package com.sector.service.sectorservice.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan(basePackages = "com.sector.service.sectorservice.infrastructure.mapper")
public class MapperConfig {

        @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
