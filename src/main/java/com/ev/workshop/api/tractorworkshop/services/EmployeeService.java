package com.ev.workshop.api.tractorworkshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ev.workshop.api.tractorworkshop.models.Employee;
import com.ev.workshop.api.tractorworkshop.repositories.EmployeeRepository;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class EmployeeService implements UserDetailsService {

    public final EmployeeRepository employeeRepository; 
    private PasswordEncoder encoder;

    public EmployeeService( EmployeeRepository repository )
    {
        this.employeeRepository = repository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Transactional
    public Employee saveEmployee( Employee employee )
    {
        employee.setPassword( encoder.encode( employee.getPassword() ) );
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByLogin( username ).orElseThrow( () -> new UsernameNotFoundException( "User not found with username " + username ) );

        return new User( employee.getUsername(), employee.getPassword(), employee.isEnabled(),true,true,true,employee.getAuthorities() );
    }
}
