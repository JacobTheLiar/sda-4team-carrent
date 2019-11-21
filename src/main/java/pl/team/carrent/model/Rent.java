package pl.team.carrent.model;

import org.springframework.format.annotation.DateTimeFormat;
import pl.team.carrent.client.Client;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 27.10.2019 12:49
 * *
 * @className: Rent
 * *
 * *
 ******************************************************/
@Entity
public class Rent {

    @Id
    @GeneratedValue(generator = "carRentSeq")
    @SequenceGenerator(name = "carRentSeq", sequenceName = "car_rent_seq", allocationSize = 1)
    private int id;

    @ManyToOne(targetEntity = Car.class)
    private Car car;

    @ManyToOne(targetEntity = Client.class)
    private Client client;

    @ManyToOne(targetEntity = Promotion.class)
    private Promotion promotion;

    @ManyToOne(targetEntity = RentPoint.class)
    private RentPoint rentPointStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentTimeStart;

    @ManyToOne(targetEntity = Employee.class)
    private Employee employeeStart;

    private int counterStateStart;

    private String notes;


    public Rent() {
    }

    public Rent(Car car, Client client, Promotion promotion, RentPoint rentPointStart, LocalDate rentTimeStart, Employee employeeStart, int counterStateStart, String notes) {
        this.car = car;
        this.client = client;
        this.promotion = promotion;
        this.rentPointStart = rentPointStart;
        this.rentTimeStart = rentTimeStart;
        this.employeeStart = employeeStart;
        this.counterStateStart = counterStateStart;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotionId(Promotion promotion) {
        this.promotion = promotion;
    }

    public RentPoint getRentPointStart() {
        return rentPointStart;
    }

    public void setRentPointStart(RentPoint rentPointStart) {
        this.rentPointStart = rentPointStart;
    }

    public LocalDate getRentTimeStart() {
        return rentTimeStart;
    }

    public void setRentTimeStart(LocalDate rentTimeStart) {
        this.rentTimeStart = rentTimeStart;
    }

    public Employee getEmployeeStart() {
        return employeeStart;
    }

    public void setEmployeeStart(Employee employeeStart) {
        this.employeeStart = employeeStart;
    }

    public int getCounterStateStart() {
        return counterStateStart;
    }

    public void setCounterStateStart(int counterStateStart) {
        this.counterStateStart = counterStateStart;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return id == rent.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
