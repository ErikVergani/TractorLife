package com.ev.workshop.api.tractorworkshop.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "sys_users" )
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( nullable = false, length = 50 )
    private String name;

    @Column( nullable = false, length = 14 )
    private String cpf;

    @Column( nullable = false, length = 255 )
    private String address;

    @Column( nullable = false, length = 13 )
    private long phoneNumber1;

    @Column( nullable = true, length = 13 )
    private long phoneNumber2;

    private Date registrationDate= new Date( System.currentTimeMillis() );

    // @ManyToOne
    // @JoinColumn( name = "ref_city", referencedColumnName = "id" )
    @Column( nullable = false )
    // private City city;
    private Integer city;
 
    @Column( nullable = false, length = 1 )
    private Integer userType;

    @Column( nullable = false )
    private Integer state;

    @Column( nullable = false )
    private double balanceLimit;
}