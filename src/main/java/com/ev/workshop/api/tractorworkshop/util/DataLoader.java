package com.ev.workshop.api.tractorworkshop.Utilities;

import com.ev.workshop.api.tractorworkshop.enums.Roles;
import com.ev.workshop.api.tractorworkshop.models.Employee;
import com.ev.workshop.api.tractorworkshop.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner
{
    @Autowired
    private EmployeeRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if ( repository.findById( 1 ).isEmpty() )
        {

            Employee admin = new Employee();
            admin.setName( "administrador" );
            admin.setRole( Roles.ADMIN );
            admin.setLogin( "admin" );
            admin.setPassword( "$2a$10$Cci7EDeihOp8HDicWE6Py.i3FT/cnvyYxb0E4CSwECTCOawM6nKE6" );
            repository.save( admin );
        }
    }
}
