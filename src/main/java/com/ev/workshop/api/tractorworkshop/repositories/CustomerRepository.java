package com.ev.workshop.api.tractorworkshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.workshop.api.tractorworkshop.models.Customer;

/**
 * UserRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}