package pl.team.carrent.invoice;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-12-14 19:40
 * *
 * @className: InvoiceViewDetailItemsRepository
 * *
 * *
 ******************************************************/
public interface InvoiceViewDetailItemsRepository extends JpaRepository<InvoiceViewDetailItem, Integer>{
    
    public List<InvoiceViewDetailItem> findAllByInvoiceId(int id);
    
}
