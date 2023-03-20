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

import com.ev.workshop.api.tractorworkshop.dtos.CustomerDto;
import com.ev.workshop.api.tractorworkshop.models.Customer;
import com.ev.workshop.api.tractorworkshop.models.User;
import com.ev.workshop.api.tractorworkshop.services.CustomerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    final CustomerService customerService;

    public CustomerController( CustomerService customerService ) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<User> saveCustumer( @RequestBody @Valid CustomerDto customerDto )
    {
        Customer customer = new Customer();
        BeanUtils.copyProperties( customerDto, customer );

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
    public ResponseEntity<Object> updateCustumer( @PathVariable( value = "id" ) Integer id, @RequestBody @Valid CustomerDto customerDto )
    {
        Optional<Customer> userOptional = customerService.getCustomerById( id );

        if ( !userOptional.isPresent() )
        {
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( "User not found" );
        }

        var customer = userOptional.get();

        customer.setName( customerDto.getName() );
        customer.setCpf( customerDto.getCpf() );
        customer.setAddress( customerDto.getAddress() );
        customer.setPhoneNumber1( customerDto.getPhoneNumber1() );
        customer.setPhoneNumber2( customerDto.getPhoneNumber2() );
        customer.setCity( customerDto.getCity() );
        customer.setState( customerDto.getState() );
        customer.setEmail( customerDto.getEmail() );
        customer.setBalanceLimit( customerDto.getBalanceLimit() );
        customer.setDebitBalance( customerDto.getDebitBalance() );

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
