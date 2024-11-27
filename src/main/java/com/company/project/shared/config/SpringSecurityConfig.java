package com.company.project.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                (auth) -> auth.anyRequest().permitAll()
//                    .requestMatchers( HttpMethod.GET, "/api/products").permitAll()
//                    .requestMatchers( HttpMethod.GET, "/api/product/{search}").permitAll()
//                    .requestMatchers( HttpMethod.POST, "/api/product").permitAll()
//                    .requestMatchers( HttpMethod.PUT, "/api/product/{id}").permitAll()
//                    .requestMatchers( HttpMethod.DELETE, "/api/product/{id}").permitAll()
//                    .requestMatchers( HttpMethod.GET, "/api/user").permitAll()
//                    .requestMatchers( HttpMethod.POST, "/api/user/register").permitAll()
//                    .anyRequest()
//                    .authenticated()
                )
                .csrf(config -> config.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}