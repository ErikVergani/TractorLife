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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "sys_service_orders" )
public class ServiceOrder {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    private Date serviceDate = new Date( System.currentTimeMillis() );

    private Date serviceEndDate = new Date( System.currentTimeMillis() );
    private int userId;
    private double soValue;
    private int serviceProducts;
    private int paymentId;
    private boolean state;

    private String title;

    private String description;
}
