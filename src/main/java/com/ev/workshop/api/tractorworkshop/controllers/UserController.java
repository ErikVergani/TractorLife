package com.ev.workshop.api.tractorworkshop.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ev.workshop.api.tractorworkshop.dtos.UserDto;
import com.ev.workshop.api.tractorworkshop.models.User;
import com.ev.workshop.api.tractorworkshop.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    
    final UserService userService;

    public UserController( UserService userService ) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> saveUser( @RequestBody @Valid UserDto userDto )
    {
        User user = new User();
        BeanUtils.copyProperties( userDto, user );
        return ResponseEntity.status( HttpStatus.CREATED ).body( userService.saveUser( user ) );
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers()
    {
        return ResponseEntity.status( HttpStatus.OK ).body( userService.getUsers() );
    }
    
    @GetMapping( "/{id}" )
    public ResponseEntity<User> getUser( @PathVariable( value = "id" ) Integer id )
    {
        Optional<User> uOptional = userService.getUserById( id );
        return ResponseEntity.status( HttpStatus.CREATED ).body( uOptional.get() );
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Object> updateUser( @PathVariable( value = "id" ) Integer id, @RequestBody @Valid UserDto userDto )
    {
        Optional<User> userOptional = userService.getUserById( id );

        if ( !userOptional.isPresent() )
        {
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( "User not found" );
        }

        var user = userOptional.get();

        user.setName( userDto.getName() );
        user.setCpf( userDto.getCpf() );
        user.setAddress( userDto.getAddress() );
        user.setPhoneNumber1( userDto.getPhoneNumber1() );
        user.setPhoneNumber2( userDto.getPhoneNumber2() );
        user.setCity( userDto.getCity() );
        user.setState( userDto.getState() );
        user.setBalanceLimit( userDto.getBalanceLimit() );

        return ResponseEntity.status( HttpStatus.OK ).body( userService.saveUser( user ) );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> deleteUser( @PathVariable ( value = "id" ) Integer id )
    {
        Optional<User> userOptional = userService.getUserById( id );

        if ( !userOptional.isPresent() )
        {
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( "User not found" );
        }

        userService.deleteUser( userOptional.get() );

        return ResponseEntity.status( HttpStatus.OK ).body( "User deleted successfully" );
    }

}
