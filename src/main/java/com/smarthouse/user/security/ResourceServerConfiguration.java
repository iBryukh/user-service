package com.smarthouse.user.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/isAliveProtected")
                .hasRole("Admin")
                .antMatchers(HttpMethod.GET, "/isAlive")
                .hasAnyRole("Neighbour", "Admin")
                .anyRequest()
                .authenticated();
    }

}
