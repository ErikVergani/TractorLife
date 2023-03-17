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
    private Integer id;

    @Column( nullable = false, length = 125 )
    private String name;

    @Column( nullable = false )
    private double buyPrice;

    @Column( nullable = false )
    private double sellPrice;

    @Column( nullable = false )
    private Integer qtyStock;

    @OneToOne
    @JoinColumn( name = "ref_category", referencedColumnName = "id" )
    private ProductCategory categoryId;

    @OneToOne
    @JoinColumn( name = "ref_metricUnit", referencedColumnName = "id" )
    private MetricUnit metricUnitId;
}
