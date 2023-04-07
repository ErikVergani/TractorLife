package com.ev.workshop.api.tractorworkshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ev.workshop.api.tractorworkshop.models.Customer;
import com.ev.workshop.api.tractorworkshop.repositories.CustomerRepository;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class CustomerService {
    
    final CustomerRepository customerRepository; 

    public CustomerService( CustomerRepository repository )
    {
        this.customerRepository = repository;
    }

    public List<Customer> getAll( String name, String city, boolean enable) {
        return customerRepository.find( name, city, enable );
    }

    public Optional<Customer> getCustomerByCpf( String cpf )
    {
        return customerRepository.findByCpf( cpf );
    }

    public Optional<Customer> getCustomerById( Integer id )
    {
        return customerRepository.findById( id );
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    @Transactional
    public Customer saveCustomer( Customer customer )
    {
        return customerRepository.save( customer );
    }

    @Transactional
    public void deleteCustomer( Customer customer )
    {
        customerRepository.delete( customer );
    }
}
