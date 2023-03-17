package com.ev.workshop.api.tractorworkshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "sys_os_products" )
public class ServiceOrderProducts {
    
    @EmbeddedId
    @JoinColumn( name = "ref_serviceOrder", referencedColumnName = "id" )
    @OneToOne
    private ServiceOrder serviceOrderId;

    @EmbeddedId
    @JoinColumn( name = "ref_product", referencedColumnName = "id" )
    @OneToOne
    private Product productId;

    @Column( nullable = false )
    private Integer qtyUsed;

    @Column( nullable = false )
    private double price;

}
