package pl.team.carrent.invoice;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-27 11:44
 * *
 * @className: Invoice
 * *
 * *
 ******************************************************/
@Entity
public class Invoice{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqInvoice")
    @SequenceGenerator(name = "seqInvoice", sequenceName = "seq_Invoice", allocationSize = 1)
    private int id;
    
    private String number;
    
    @Column(precision = 18, scale = 2)
    private BigDecimal value;
    private LocalDate  invoiceDate;
    private LocalDate  paymentDate;
    private LocalDate  sellDate;
    
    
    public Invoice(){
    }
    
    
    public Invoice(String number, BigDecimal value, LocalDate invoiceDate, LocalDate paymentDate, LocalDate sellDate){
        this.number = number;
        this.value = value;
        this.invoiceDate = invoiceDate;
        this.paymentDate = paymentDate;
        this.sellDate = sellDate;
    }
    
    
    public int getId(){
        return id;
    }
    
    
    public String getNumber(){
        return number;
    }
    
    
    public void setNumber(String number){
        this.number = number;
    }
    
    
    public BigDecimal getValue(){
        return value;
    }
    
    
    public void setValue(BigDecimal value){
        this.value = value;
    }
    
    
    public LocalDate getInvoiceDate(){
        return invoiceDate;
    }
    
    
    public void setInvoiceDate(LocalDate invoiceDate){
        this.invoiceDate = invoiceDate;
    }
    
    
    @Override
    public String toString(){
        return "Invoice{" + "id=" + id + ", number='" + number + '\'' + ", value=" + value + ", invoiceDate=" + invoiceDate + ", paymentDate=" + paymentDate + ", sellDate=" + sellDate + '}';
    }
    
    
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id;
    }
    
    
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
