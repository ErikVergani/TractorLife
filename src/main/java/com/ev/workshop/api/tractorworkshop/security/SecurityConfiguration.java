package com.ev.workshop.api.tractorworkshop.security;


import com.ev.workshop.api.tractorworkshop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration
{
    @Autowired
    EmployeeService employeeService;

     @Bean
    public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception
    {
        return http
                .httpBasic()
                .and()
                .cors().disable()
                .authorizeHttpRequests().anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().deleteCookies("JSESSIONID").invalidateHttpSession(true)
                .and()
                .csrf().disable()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(); }
}