package com.ev.workshop.api.tractorworkshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.workshop.api.tractorworkshop.models.User;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Integer> {


    User getUserById(Integer id);
}