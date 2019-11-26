package pl.team.carrent.invoice;


import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-09 14:12
 * *
 * @className: InvoiceService
 * *
 * *
 ******************************************************/
@Service
public class InvoiceService{
    
    private final InvoiceRepository invoiceRepository;
    
    
    public InvoiceService(InvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }
    
    
    public Set<Invoice> getAllInvoices(){
        return new HashSet<>(invoiceRepository.findAll());
    }
    
    
    public Set<Invoice> searchInvoicesByNumber(String invoiceNumber){
        return invoiceRepository.findByNumberContains(invoiceNumber);
    }
    
    
    public Set<Invoice> getAllInvoicesByClientId(int clientId){
        return invoiceRepository.findByClientId(clientId);
    }
    
    
    public Invoice getInvoiceById(int invoiceId){
        return invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new InvoiceNotExistException("invoiceId: " + invoiceId));
    }
    
    public Invoice saveInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }
}
