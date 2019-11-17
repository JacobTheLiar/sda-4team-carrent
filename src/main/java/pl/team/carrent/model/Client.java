package pl.team.carrent.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-27 11:05
 * *
 * @className: Client
 * *
 * *
 ******************************************************/
@Entity
public class Client{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
    @SequenceGenerator(name = "seqClient", sequenceName = "seq_Client", allocationSize = 1)
    private int id;
    
    @NotNull
    private String name;
    private String address;
    private String postCode;
    private String city;
    private String taxNumber;
    private String email;
    private String telephoneNr;
    
    
    public Client(){
    }
    
    
    public Client(String name, String address, String postCode, String city, String taxNumber, String email, String telephoneNr){
        this.name = name;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.taxNumber = taxNumber;
        this.email = email;
        this.telephoneNr = telephoneNr;
    }
    
    
    public int getId(){
        return id;
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
    
    
    public String getTaxNumber(){
        return taxNumber;
    }
    
    
    public void setTaxNumber(String taxNumber){
        this.taxNumber = taxNumber;
    }
    
    
    public String getEmail(){
        return email;
    }
    
    
    public void setEmail(String email){
        this.email = email;
    }
    
    
    public String getTelephoneNr(){
        return telephoneNr;
    }
    
    
    public void setTelephoneNr(String telephoneNr){
        this.telephoneNr = telephoneNr;
    }
    
    
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }
    
    
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
    
    
    @Override
    public String toString(){
        return "Client{" + "id=" + id + ", name='" + name + '\'' + ", address='" + address + '\'' + ", postCode='" + postCode + '\'' + ", city='" + city + '\'' + ", taxNumber='" + taxNumber + '\'' + ", email='" + email + '\'' + ", telephoneNr='" + telephoneNr + '\'' + '}';
    }
    
    
    public void setId(int id){
        this.id = id;
    }
}
