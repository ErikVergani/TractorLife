package com.ev.workshop.api.tractorworkshop.repositories;

import com.ev.workshop.api.tractorworkshop.models.ServiceOrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ServiceOrderProductRepository   extends JpaRepository<ServiceOrderProducts, Integer>
{
    @Query( "select a,b from ServiceOrderProducts a join Product b on a.productId = b.id where a.serviceOrderId = ?1" )
    List<Object> findByOrderId( Integer id );

    List<ServiceOrderProducts> findByServiceOrderId( Integer id );

    Optional<ServiceOrderProducts> findById(Integer id );

    void deleteById(Integer id );
}
