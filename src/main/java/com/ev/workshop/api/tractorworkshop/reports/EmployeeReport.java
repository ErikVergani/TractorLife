package com.ev.workshop.api.tractorworkshop.reports;

import com.ev.workshop.api.tractorworkshop.models.Employee;

import java.util.List;

public class EmployeeReport extends Report{
    private List<Employee> employeers;

    public EmployeeReport( List<Employee> list )
    {
        super("Relatório de Funcionários");
        this.tableHeaders = new String[]{ "ID", "Nome", "Cpf", "Telefone", "Login", "Cidade", "Ativo"};
        this.tableWidths = new float[]{ 0.05f, 0.15f, 0.18f, 0.17f, 0.10f, 0.15f, 0.08f };
        this.employeers = list;
    }
    @Override
    void generateData() {
        for ( Employee c : this.employeers )
        {
            table.addCell(String.valueOf( c.getId() ) );
            table.addCell( c.getName() );
            table.addCell( c.getCpf() );
            table.addCell( c.getPhoneNumber1() );
            table.addCell( c.getLogin() );
            table.addCell( c.getCity() );
            table.addCell( c.isEnable() ? "Ativo" : "Inativo" );
        }
    }
}
