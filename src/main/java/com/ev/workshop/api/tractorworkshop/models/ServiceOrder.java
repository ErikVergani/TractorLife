package com.ev.workshop.api.tractorworkshop.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "tl_service_orders" )
public class ServiceOrder {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( nullable = false )
    private Date serviceDate;

    @OneToOne
    @JoinColumn( name = "ref_user", referencedColumnName = "id" )
    private User userId;

    @Column( nullable = false )
    private double osValue;

    @Column( nullable = false )
    private Integer serviceProducts;

    @OneToOne
    @JoinColumn( name = "ref_payment", referencedColumnName = "id" )
    private Payment paymentId;

    @Column( nullable = false )
    private double discount;

    @Column( nullable = false )
    private Integer state;
}
