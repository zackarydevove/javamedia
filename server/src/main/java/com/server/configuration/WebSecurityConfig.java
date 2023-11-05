package com.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Define which paths should be secured and which should not
        // Add your custom filters here
        // Disable CSRF for stateless authentication
        http.csrf().disable()
            .authorizeHttpRequests((AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authz) -> 
                authz.antMatchers("/api/auth/login", "/api/auth/register").permitAll()
                      .anyRequest().authenticated()
            );
        
        // Add other configurations, if necessary

        return http.build();
    }
}
