package pl.team.carrent.invoice;


import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-20 18:21
 * *
 * @className: InvoiceViewItemService
 * *
 * *
 ******************************************************/
@Service
public class InvoiceViewItemService{
    
    
    private InvoiceViewItemRepository invoiceViewItemRepository;
    
    
    public InvoiceViewItemService(InvoiceViewItemRepository invoiceViewItemRepository){
        this.invoiceViewItemRepository = invoiceViewItemRepository;
    }
    
    
    public Set<InvoiceViewItem> getAllInvoices(){
        return invoiceViewItemRepository.findAllInvoices();
    }
    
    
    public Set<InvoiceViewItem> getAllClientInvoices(int clientId){
        return invoiceViewItemRepository.findByClientId(clientId);
    }
    
}
