package com.ev.workshop.api.tractorworkshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "sys_products" )
public class Product {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    private String name;
    private double buyPrice;
    private double sellPrice;
    private int qtyStock;
    private int categoryId;
    private int metricUnitId;
}
