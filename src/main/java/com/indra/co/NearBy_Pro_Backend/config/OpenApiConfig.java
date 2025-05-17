package com.indra.co.NearBy_Pro_Backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("NearBy Pro API")
                        .description("API documentation for NearBy Pro - A platform connecting users with verified professionals")
                        .version("1.0"));
    }
} 