package com.ev.workshop.api.tractorworkshop.repositories;

import com.ev.workshop.api.tractorworkshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository
    extends JpaRepository<Product, Integer>
{
    @Query(" SELECT a from Product a where a.name like %?1% or a.categoryId like ?2")
    List<Product> find( String name, Integer categoryId );
}
