package com.ev.workshop.api.tractorworkshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * CityModel
 */
@Entity
@Table( name = "tl_cities" )
public class City
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    
    @Column( nullable = false, length = 75 )
    private String name;

    @Column( nullable = false, length = 2 )
    private String country;

    
}