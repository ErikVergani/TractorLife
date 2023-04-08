package com.ev.workshop.api.tractorworkshop.controllers;

import java.util.List;
import java.util.Optional;

import com.ev.workshop.api.tractorworkshop.util.UserValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ev.workshop.api.tractorworkshop.models.Customer;
import com.ev.workshop.api.tractorworkshop.services.CustomerService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerController {
    
    final CustomerService customerService;

    public CustomerController( CustomerService customerService ) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCustumer( @RequestBody Customer customer ) throws  Exception
    {
        String errors = new UserValidator( customer, customerService ).validate();

        return errors.isEmpty() ?
                ResponseEntity.status( HttpStatus.CREATED ).body( customerService.saveCustomer( customer ) )
                : ResponseEntity.status( HttpStatus.BAD_REQUEST).body( errors );
    }

    @GetMapping("getAll")
    public  ResponseEntity<List<Customer>>  getAll( @RequestParam String cpf ,@RequestParam String name, @RequestParam String city,
                               @RequestParam String enable ) {

        List<Customer> list = customerService.getAll( cpf, name, city, Boolean.parseBoolean(enable) );
        return ResponseEntity.status( HttpStatus.OK ).body( list );
    }


    @GetMapping
    public ResponseEntity<List<Customer>> getCustumers()
    {
        return ResponseEntity.status( HttpStatus.OK ).body( customerService.getCustomers() );
    }
    
    @GetMapping( "/{id}" )
    public ResponseEntity<Object> getCustumer( @PathVariable( value = "id" ) Integer id )
    {
        Optional<Customer> optional = customerService.getCustomerById( id );

        if ( !optional.isPresent() )
        {
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( "customer not found" );
        }

        return ResponseEntity.status( HttpStatus.CREATED ).body( optional.get() );
    }

    @PutMapping( )
    public ResponseEntity<Object> updateCustumer( @RequestBody Customer customer )
    {
        UserValidator validator =  new UserValidator( customer, customerService );
        validator.setIgnoreCpf( true );

        String errors = validator.validate();

        if ( errors.isEmpty() )
        {
            Optional<Customer> userOptional = customerService.getCustomerById( customer.getId() );

            if ( !userOptional.isPresent() )
            {
                return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( "User not found" );
            }

            customer.setName( customer.getName() );
            customer.setCpf( customer.getCpf() );
            customer.setAddress( customer.getAddress() );
            customer.setPhoneNumber1( customer.getPhoneNumber1() );
            customer.setCity( customer.getCity() );
            customer.setEnable( customer.isEnable() );
            customer.setEmail( customer.getEmail() );
            customer.setBalanceLimit( customer.getBalanceLimit() );
            customer.setDebitBalance( customer.getDebitBalance() );

            return ResponseEntity.status( HttpStatus.OK ).body( customerService.saveCustomer( customer ) );
        }

        return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( errors );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> deleteCustumer( @PathVariable ( value = "id" ) Integer id )
    {
        Optional<Customer> optional = customerService.getCustomerById( id );

        if ( !optional.isPresent() )
        {
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( "User not found" );
        }

        customerService.deleteCustomer( optional.get() );

        return ResponseEntity.status( HttpStatus.OK ).body( "User deleted successfully" );
    }
}
