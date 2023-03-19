package com.ev.workshop.api.tractorworkshop.dtos;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto 
    extends
        UserDto
{
    @NotBlank
    public String login;
    
    @NotBlank
    public String password;

    @NotNull
    public double salary;

    public Date endDate;
}
