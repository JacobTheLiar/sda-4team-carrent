package pl.team.carrent.invoice;


import org.springframework.data.jpa.repository.JpaRepository;

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

    Set<InvoiceViewItem> findByClientId(int clientId);
    
}
