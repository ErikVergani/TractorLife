package com.ev.workshop.api.tractorworkshop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "sys_os_products" )
public class ServiceOrderProducts {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int id;
    private int serviceOrderId;
    private int productId;
    private int qtyUsed;
    private double unitPrice;
    private double totalPrice;

}
