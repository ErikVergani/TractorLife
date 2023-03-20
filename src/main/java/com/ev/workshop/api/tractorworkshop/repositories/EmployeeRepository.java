package com.ev.workshop.api.tractorworkshop.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ev.workshop.api.tractorworkshop.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

    @Query( "select e.password from Employee e where login like %?1%" )
    String findTopByLogin( String login );
}
