package com.ev.workshop.api.tractorworkshop.repositories;

import com.ev.workshop.api.tractorworkshop.models.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ServiceOrderRepository
        extends JpaRepository<ServiceOrder, Integer>
{
//    @Query( "select a from ServiceOrder a where a.title like %?1% and (?2 is null or a.serviceDate >= ?2) and  ( ?3 is null or a.serviceEndDate <= ?3 ) " +
//            "and a.state = ?4 order by a.title" )
@Query( "select a,b from ServiceOrder a join Customer b on a.userId = b.id where a.title like %?1% and (?2 is null or a.serviceDate >= ?2) and  ( ?3 is null or a.serviceEndDate <= ?3 ) " +
        "and a.state = ?4 and b.name like %?5% order by a.id" )
    List<ServiceOrder> find( String title, Date startDate, Date endDate, boolean closed, String customerName );

    List<ServiceOrder> getAllByState( boolean state );
}
