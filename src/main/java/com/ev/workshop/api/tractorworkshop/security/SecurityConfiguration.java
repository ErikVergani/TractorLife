package com.ev.workshop.api.tractorworkshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration
{
    @Autowired
    private JwtAuthenticationProvider provider;   
    
    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception
    {
        return http
                .cors().and()
                .csrf().disable()
                .authorizeHttpRequests().anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS ).and()
                .authenticationProvider( provider )
                .apply( new CustomConfigurator() ).and()
                .httpBasic().and()
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource()
    {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfig = new CorsConfiguration().applyPermitDefaultValues();

        corsConfig.addAllowedMethod( CorsConfiguration.ALL );
        source.registerCorsConfiguration( "/**", corsConfig );

        return source;
    }
        
    public static class CustomConfigurator extends AbstractHttpConfigurer<CustomConfigurator, HttpSecurity>
    {
        @Override
        public void configure( HttpSecurity http ) throws Exception
        {
            AuthenticationManager authenticationManager = http.getSharedObject( AuthenticationManager.class );
            http.addFilterAt( new JWTAuthenticationFilter( authenticationManager ), UsernamePasswordAuthenticationFilter.class );
            http.addFilterAt( new JWTAuthorizationFilter( authenticationManager ), BasicAuthenticationFilter.class );
        }
    }
}