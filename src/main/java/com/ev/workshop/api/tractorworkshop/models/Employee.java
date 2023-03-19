package com.ev.workshop.api.tractorworkshop.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "sys_employers" )
public class Employee
    extends User
{
    @Column( nullable = false )
    private String login;

    @Column( nullable = false )
    private String password;

    @Column( nullable = false )
    private double salary;

    @Column( nullable = true )
    private Date startDate;

    @Column( nullable = true )
    private Date endDate;
}