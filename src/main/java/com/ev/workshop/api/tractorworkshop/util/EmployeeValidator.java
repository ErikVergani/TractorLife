package com.ev.workshop.api.tractorworkshop.util;

import com.ev.workshop.api.tractorworkshop.models.Employee;
import com.ev.workshop.api.tractorworkshop.models.User;
import com.ev.workshop.api.tractorworkshop.services.EmployeeService;
import com.ev.workshop.api.tractorworkshop.services.UserService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeValidator
    extends UserValidator
{
    private EmployeeService customService;

    private boolean ignoreLogin = false;
    private Employee employee;

    public EmployeeValidator( Employee employee, EmployeeService employeeService )
    {
        super( employee, employeeService );
        this.employee = employee;
        this.customService = employeeService;
    }

    public String validateEmployee()
    {
        String errors = super.validate();
        errors += validateCustomFields();

        return errors;
    }

    private String validateCustomFields()
    {
        String errors = validateLogin();
        errors += validatePassword();

        return errors;
    }

    private String validateLogin()
    {
        this.employee.setLogin( this.employee.getLogin().toLowerCase() );


        return ignoreLogin ? "" : this.employee.getLogin().trim().length() < 2 ? "• Login inválido\n" : customService.findByLogin( this.employee.getLogin() ).isPresent()
                ? "• Login em uso!\n" : "" ;
    }

    private String validatePassword()
    {
        return this.employee.getPassword().trim().length() < 5 ? "• Senha muito curta" : "";
    }

}
