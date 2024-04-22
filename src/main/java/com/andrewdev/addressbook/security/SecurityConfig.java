package com.andrewdev.addressbook.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // Standard Spring Security tables
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

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
