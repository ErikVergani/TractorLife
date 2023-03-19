package com.ev.workshop.api.tractorworkshop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto 
{
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
    public Integer role;

    @NotNull
    public Integer state;

    public String email;
}
