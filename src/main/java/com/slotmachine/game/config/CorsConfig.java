package com.slotmachine.game.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configuration to allow CORS from any origin
        registry.addMapping("/**")  // Allow CORS from any endpoint
                .allowedOrigins("http://localhost:3000")  // Substituate for the url frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")  // HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow sending cookies
    }
}
