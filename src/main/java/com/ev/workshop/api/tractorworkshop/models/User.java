package com.ev.workshop.api.tractorworkshop.models;

import java.util.Date;
import java.util.Enumeration;

import com.ev.workshop.api.tractorworkshop.Utilities.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "sys_users" )
@Inheritance( strategy = InheritanceType.JOINED )
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String name;
    private String cpf;
    private String address;
    private String phoneNumber1;
    private String phoneNumber2;
    private int city;
    @Enumerated( EnumType.STRING )
    private Role role;
    private boolean enable = true;
    private String email;
    private Date registrationDate = new Date( System.currentTimeMillis() );
}