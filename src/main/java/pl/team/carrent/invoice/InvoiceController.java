package pl.team.carrent.invoice;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-19 19:15
 * *
 * @className: InvoiceController
 * *
 * *
 ******************************************************/
@Controller
@RequestMapping("invoice")
public class InvoiceController{

    private InvoiceService invoiceService;
    
    
    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }
    
    
    
    public ModelAndView getAllInvoices(){
        
        ModelAndView allInvoices = new ModelAndView("invoiceList.jsp");
        
        return allInvoices;
        
    }
    
}
