package com.ev.workshop.api.tractorworkshop.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.ev.workshop.api.tractorworkshop.models.Employee;
import com.ev.workshop.api.tractorworkshop.repositories.EmployeeRepository;


public class JwtAuthenticationProvider implements AuthenticationProvider
{

    @Autowired
    EmployeeRepository repository;

    @Override
    public Authentication authenticate (Authentication authentication ) throws AuthenticationException
    {
        String login = authentication.getName();

        Employee user = repository.findByLogin( login ).orElseThrow();

        return new UsernamePasswordAuthenticationToken( user.getLogin(), null, new ArrayList<>()  );
    }

    @Override
    public boolean supports(Class<?> authentication) 
    {
        return authentication.equals( UsernamePasswordAuthenticationToken.class );
    }
}