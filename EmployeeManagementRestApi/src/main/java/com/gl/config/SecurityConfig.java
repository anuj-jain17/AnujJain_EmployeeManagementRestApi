package com.gl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;

//@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/h2-console/**").permitAll() // Allow access to H2 Console
            .antMatchers("/api/roles/**", "/api/users/**").permitAll()
            .antMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("admin", "user")
            .antMatchers(HttpMethod.POST, "/api/employees/**").hasRole("admin")
            .antMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("admin")
            .antMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("admin")
            .anyRequest().authenticated() 
            .and()
            .headers().frameOptions().disable() 
            .and()
            .csrf().disable()
            .httpBasic();
    }

   

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }
}
