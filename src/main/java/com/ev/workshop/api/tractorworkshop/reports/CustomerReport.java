package com.ev.workshop.api.tractorworkshop.reports;

import com.ev.workshop.api.tractorworkshop.models.Customer;

import java.util.List;

public class CustomerReport extends Report{

    private List<Customer> customers;

    public CustomerReport( List<Customer> customers )
    {
        super("Relatório de clientes");
        this.tableHeaders = new String[]{ "ID", "Nome", "Cpf", "Telefone", "Cidade", "Ativo"};
        this.tableWidths = new float[]{ 0.05f, 0.15f, 0.18f, 0.17f, 0.15f, 0.08f };
        this.customers = customers;
    }
    @Override
    void generateData() {
        for ( Customer c : this.customers )
        {
            table.addCell(String.valueOf( c.getId() ) );
            table.addCell( c.getName() );
            table.addCell( c.getCpf() );
            table.addCell( c.getPhoneNumber1() );
            table.addCell( c.getCity() );
            table.addCell( c.isEnable() ? "Ativo" : "Inativo" );
        }
    }
}
