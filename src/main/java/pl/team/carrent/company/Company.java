package pl.team.carrent.company;


import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-12-15 17:20
 * *
 * @className: Company
 * *
 * *
 ******************************************************/
@Entity
public class Company{


    @Id
    private int id;
    
    private String name;
    private String address;
    private String postCode;
    private String city;
    private String telephoneNr;
    private String email;
    private String taxNumber;
    private String accountNumber;
    
    
    
    public Company(){
    }
    
    
    public int getId(){
        return id;
    }
    
    
    public void setId(int id){
        this.id = id;
    }
    
    
    public String getName(){
        return name;
    }
    
    
    public void setName(String name){
        this.name = name;
    }
    
    
    public String getAddress(){
        return address;
    }
    
    
    public void setAddress(String address){
        this.address = address;
    }
    
    
    public String getPostCode(){
        return postCode;
    }
    
    
    public void setPostCode(String postCode){
        this.postCode = postCode;
    }
    
    
    public String getCity(){
        return city;
    }
    
    
    public void setCity(String city){
        this.city = city;
    }
    
    
    public String getTelephoneNr(){
        return telephoneNr;
    }
    
    
    public void setTelephoneNr(String telephoneNr){
        this.telephoneNr = telephoneNr;
    }
    
    
    public String getEmail(){
        return email;
    }
    
    
    public void setEmail(String email){
        this.email = email;
    }
    
    
    public String getTaxNumber(){
        return taxNumber;
    }
    
    
    public void setTaxNumber(String taxNumber){
        this.taxNumber = taxNumber;
    }
    
    
    public String getAccountNumber(){
        return accountNumber;
    }
    
    
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
}
