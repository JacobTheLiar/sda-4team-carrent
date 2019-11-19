package pl.team.carrent.invoice;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.team.carrent.invoice.Invoice;

import java.util.Set;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-27 15:01
 * *
 * @className: InvoiceRepository
 * *
 * *
 ******************************************************/
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
    
    Set<Invoice> findByNumberContains(String number);
    
    @Query(value = "select i.* from invoice i join rent_history rh on rh.invoice_id=i.id where rh.client_id=:clientId", nativeQuery = true)
    Set<Invoice> findByClientId(int clientId);
    
/*
create view view_invoices as
select
    cli.id as client_id
    ,cli.name
    ,i.number
    ,i.invoice_date
    ,count(*) as rent_count
    ,sum((datediff(day, rent_time_start, rent_time_end)+1) * c.price_per_day) as rent_value
    ,count(distinct p.id) as discounts
    ,sum((datediff(day, rent_time_start, rent_time_end)+1) * c.price_per_day * (100-ifNull(p.discount_percentage, 0))/100) as invoice_value
from invoice i
    join rent_history rh
        on rh.invoice_id = i.id
    join car c
        on c.id=rh.car_id
    left join promotion p
        on p.id=rh.promotion_id
    join client cli
        on cli.id = rh.client_id
group by
    cli.id, cli.name, i.number, i.invoice_date
    
    
    
    
*/


}
