package com.ev.workshop.api.tractorworkshop.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * PersonModel
 */
@Entity
@Table( name = "tl_users" )
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

    
    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(long phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public long getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(long phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public double getBalanceLimit() {
        return balanceLimit;
    }

    public void setBalanceLimit(double balanceLimit) {
        this.balanceLimit = balanceLimit;
    }

  

    
}