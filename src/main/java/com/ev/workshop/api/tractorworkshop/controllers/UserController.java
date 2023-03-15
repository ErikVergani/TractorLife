package com.ev.workshop.api.tractorworkshop.controllers;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ev.workshop.api.tractorworkshop.dtos.UserDto;
import com.ev.workshop.api.tractorworkshop.models.User;
import com.ev.workshop.api.tractorworkshop.services.UserService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/users")
public class UserController {
    
    final UserService service;

    public UserController( UserService service ) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> saveUser( @RequestBody @Valid UserDto userDto )
    {
        User user = new User();
        BeanUtils.copyProperties( userDto, user );
        return ResponseEntity.status( HttpStatus.CREATED ).body( service.saveUser( user ) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser( @PathVariable( value = "id" ) Integer id )
    {
        Optional<User> uOptional = service.getUserById(id);
        return ResponseEntity.status( HttpStatus.CREATED ).body( uOptional.get() );
    }
}
