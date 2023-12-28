package com.sector.service.sectorservice.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration

public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("RESTful API by Carlos Almanza with Spring Boot")
                .version("v1")
                .description("Esta api presta los servicios sectores necesarios para el funcionamiento de report. app")
                .termsOfService("url github")
                .license(new License()
                        .name("MIT")
                        .url("url de github")));
    }
}
