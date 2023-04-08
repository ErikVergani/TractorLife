package com.ev.workshop.api.tractorworkshop.util;

import com.ev.workshop.api.tractorworkshop.models.User;
import com.ev.workshop.api.tractorworkshop.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserValidator
{
    private User user;
    private UserService service;
    private boolean ignoreCpf = false;

    public  UserValidator( User user, UserService service )
    {
        this.user = user;
        this.service = service;
    }
    public void setUser( User user )
    {
        this.user = user;
    }

    public String validate()
    {
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
        user.setName( user.getName().toLowerCase() );
        String customerName = user.getName().replaceAll("\\s", "" );

        if ( customerName.length() <=3 || customerName.length() > 35 || customerName.isBlank()
                                        || !customerName.matches( "^[A-Za-z]+$" ) )
        {
            return "• Nome inválido!\n";
        }

        return "";
    }

    private String validateCpf()
    {

        String customerCpf = user.getCpf().replaceAll( "\\.|-", "" );

        return ignoreCpf ? "" : ( !( customerCpf.length() == 11 ) ) ? "• CPF inválido\n" :
                                            service.getUserByCpf( user.getCpf() ).isPresent() ? "• Já existe um cliente cadastrado com esse cpf\n" : "";
    }

    private String validateAddress()
    {
        String customerAddress = user.getAddress().replaceAll( "\\s", "" );
        return customerAddress.length() <= 8 ? "• Endereço inválido\n" : "";
    }

    private String validatePhone()
    {
        String customerPhone = user.getPhoneNumber1().replaceAll( "-|\\(|\\)|\\s","" );

        return ( customerPhone.length() < 10 || customerPhone.length() > 11 ) ? "• Telefone inválido\n" : "";
    }

    private String validateEmail()
    {
        user.setEmail( user.getEmail().toLowerCase() );
        return user.getEmail().matches( "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$" )
                                            ? "" : "• Email inválido\n";
    }

    private String validateCity()
    {
        return user.getCity().replaceAll( "\\s", "" ).length() <= 3 ? "• Cidade Inválida\n" : "";
    }
}
