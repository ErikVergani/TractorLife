package com.ev.workshop.api.tractorworkshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.workshop.api.tractorworkshop.models.Customer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * UserRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT a FROM Customer a WHERE a.name like %?1%" +
            " and a.city like %?2%" +
            " and a.enable = ?3 ")
    List<Customer> find( String name, String city, boolean enable);
}