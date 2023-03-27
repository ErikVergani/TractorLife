package com.ev.workshop.api.tractorworkshop.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ev.workshop.api.tractorworkshop.Utilities.JwtUtils;
import com.ev.workshop.api.tractorworkshop.models.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
    private AuthenticationManager authManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager )
    {
        this.authManager = authenticationManager;

         setFilterProcessesUrl( "/login" );

    }

    @Override
    public Authentication attemptAuthentication( HttpServletRequest request, HttpServletResponse response ) throws AuthenticationException
    {
        try 
        {
            Employee  employee = new ObjectMapper().readValue( request.getInputStream(), Employee.class );
            return authManager.authenticate( new UsernamePasswordAuthenticationToken( employee.getLogin(), employee.getPassword(), new ArrayList<>() ) ) ;
        }
        
        catch ( Exception e )
        {
            throw new RuntimeException( e );
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException 
    {
        String token = JWT.create()
                          .withSubject( String.valueOf( authResult.getPrincipal() ) )
                          .withExpiresAt( new Date( System.currentTimeMillis() + JwtUtils.JWT_TOKEN_TIMEOUT ) )
                          .sign( Algorithm.HMAC512( JwtUtils.SECURITY_KEY.getBytes() ) );

        response.getWriter().write( token );
        response.getWriter().flush();
    }
}
