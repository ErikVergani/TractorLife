package com.ev.workshop.api.tractorworkshop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDto {
    
    @NotBlank
    public String name;
    
    @NotBlank
    public String cpf;

    @NotBlank
    public String address;

    @NotNull
    public long phoneNumber1;

    @NotNull
    public long phoneNumber2;

    @NotNull
    public Integer city;

    @NotNull
    public Integer userType;

    @NotNull
    public Integer state;

    @NotNull
    public double balanceLimit;

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
