package com.ev.workshop.api.tractorworkshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ev.workshop.api.tractorworkshop.models.Employee;
import com.ev.workshop.api.tractorworkshop.repositories.EmployeeRepository;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository; 

    public EmployeeService( EmployeeRepository repository )
    {
        this.employeeRepository = repository;
    }

    @Transactional
    public Employee saveEmployee( Employee employee )
    {
        return employeeRepository.save( employee );
    }

    public Optional<Employee> getEmployeeById( Integer id )
    {
        return employeeRepository.findById( id );
    }

    public List<Employee> getEmployers() {
        return employeeRepository.findAll();
    }

    @Transactional
    public void deleteEmployee( Employee employee )
    {
        employeeRepository.delete( employee );
    }
}
