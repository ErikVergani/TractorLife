package com.ev.workshop.api.tractorworkshop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ev.workshop.api.tractorworkshop.models.Customer;
import com.ev.workshop.api.tractorworkshop.models.User;
import com.ev.workshop.api.tractorworkshop.services.CustomerService;

import jakarta.validation.Valid;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerController {
    
    final CustomerService customerService;

    public CustomerController( CustomerService customerService ) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<User> saveCustumer( @RequestBody Customer customer )
    {
        return ResponseEntity.status( HttpStatus.CREATED ).body( customerService.saveCustomer( customer ) );
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

    @PutMapping( "/{id}" )
    public ResponseEntity<Object> updateCustumer( @PathVariable( value = "id" ) Integer id, @RequestBody Customer customer )
    {
        Optional<Customer> userOptional = customerService.getCustomerById( id );

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
