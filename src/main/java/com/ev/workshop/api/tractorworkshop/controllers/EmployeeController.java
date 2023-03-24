package com.ev.workshop.api.tractorworkshop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ev.workshop.api.tractorworkshop.models.Employee;
import com.ev.workshop.api.tractorworkshop.services.EmployeeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping( "/employee" )
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController( EmployeeService employeeService ) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee( @RequestBody Employee employee )
    {
        return ResponseEntity.status( HttpStatus.CREATED ).body( employeeService.saveEmployee( employee ) );
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee()
    {
        return ResponseEntity.status( HttpStatus.OK ).body( employeeService.getEmployers() );
    }
    
    @GetMapping( "/{id}" )
    public ResponseEntity<Employee> getEmployee( @PathVariable( value = "id" ) Integer id )
    {
        Optional<Employee> employeeOptional = employeeService.getEmployeeById( id );
        return ResponseEntity.status( HttpStatus.CREATED ).body( employeeOptional.get() );
    }

    @GetMapping( "/oi/{login}" )
    public ResponseEntity<Employee> getEmployee( @PathVariable( value = "login" ) String id )
    {
        return ResponseEntity.status( HttpStatus.CREATED ).body(employeeService.passwordValidation( id ) );
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Object> updateEmployee( @PathVariable( value = "id" ) Integer id, @RequestBody Employee employee )
    {
        Optional<Employee> employeeOptional = employeeService.getEmployeeById( id );

        if ( !employeeOptional.isPresent() )
        {
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( "User not found" );
        }

        // @TODO: 23/03/2023 Necessário fazer o update das demais coisas da classe User

        employee.setLogin( employee.getLogin() );
        employee.setPassword( employee.getPassword() );
        employee.setSalary( employee.getSalary() );
        employee.setEndDate( employee.getEndDate() );

        return ResponseEntity.status( HttpStatus.OK ).body( employeeService.saveEmployee( employee ) );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> deleteEmployee( @PathVariable ( value = "id" ) Integer id )
    {
        Optional<Employee> employeeOptional = employeeService.getEmployeeById( id );

        if ( !employeeOptional.isPresent() )
        {
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( "User not found" );
        }

        employeeService.deleteEmployee( employeeOptional.get() );

        return ResponseEntity.status( HttpStatus.OK ).body( "User deleted successfully" );
    }
}
