package com.ufriend.config.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Service
public class CorsHandle {

    @Value("${u-friend.cors.allowed}")
    private String allowed;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                CorsRegistration reg = registry.addMapping("/**");
                for(String url: allowed.split(", ")) {
                    reg.allowedOrigins(url);
                }
            }
        };
    }

}
