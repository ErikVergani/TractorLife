package com.ev.workshop.api.tractorworkshop.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ev.workshop.api.tractorworkshop.Utilities.JwtUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter
{
    public JWTAuthorizationFilter( AuthenticationManager authenticationManager )
    {
        super( authenticationManager );
    }
    
    @Override
    protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain chain ) throws IOException, ServletException
    {
        String header = request.getHeader( JwtUtils.JWT_HEADER_PREFIX );
        
        if ( header == null )
        {
            chain.doFilter( request, response );
            return;
        }
        
        String token = header.substring( JwtUtils.JWT_PREFIX.length() );

        String login = String.valueOf( JWT.require( Algorithm.HMAC512( JwtUtils.SECURITY_KEY.getBytes() ) ).build().verify( token.trim() ).getSubject() );
        
        // pode ser validado com o jpa se o u usuário ainda "existe" e/ou está com o enable true;
        if ( login == null )
        {
            chain.doFilter( request, response );
            return;
        }

        SecurityContextHolder.getContext().setAuthentication( new UsernamePasswordAuthenticationToken( login, null, new ArrayList<>() ) );
        chain.doFilter( request, response );
    }
}
