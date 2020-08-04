package com.app.rooters.web.security;

import com.app.rooters.web.security.config.JwtConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Marker config to enable component scan in rooters-web-security module.
 */
@Configuration
@ComponentScan
public class WebSecurityConfig {

    @Bean
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }

}
