package com.ev.workshop.api.tractorworkshop.services;

import com.ev.workshop.api.tractorworkshop.models.Product;
import com.ev.workshop.api.tractorworkshop.models.ServiceOrderProducts;
import com.ev.workshop.api.tractorworkshop.repositories.ProductsRepository;
import com.ev.workshop.api.tractorworkshop.repositories.ServiceOrderProductRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class ProductsService
{
    private final ProductsRepository productRepository;
    private final ServiceOrderProductRepository soProductRepository;

    public ProductsService( ProductsRepository repository, ServiceOrderProductRepository soProduct )
    {
        this.productRepository = repository;
        this.soProductRepository = soProduct;
    }

    public List<Product> getAll( String name, Integer categoryId )
    {
        return productRepository.find( name, categoryId );
    }

    public ServiceOrderProducts addSoProduct( ServiceOrderProducts soProduct )
    {
        return soProductRepository.save( soProduct );
    }

    public List<Object> getOsProducts( Integer osId ) { return soProductRepository.findByOrderId( osId ); }

    public List<ServiceOrderProducts> getAllOsProducts( Integer osId ) { return soProductRepository.findByServiceOrderId( osId ); }

    public ServiceOrderProducts getSoProduct( Integer id )
    {
        return soProductRepository.findById( id ).get();
    }

    public void removeProduct( Integer productId )
    {
        soProductRepository.deleteById( productId );
    }
}
