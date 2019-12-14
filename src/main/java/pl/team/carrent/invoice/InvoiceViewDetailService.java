package pl.team.carrent.invoice;


import org.springframework.stereotype.Service;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-12-14 12:29
 * *
 * @className: InvoiceViewDetialService
 * *
 * *
 ******************************************************/
@Service
public class InvoiceViewDetailService{
    
    private final InvoiceViewDetailRepository invoiceViewDetailRepository;
    
    
    public InvoiceViewDetailService(InvoiceViewDetailRepository invoiceViewDetailRepository){
        this.invoiceViewDetailRepository = invoiceViewDetailRepository;
    }
    
    
    public InvoiceViewDetail getInvoiceDetail(int invoiceId){
        return invoiceViewDetailRepository.findById(invoiceId)
                .orElseThrow(() -> new InvoiceNotExistException("invoiceId: " + invoiceId));
    }
}
