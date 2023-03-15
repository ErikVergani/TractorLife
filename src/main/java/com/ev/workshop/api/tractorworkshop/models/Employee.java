package com.ev.workshop.api.tractorworkshop.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Employe
 */
@Entity
@Table( name = "tl_employers" )
public class Employee 
{
    @Id
    @OneToOne
    @JoinColumn( name = "ref_user", referencedColumnName = "id" )
    private User userId;

    @Column( nullable = false )
    private double salary;

    @Column( nullable = false )
    private Date startDate;

    @Column( nullable = true )
    private Date endDate;

    @Column( nullable = false )
    private Integer role;

}