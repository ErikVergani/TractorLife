package com.ev.workshop.api.tractorworkshop.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "sys_employers" )
public class Employee
    extends 
        User
{
    private String login;
    private String password;
    private double salary;
    private Date startDate;
    private Date endDate;
}