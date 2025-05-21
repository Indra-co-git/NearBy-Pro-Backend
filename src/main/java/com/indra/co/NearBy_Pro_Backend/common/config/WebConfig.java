package com.indra.co.NearBy_Pro_Backend.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders(
                    "Authorization",
                    "Content-Type",
                    "X-Requested-With",
                    "Accept",
                    "Origin",
                    "Access-Control-Request-Method",
                    "Access-Control-Request-Headers",
                    "Access-Control-Allow-Origin",
                    "Access-Control-Allow-Headers",
                    "Access-Control-Allow-Methods",
                    "Referrer-Policy",
                    "referrer-policy"
                )
                .exposedHeaders(
                    "Access-Control-Allow-Origin",
                    "Access-Control-Allow-Credentials",
                    "Access-Control-Allow-Headers",
                    "Access-Control-Allow-Methods",
                    "Referrer-Policy"
                )
                .allowCredentials(true)
                .maxAge(3600);
    }
} 