package com.ev.workshop.api.tractorworkshop.services;

import com.ev.workshop.api.tractorworkshop.models.*;
import com.ev.workshop.api.tractorworkshop.repositories.ServiceOrderProductRepository;
import com.ev.workshop.api.tractorworkshop.repositories.ServiceOrderRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
public class ServiceOrderService
{
    private final ServiceOrderRepository repository;
    private final ServiceOrderProductRepository productRepository;
    public ServiceOrderService( ServiceOrderRepository repository, ServiceOrderProductRepository productRepository )
    {
        this.repository = repository;
        this.productRepository = productRepository;
    }


    @Transactional
    public Object saveSo( ServiceOrder so )
    {
        return repository.save( so );
    }

    @Transactional
    public Object addProduct( ServiceOrderProducts products )
    {
        return productRepository.save( products );
    }

    public List<ServiceOrder> getAll( String title, Date startDate, Date endDate, String customer, boolean closed )
    {
        return repository.find( title, startDate, endDate, closed, customer );
    }
    public Optional<ServiceOrder> getOrderById(Integer id )
    {
        return repository.findById( id );
    }

    public List<Integer> getChartData()
    {
        List<Integer> data = new ArrayList<>();

        data.add( repository.getAllByState( true ).size() );
        data.add( repository.getAllByState( false ).size() );

        return data;

    }
}
