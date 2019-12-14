package pl.team.carrent.invoice;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-12-14 12:17
 * *
 * @className: InvoiceViewDetail
 * *
 * *
 ******************************************************/
@Entity
@Table(name = "view_invoice_detail")
public class InvoiceViewDetail{
    
    @Id
    private int id;
    private String invoiceNumber;
    private String    invoiceCity;
    private LocalDate invoiceDate;
    
    private String clientName;
    private String clientAddress;
    private String clientPostCode;
    private String clientCity;
    
    private String sellerName;
    private String sellerAddress;
    private String sellerPostCode;
    private String sellerCity;
    
    private LocalDate paymentDate;
    private String paymentMethod;
    private String     paymentAccount;
    private BigDecimal paymentValue;
    
    
    public InvoiceViewDetail(){
    }
    
    
    public int getId(){
        return id;
    }
    
    
    public String getInvoiceNumber(){
        return invoiceNumber;
    }
    
    
    public String getInvoiceCity(){
        return invoiceCity;
    }
    
    
    public LocalDate getInvoiceDate(){
        return invoiceDate;
    }
    
    
    public String getClientName(){
        return clientName;
    }
    
    
    public String getClientAddress(){
        return clientAddress;
    }
    
    
    public String getClientPostCode(){
        return clientPostCode;
    }
    
    
    public String getClientCity(){
        return clientCity;
    }
    
    
    public String getSellerName(){
        return sellerName;
    }
    
    
    public String getSellerAddress(){
        return sellerAddress;
    }
    
    
    public String getSellerPostCode(){
        return sellerPostCode;
    }
    
    
    public String getSellerCity(){
        return sellerCity;
    }
    
    
    public LocalDate getPaymentDate(){
        return paymentDate;
    }
    
    
    public String getPaymentMethod(){
        return paymentMethod;
    }
    
    
    public String getPaymentAccount(){
        return paymentAccount;
    }
    
    
    public BigDecimal getPaymentValue(){
        return paymentValue;
    }
}
