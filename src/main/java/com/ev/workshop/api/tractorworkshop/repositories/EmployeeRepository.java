package com.ev.workshop.api.tractorworkshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.workshop.api.tractorworkshop.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
}
