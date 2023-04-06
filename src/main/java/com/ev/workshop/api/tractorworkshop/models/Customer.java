package com.ev.workshop.api.tractorworkshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "sys_customer" )
public class Customer
    extends User
{
    public Customer(){}

    private double balanceLimit;
    private double debitBalance;
}
