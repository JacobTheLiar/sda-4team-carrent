package pl.team.carrent.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Promotion {

    @Id
    @GeneratedValue(generator = "promoSeq")
    @SequenceGenerator(name = "promoSeq", sequenceName = "promo_seq",
            allocationSize = 1)
    private int id;

    @NotNull
    private String name;
    @NotNull
    private int discountPercentage;
    @NotNull
    private LocalDate promoStart;
    @NotNull
    private LocalDate promoEnd;


    @ManyToMany(targetEntity = Car.class)
    private List<Car> cars;

    @ManyToMany(targetEntity = CarModel.class)
    private List<CarModel> carModels;

    @ManyToMany(targetEntity = Client.class)
    private List<Client> clients;


    public Promotion() {
    }

    public Promotion(String name, int discountPercentage, LocalDate promoStart, LocalDate promoEnd,
                     List<Car> cars, List<CarModel> carModels, List<Client> clients) {
        this.name = name;
        this.discountPercentage = discountPercentage;
        this.promoStart = promoStart;
        this.promoEnd = promoEnd;
        this.cars = cars;
        this.carModels = carModels;
        this.clients = clients;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public LocalDate getPromoStart() {
        return promoStart;
    }

    public void setPromoStart(LocalDate promoStart) {
        this.promoStart = promoStart;
    }

    public LocalDate getPromoEnd() {
        return promoEnd;
    }

    public void setPromoEnd(LocalDate promoEnd) {
        this.promoEnd = promoEnd;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<CarModel> getCarModels() {
        return carModels;
    }

    public void setCarModels(List<CarModel> carModels) {
        this.carModels = carModels;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promotion promotion = (Promotion) o;
        return id == promotion.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}