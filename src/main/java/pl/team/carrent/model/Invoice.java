package pl.team.carrent.model;


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
    @SequenceGenerator(name = "seqInvoice", sequenceName = "seq_Invoice")
    private int id;
    
    private String number;
    
    @Column(precision = 18, scale = 2)
    private BigDecimal value;
    private LocalDate date;
    
    
    public Invoice(){
    }
    
    
    public Invoice(String number, BigDecimal value, LocalDate date){
        this.number = number;
        this.value = value;
        this.date = date;
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
    
    
    public LocalDate getDate(){
        return date;
    }
    
    
    public void setDate(LocalDate date){
        this.date = date;
    }
    
    
    @Override
    public String toString(){
        return "Invoice{" + "id=" + id + ", number='" + number + '\'' + ", value=" + value + ", date=" + date + '}';
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
