package pl.team.carrent.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.team.carrent.model.Invoice;

import java.util.List;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-27 15:01
 * *
 * @className: InvoiceRepository
 * *
 * *
 ******************************************************/
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

    List<Invoice> findByNumberContains(String number);
    
    
}
