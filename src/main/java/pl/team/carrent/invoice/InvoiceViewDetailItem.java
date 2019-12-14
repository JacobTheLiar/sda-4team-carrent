package pl.team.carrent.invoice;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-12-14 19:37
 * *
 * @className: InvoiceViewDetailItems
 * *
 * *
 ******************************************************/

@Entity
@Table(name = "view_invoice_detail_items")
public class InvoiceViewDetailItem{
    
    @Id
    private int id;
    private int invoiceId;
    private String     car;
    private int        distance;
    private int        rentDays;
    private String     promotionName;
    private BigDecimal value;
    
    
    public InvoiceViewDetailItem(){
    }
    
    
    public int getId(){
        return id;
    }
    
    public int getInvoiceId(){
        return invoiceId;
    }
    
    public String getCar(){
        return car;
    }
    
    
    public int getDistance(){
        return distance;
    }
    
    
    public int getRentDays(){
        return rentDays;
    }
    
    
    public String getPromotionName(){
        return promotionName;
    }
    
    
    public BigDecimal getValue(){
        return value;
    }
    
    
}
