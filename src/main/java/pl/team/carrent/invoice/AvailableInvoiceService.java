package pl.team.carrent.invoice;


import org.springframework.stereotype.Service;

import java.util.Set;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-21 19:59
 * *
 * @className: AvailableInvoiceService
 * *
 * *
 ******************************************************/
@Service
public class AvailableInvoiceService{
    
    private AvailableInvoiceRepository availableInvoiceRepository;
    
    
    public AvailableInvoiceService(AvailableInvoiceRepository availableInvoiceRepository){
        this.availableInvoiceRepository = availableInvoiceRepository;
    }
    
    
    public Set<AvailableInvoice> getAllClientInvoices(int clientId){
        return availableInvoiceRepository.findByClientId(clientId);
    }
}
