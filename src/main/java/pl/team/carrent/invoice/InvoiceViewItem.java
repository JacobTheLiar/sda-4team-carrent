package pl.team.carrent.invoice;


import pl.team.carrent.model.Client;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-20 18:06
 * *
 * @className: InvoiceViewItem
 * *
 * *
 ******************************************************/
@Entity
@Table(name = "view_invoices")
public class InvoiceViewItem{
    
    @Id
    private int id;
    @ManyToOne(targetEntity = Client.class)
    private Client client;
    private String clientName;
    private String number;
    private LocalDate invoiceDate;
    private int rentCount;
    private BigDecimal rentValue;
    private int discounts;
    private BigDecimal value;
    private BigDecimal toPay;
    
    
    public InvoiceViewItem(){
    }
    
    
    public int getId(){
        return id;
    }
    
    
    public Client getClient(){
        return client;
    }
    
    
    public String getClientName(){
        return clientName;
    }
    
    
    public String getNumber(){
        return number;
    }
    
    
    public LocalDate getInvoiceDate(){
        return invoiceDate;
    }
    
    
    public int getRentCount(){
        return rentCount;
    }
    
    
    public BigDecimal getRentValue(){
        return rentValue;
    }
    
    
    public int getDiscounts(){
        return discounts;
    }
    
    
    public BigDecimal getValue(){
        return value;
    }
    
    
    public BigDecimal getToPay(){
        return toPay;
    }
}
