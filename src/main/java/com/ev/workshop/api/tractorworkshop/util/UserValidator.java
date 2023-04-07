package com.ev.workshop.api.tractorworkshop.util;

import com.ev.workshop.api.tractorworkshop.models.Customer;
import com.ev.workshop.api.tractorworkshop.services.CustomerService;

public class UserValidator
{
    Customer customer;
    CustomerService service;

    public void setService( CustomerService service )
    {
        this.service = service;
    }

    public void setSource( Customer customer )
    {
        this.customer = customer;
    }

    public String validate() throws Exception {
       String error = "";

       error += validateName();
       error += validateCpf();
       error += validateAddress();
       error += validatePhone();
       error += validateEmail();
       error += validateCity();

      return error;
    }

    private String validateName()
    {
        String customerName = customer.getName().replaceAll("\\s", "" );

        if ( customerName.length() <=3 || customerName.length() > 35 || customerName.isBlank()
                                        || !customerName.matches( "^[A-Za-z]+$" ) )
        {
            return "• Nome inválido!\n";
        }

        return "";
    }

    private String validateCpf()
    {
        String customerCpf = customer.getCpf().replaceAll( "\\.|-", "" );

        return ( !( customerCpf.length() == 11 ) ) ? "• CPF inválido\n" :
                                            service.getCustomerByCpf( customer.getCpf() ).isPresent() ? "CPF em uso" : "";
    }

    private String validateAddress()
    {
        String customerAddress = customer.getAddress().replaceAll( "\\s", "" );
        return customerAddress.length() <= 8 ? "• Endereço inválido\n" : "";
    }

    private String validatePhone()
    {
        String customerPhone = customer.getPhoneNumber1().replaceAll( "-|\\(|\\)|\\s","" );

        return ( customerPhone.length() < 10 || customerPhone.length() > 11 ) ? "• Telefone inválido\n" : "";
    }

    private String validateEmail()
    {
        return customer.getEmail().matches( "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$" )
                                            ? "" : "• Email inválido\n";
    }

    private String validateCity()
    {
        return customer.getCity().replaceAll( "\\s", "" ).length() < 3 ? "• Cidade Inválida\n" : "";
    }
}
