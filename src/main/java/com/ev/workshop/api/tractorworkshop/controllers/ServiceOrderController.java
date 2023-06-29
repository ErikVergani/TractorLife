package com.ev.workshop.api.tractorworkshop.controllers;

import com.ev.workshop.api.tractorworkshop.models.ServiceOrder;
import com.ev.workshop.api.tractorworkshop.models.ServiceOrderProducts;
import com.ev.workshop.api.tractorworkshop.reports.OrdersReport;
import com.ev.workshop.api.tractorworkshop.services.CustomerService;
import com.ev.workshop.api.tractorworkshop.services.ServiceOrderService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping( "/api/os")
public class ServiceOrderController {
    private final ServiceOrderService service;
    private final CustomerService customerService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ServiceOrderController(ServiceOrderService service, CustomerService customerService) {
        this.service = service;
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Object> saveSO(@RequestBody ServiceOrder so) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveSo(so));
    }

    @PutMapping()
    public ResponseEntity<Object> updateCustumer(@RequestBody ServiceOrder order) {
        Optional<ServiceOrder> orderOptional = service.getOrderById(order.getId());

        if (!orderOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS not found");
        }

        order.setServiceDate(orderOptional.get().getServiceDate());
        if (order.isState()) {
            order.setServiceEndDate(new Date(System.currentTimeMillis()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.saveSo(order));
    }

    @GetMapping("getAll")
    public  ResponseEntity<List<ServiceOrder>> getAll(@RequestParam String filterTitle , @RequestParam String startDate, @RequestParam String endDate, @RequestParam String customer,
                                                   @RequestParam String closed ) throws Exception {

        List<ServiceOrder> list = service.getAll( filterTitle, !startDate.isEmpty() ? sdf.parse( startDate ) : null, !endDate.isEmpty() ? sdf.parse(endDate) : null, customer , Boolean.parseBoolean(closed) );

        return ResponseEntity.status( HttpStatus.OK ).body( list );
    }

    @GetMapping( "getSoById" )
    public ResponseEntity<Object> getSoById( @RequestParam Integer orderId )
    {
        Optional<ServiceOrder> optional = service.getOrderById( orderId );

        if ( !optional.isPresent() )
        {
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( "customer not found" );
        }

        return ResponseEntity.status( HttpStatus.OK ).body( optional.get() );
    }

    @PostMapping("/addproduct")
    public ResponseEntity<Object> addProduct(@RequestBody ServiceOrderProducts product )
    {
        return ResponseEntity.status( HttpStatus.CREATED ).body( service.addProduct( product ) );
    }

    @GetMapping( value = "pdf" )
    public void generateReport( @RequestParam String filterTitle , @RequestParam String startDate, @RequestParam String endDate, @RequestParam String customer, @RequestParam String closed,  HttpServletResponse response  ) throws Exception
    {
        List<ServiceOrder> list = service.getAll( filterTitle, !startDate.isEmpty() ? sdf.parse( startDate ) : null, !endDate.isEmpty() ? sdf.parse( endDate ) : null, customer , Boolean.parseBoolean(closed) );

        OrdersReport report = new OrdersReport( list, customerService );

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Ordens.pdf");

        report.generate( response );
    }

    @GetMapping( value = "csv" )
    public void generateCsv( @RequestParam String filterTitle , @RequestParam String startDate, @RequestParam String endDate, @RequestParam String customer, @RequestParam String closed,  HttpServletResponse response  ) throws Exception
    {
        List<ServiceOrder> list = service.getAll( filterTitle, !startDate.isEmpty() ? sdf.parse( startDate ) : null, !endDate.isEmpty() ? sdf.parse( endDate ) : null, customer , Boolean.parseBoolean(closed) );

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=OrdensServiço.csv");

        ICsvBeanWriter csvWriter = new CsvBeanWriter( response.getWriter(), CsvPreference.STANDARD_PREFERENCE );
        String[] csvHeader = { "ID", "Título", "Data Abertura", "Data Fechamento", "Cliente", "pgto", "Valor Total", "Ecerrada" };
        String[] nameMapping = { "id", "title", "serviceDate", "serviceEndDate", "userId", "paymentId", "soValue", "state" };

        csvWriter.writeHeader( csvHeader );

        for ( ServiceOrder o : list )
        {
            csvWriter.write( o, nameMapping );
        }

        csvWriter.close();
    }

    @GetMapping( "getChartData" )
    public ResponseEntity<List<Integer>> getChartData()
    {
        return ResponseEntity.status( HttpStatus.OK ).body( service.getChartData() );
    }
}
