package pl.team.carrent.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class RentHistory {

    @Id
    private Long id;
    @ManyToOne(targetEntity = Car.class)
    private Car car;
    @ManyToOne(targetEntity = Client.class)
    private Client client;
    @ManyToOne(targetEntity = Promotion.class)
    private Promotion promotion;
    @ManyToOne(targetEntity = RentPoint.class)
    private RentPoint rentPointStart;
    @ManyToOne(targetEntity = RentPoint.class)
    private RentPoint rentPointEnd;
    @ManyToOne(targetEntity = Employee.class)
    private Employee employeeStart;
    @ManyToOne(targetEntity = Employee.class)
    private Employee employeeEnd;
    private LocalDate rentTimeStart;
    private LocalDate rentTimeEnd;
    private int counterStateStart;
    private int counterStateEnd;
    private String notesStart;
    private String notesEnd;
    @ManyToOne
    private Invoice invoice;

    public RentHistory(Long id, Car car, Client client, Promotion promotion, RentPoint rentPointStart, RentPoint rentPointEnd, Employee employeeStart, Employee employeeEnd, LocalDate rentTimeStart, LocalDate rentTimeEnd, int counterStateStart, int counterStateEnd, String notesStart, String notesEnd, Invoice invoice) {
        this.id = id;
        this.car = car;
        this.client = client;
        this.promotion = promotion;
        this.rentPointStart = rentPointStart;
        this.rentPointEnd = rentPointEnd;
        this.employeeStart = employeeStart;
        this.employeeEnd = employeeEnd;
        this.rentTimeStart = rentTimeStart;
        this.rentTimeEnd = rentTimeEnd;
        this.counterStateStart = counterStateStart;
        this.counterStateEnd = counterStateEnd;
        this.notesStart = notesStart;
        this.notesEnd = notesEnd;
        this.invoice = invoice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public RentPoint getRentPointStart() {
        return rentPointStart;
    }

    public void setRentPointStart(RentPoint rentPointStart) {
        this.rentPointStart = rentPointStart;
    }

    public RentPoint getRentPointEnd() {
        return rentPointEnd;
    }

    public void setRentPointEnd(RentPoint rentPointEnd) {
        this.rentPointEnd = rentPointEnd;
    }

    public Employee getEmployeeStart() {
        return employeeStart;
    }

    public void setEmployeeStart(Employee employeeStart) {
        this.employeeStart = employeeStart;
    }

    public Employee getEmployeeEnd() {
        return employeeEnd;
    }

    public void setEmployeeEnd(Employee employeeEnd) {
        this.employeeEnd = employeeEnd;
    }

    public LocalDate getRentTimeStart() {
        return rentTimeStart;
    }

    public void setRentTimeStart(LocalDate rentTimeStart) {
        this.rentTimeStart = rentTimeStart;
    }

    public LocalDate getRentTimeEnd() {
        return rentTimeEnd;
    }

    public void setRentTimeEnd(LocalDate rentTimeEnd) {
        this.rentTimeEnd = rentTimeEnd;
    }

    public int getCounterStateStart() {
        return counterStateStart;
    }

    public void setCounterStateStart(int counterStateStart) {
        this.counterStateStart = counterStateStart;
    }

    public int getCounterStateEnd() {
        return counterStateEnd;
    }

    public void setCounterStateEnd(int counterStateEnd) {
        this.counterStateEnd = counterStateEnd;
    }

    public String getNotesStart() {
        return notesStart;
    }

    public void setNotesStart(String notesStart) {
        this.notesStart = notesStart;
    }

    public String getNotesEnd() {
        return notesEnd;
    }

    public void setNotesEnd(String notesEnd) {
        this.notesEnd = notesEnd;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentHistory that = (RentHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RentHistory{" +
                "id=" + id +
                ", car=" + car +
                ", client=" + client +
                ", promotion=" + promotion +
                ", rentPointStart=" + rentPointStart +
                ", rentPointEnd=" + rentPointEnd +
                ", employeeStart=" + employeeStart +
                ", employeeEnd=" + employeeEnd +
                ", rentTimeStart=" + rentTimeStart +
                ", rentTimeEnd=" + rentTimeEnd +
                ", counterStateStart=" + counterStateStart +
                ", counterStateEnd=" + counterStateEnd +
                ", notesStart='" + notesStart + '\'' +
                ", notesEnd='" + notesEnd + '\'' +
                ", invoice=" + invoice +
                '}';
    }
}
