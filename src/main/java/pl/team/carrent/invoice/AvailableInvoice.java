package pl.team.carrent.invoice;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-21 18:57
 * *
 * @className: AvaiableInvoice
 * *
 * *
 ******************************************************/
@Entity
@Table(name = "view_avail_invoices")
public class AvailableInvoice{

    @Id
    private int id;
    private int client_id;
    private String clientName;
    private LocalDate rentTimeStart;
    private int rentDays;
    private LocalDate rentTimeEnd;
    private int distance;
    private String promotionName;
    private String car;
    private BigDecimal rentValue;
    private BigDecimal value;
    
    
    public AvailableInvoice(){
    }
    
    
    public int getId(){
        return id;
    }
    
    
    public int getClient_id(){
        return client_id;
    }
    
    
    public String getClientName(){
        return clientName;
    }
    
    
    public LocalDate getRentTimeStart(){
        return rentTimeStart;
    }
    
    
    public int getRentDays(){
        return rentDays;
    }
    
    
    public LocalDate getRentTimeEnd(){
        return rentTimeEnd;
    }
    
    
    public int getDistance(){
        return distance;
    }
    
    
    public String getPromotionName(){
        return promotionName;
    }
    
    
    public String getCar(){
        return car;
    }
    
    
    public BigDecimal getRentValue(){
        return rentValue;
    }
    
    
    public BigDecimal getValue(){
        return value;
    }
}
