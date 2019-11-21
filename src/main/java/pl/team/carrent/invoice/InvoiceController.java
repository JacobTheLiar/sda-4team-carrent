package pl.team.carrent.invoice;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    
    private InvoiceViewItemService invoiceViewItemService;
    
    
    
    public InvoiceController(InvoiceViewItemService invoiceViewItemService){
        this.invoiceViewItemService = invoiceViewItemService;
    }
    
    
    @GetMapping
    public ModelAndView getAllInvoices(){
        ModelAndView allInvoices = new ModelAndView("invoiceList");
        allInvoices.addObject("invoices", invoiceViewItemService.getAllInvoices());
        return allInvoices;
    }
    
    
    @GetMapping("/client/{clientId}")
    public ModelAndView getAllClientInvoices(@PathVariable Integer clientId){
        ModelAndView allClientInvoices = new ModelAndView("invoiceList");
        allClientInvoices.addObject("invoices", invoiceViewItemService.getAllClientInvoices(clientId));
        return allClientInvoices;
    }
    
    
}
