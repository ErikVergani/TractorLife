package com.ev.workshop.api.tractorworkshop.models;

import java.util.Date;

import com.ev.workshop.api.tractorworkshop.enums.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Entity
@Table( name = "sys_users" )
@Inheritance( strategy = InheritanceType.JOINED )
public class User implements GrantedAuthority {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String name;
    private String cpf;
    private String address;
    private String phoneNumber1;
    private int city;
    @Enumerated( EnumType.STRING )
    private Roles role;
    private boolean enable = true;
    private String email;
    private Date registrationDate = new Date( System.currentTimeMillis() );

    @Override
    public String getAuthority() {
        return this.role.toString();
    }
}