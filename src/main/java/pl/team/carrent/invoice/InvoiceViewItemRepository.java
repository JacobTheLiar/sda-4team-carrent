package pl.team.carrent.invoice;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-20 18:20
 * *
 * @className: InvoiceViewItemRepository
 * *
 * *
 ******************************************************/
public interface InvoiceViewItemRepository extends JpaRepository<InvoiceViewItem, Integer>{
    
    
    @Query(value = "select i.* from view_invoices i where i.client_id = :id", nativeQuery = true)
    Set<InvoiceViewItem> findByClientId(@Param("id") int clientId);
    
    @Query(value = "select i.* from view_invoices i", nativeQuery = true)
    Set<InvoiceViewItem> findAllInvoices();
    
    
    
}
