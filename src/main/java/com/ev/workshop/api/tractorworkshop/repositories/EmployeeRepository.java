package com.ev.workshop.api.tractorworkshop.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ev.workshop.api.tractorworkshop.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

    @Query("SELECT u FROM Employee u WHERE u.login like ?1")
    Employee findTopByLogin( String login );

    Optional<Employee> findByLogin( String login );
}
