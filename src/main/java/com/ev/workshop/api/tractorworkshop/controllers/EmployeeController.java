package com.ev.workshop.api.tractorworkshop.controllers;

import java.util.List;
import java.util.Optional;

import com.ev.workshop.api.tractorworkshop.models.Customer;
import com.ev.workshop.api.tractorworkshop.reports.CustomerReport;
import com.ev.workshop.api.tractorworkshop.reports.EmployeeReport;
import com.ev.workshop.api.tractorworkshop.util.EmployeeValidator;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ev.workshop.api.tractorworkshop.models.Employee;
import com.ev.workshop.api.tractorworkshop.services.EmployeeService;

import jakarta.validation.Valid;

@Controller
@CrossOrigin("*")
@RequestMapping( "/api/employee" )
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController( EmployeeService employeeService ) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Object> saveEmployee( @RequestBody Employee employee )
    {
        String errors = new EmployeeValidator( employee, employeeService ).validateEmployee();

        return errors.isEmpty() ?
                ResponseEntity.status( HttpStatus.CREATED ).body( employeeService.saveEmployee( employee ) )
                : ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( errors );
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee()
    {
        return ResponseEntity.status( HttpStatus.OK ).body( employeeService.getEmployers() );
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Employee>> getEmployee( @RequestParam String name ,@RequestParam String city, @RequestParam String login,
                                                       @RequestParam String enable )
    {

        List<Employee> list = employeeService.getAll( name, city, login, Boolean.parseBoolean( enable ) );
        return ResponseEntity.status( HttpStatus.OK ).body( list );
    }
    
    @GetMapping( "/{id}" )
    public ResponseEntity<Employee> getEmployee( @PathVariable( value = "id" ) Integer id )
    {
        Optional<Employee> employeeOptional = employeeService.getEmployeeById( id );
        return ResponseEntity.status( HttpStatus.CREATED ).body( employeeOptional.get() );
    }

    @PutMapping()
    public ResponseEntity<Object> updateEmployee( @RequestBody Employee employee )
    {
        EmployeeValidator validator = new EmployeeValidator( employee, employeeService );

        validator.setIgnoreLogin( true );
        validator.setIgnoreCpf( true );

        String errors = validator.validateEmployee();

        if ( errors.isEmpty() )
        {
            Optional<Employee> employeeOptional = employeeService.getEmployeeById( employee.getId() );

            employee.setName( employee.getName() );
            employee.setCpf( employee.getCpf() );
            employee.setAddress( employee.getAddress() );
            employee.setPhoneNumber1( employee.getPhoneNumber1() );
            employee.setCity( employee.getCity() );
            employee.setEnable( employee.isEnable() );
            employee.setEmail( employee.getEmail() );
            employee.setLogin( employee.getLogin() );
            employee.setPassword( employee.getPassword() );

            return ResponseEntity.status( HttpStatus.OK ).body( employeeService.saveEmployee( employee ) );
        }

        return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( errors );
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

    @GetMapping( value = "report" )
    public void generateReport(@RequestParam String name ,@RequestParam String city, @RequestParam String login, @RequestParam String enable, HttpServletResponse response  ) throws Exception {

        List<Employee> list = employeeService.getAll( name, city, login, Boolean.parseBoolean( enable ) );

        EmployeeReport report = new EmployeeReport( list );

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Funcionarios.pdf");

        report.generate( response );
    }

}
