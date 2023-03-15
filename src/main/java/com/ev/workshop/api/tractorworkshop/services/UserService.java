package com.ev.workshop.api.tractorworkshop.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ev.workshop.api.tractorworkshop.models.User;
import com.ev.workshop.api.tractorworkshop.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    final UserRepository userRepository; 

    public UserService( UserRepository repository )
    {
        this.userRepository = repository;
    }

    @Transactional
    public User saveUser( User user )
    {
        return userRepository.save( user );
    }

    public Optional<User> getUserById( Integer id )
    {
        return userRepository.findById(id);
    }
}
