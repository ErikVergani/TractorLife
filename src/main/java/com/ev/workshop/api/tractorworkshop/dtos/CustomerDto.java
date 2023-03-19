package com.ev.workshop.api.tractorworkshop.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto 
    extends 
        UserDto
{
    private double balanceLimit;
    
    private double debitBalance;
}
