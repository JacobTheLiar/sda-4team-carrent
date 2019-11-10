package pl.team.carrent.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.team.carrent.model.Invoice;

import java.util.List;
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
}
