package com.andrewdev.addressbook.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeHttpRequests(configurer -> configurer.anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateUser")
                        .permitAll())
                .logout(logout -> logout.permitAll());

        return httpSecurity.build();
    }
}
