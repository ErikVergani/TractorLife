package com.ev.workshop.api.tractorworkshop.repositories;


import java.util.List;
import java.util.Optional;

import com.ev.workshop.api.tractorworkshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ev.workshop.api.tractorworkshop.models.Employee;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

    Optional<User> findByCpf( String cpf );

    Optional<Employee> findByLogin( String login );

    @Query( "SELECT a" +
            " FROM Employee a " +
                " WHERE a.name like %?1% " +
                        " and a.city like %?2%" +
                        " and a.login like %?3%" +
                        " and a.enable = ?4")
    List<Employee> find( String name, String city, String login, boolean enable);
}
