package com.ev.workshop.api.tractorworkshop.Utilities;

import com.ev.workshop.api.tractorworkshop.models.Employee;
import com.ev.workshop.api.tractorworkshop.models.User;
import com.ev.workshop.api.tractorworkshop.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private EmployeeRepository repository;

    @Autowired
    public DataLoader( EmployeeRepository repository )
    {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if ( repository.findById( 1 ).isEmpty() )
        {
            Employee admin = new Employee();
            admin.setName( "administrador" );
            admin.setRole( Role.ADMIN );
            admin.setLogin( "admin" );
            admin.setPassword( "admin" );
            repository.save( admin );
        }
    }
}
