package com.ev.workshop.api.tractorworkshop.controllers;

import com.ev.workshop.api.tractorworkshop.models.Product;
import com.ev.workshop.api.tractorworkshop.models.ServiceOrder;
import com.ev.workshop.api.tractorworkshop.models.ServiceOrderProducts;
import com.ev.workshop.api.tractorworkshop.services.ProductsService;
import com.ev.workshop.api.tractorworkshop.services.ServiceOrderService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/products" )
public class ProductsController
{

    private ProductsService service;
    private ServiceOrderService orderService;

    public ProductsController( ProductsService service, ServiceOrderService orderService )
    {
        this.service = service;
        this.orderService = orderService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Product>> getProducts(@RequestParam String name , @RequestParam String categoryId )
    {
        List<Product> list = service.getAll( name, !categoryId.isEmpty() ? Integer.valueOf( categoryId )  : null );
        return ResponseEntity.status( HttpStatus.OK ).body( list );
    }

    @GetMapping("getAllOsProducts")
    public ResponseEntity<List<Object>> getOsProducts( @RequestParam String osId )
    {
        return ResponseEntity.status( HttpStatus.OK ).body( service.getOsProducts( Integer.valueOf( osId ) ) );
    }

    @PostMapping()
    public ResponseEntity<Object> addSoProduct( @RequestBody ServiceOrderProducts soProduct )
    {
        service.addSoProduct( soProduct );

        updateOsValue( soProduct );

        return ResponseEntity.status( HttpStatus.CREATED ).build();
    }

    @PutMapping()
    public ResponseEntity<Object> editSoProduct( @RequestBody ServiceOrderProducts soProduct )
    {
        service.addSoProduct( soProduct );
        updateOsValue( soProduct );

        return ResponseEntity.status( HttpStatus.OK ).build();
    }

    @DeleteMapping()
    public ResponseEntity<Object> removeProduct( @RequestParam String productId )
    {
        ServiceOrderProducts product = service.getSoProduct( Integer.valueOf( productId ) );

        if ( product != null )
        {
            service.removeProduct( product.getId() );
            updateOsValue( product );
            return ResponseEntity.status( HttpStatus.OK ).build();
        }

        return ResponseEntity.status( HttpStatus.BAD_REQUEST ).build();
    }

    private void updateOsValue( ServiceOrderProducts soProduct )
    {
        List<ServiceOrderProducts> allProducts = service.getAllOsProducts( soProduct.getServiceOrderId() );

        ServiceOrder order = orderService.getOrderById( soProduct.getServiceOrderId() ).get();
        double value = 0;

        for ( ServiceOrderProducts o : allProducts )
        {
            value += o.getTotalPrice();
        }

        order.setSoValue( value );

        orderService.saveSo( order );
    }
}
