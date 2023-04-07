package com.ev.workshop.api.tractorworkshop.repositories;

import com.ev.workshop.api.tractorworkshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.workshop.api.tractorworkshop.models.Customer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * UserRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT a FROM Customer a WHERE a.cpf like %?1% and a.name like %?2%" +
            " and a.city like %?3%" +
            " and a.enable = ?4")
    List<Customer> find( String cpf, String name, String city, boolean enable);

    Optional<User> findByCpf( String cpf );
}