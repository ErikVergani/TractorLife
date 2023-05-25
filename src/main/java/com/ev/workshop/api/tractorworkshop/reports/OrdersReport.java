package com.ev.workshop.api.tractorworkshop.reports;

import com.ev.workshop.api.tractorworkshop.models.ServiceOrder;
import com.ev.workshop.api.tractorworkshop.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.List;

public class OrdersReport extends Report
{

    private List<ServiceOrder> orders;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private CustomerService customerService;
    public OrdersReport( List<ServiceOrder> list, CustomerService customerService )
    {
        super("Relatório de Ordens de Serviço");
        this.tableHeaders = new String[]{ "Titulo", "Data Abertura", "Data Fechamento", "Cliente", "Valor Total", "Encerrada" };
        this.tableWidths = new float[]{ 0.5f, 0.12f, 0.12f, 0.10f, 0.10f, 0.10f };
        this.orders = list;
        this.customerService = customerService;
    }
    @Override
    void generateData()
    {
        for ( ServiceOrder o : orders )
        {
            table.addCell( o.getTitle() );
            table.addCell( o.getServiceDate().toString() );
            table.addCell( o.getServiceEndDate() != null ? o.getServiceEndDate().toString() : "-" );
            table.addCell( o.getUserId() != 0 ? customerService.getCustomerById( o.getUserId() ).get().getName() : "-" );
            table.addCell( String.valueOf( o.getSoValue() ) );
            table.addCell( o.isState() ? "Encerrada" : "Fechada");
        }
    }
}
