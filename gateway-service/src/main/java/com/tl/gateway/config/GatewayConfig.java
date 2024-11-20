package com.tl.gateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tl.gateway.component.JwtAuthFilter;

@Configuration
public class GatewayConfig {
    @Bean
    public JwtAuthFilter jwtAuthFilter() {
        return new JwtAuthFilter();
    }
}
