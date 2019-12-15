package pl.team.carrent.invoice;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-12-14 19:41
 * *
 * @className: InvoiceViewDetailItemsService
 * *
 * *
 ******************************************************/
@Service
public class InvoiceViewDetailItemsService{
    
    private final InvoiceViewDetailItemsRepository invoiceViewDetailItemsRepository;
    
    
    public InvoiceViewDetailItemsService(InvoiceViewDetailItemsRepository invoiceViewDetailItemsRepository){
        this.invoiceViewDetailItemsRepository = invoiceViewDetailItemsRepository;
    }
    
    public List<InvoiceViewDetailItem> getInvoiceItems(int invoiceId){
        return invoiceViewDetailItemsRepository.findAllByInvoiceId(invoiceId);
    }
}
