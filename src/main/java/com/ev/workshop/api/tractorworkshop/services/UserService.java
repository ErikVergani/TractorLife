package com.ev.workshop.api.tractorworkshop.services;

import com.ev.workshop.api.tractorworkshop.models.User;

import java.util.Optional;

public interface UserService {
    public Optional<User> getUserByCpf( String cpf );
}
