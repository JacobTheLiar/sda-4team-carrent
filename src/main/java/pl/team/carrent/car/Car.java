package pl.team.carrent.car;


import pl.team.carrent.car_model.CarModel;
import pl.team.carrent.rent_point.RentPoint;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 27.10.2019 12:20
 * *
 * @className: Car
 * *
 * *
 ******************************************************/


@Entity
public class Car {

    @Id
    @GeneratedValue(generator = "carSeq")
    @SequenceGenerator(name = "carSeq", sequenceName = "car_seq", allocationSize = 1)
    private int id;

    @ManyToOne(targetEntity = CarModel.class)
    private CarModel carModel;

    private LocalDate registrationDate;
    private String plateNr;
    private String vin;
    private String color;
    private double pricePerDay;

    @ManyToOne(targetEntity = RentPoint.class)
    private RentPoint beginRentPoint;
    private boolean active;

    public Car() {
    }

    public Car(CarModel carModel, LocalDate registrationDate, String plateNr, String vin, String color, double pricePerDay, RentPoint beginRentPoint) {
        this.carModel = carModel;
        this.registrationDate = registrationDate;
        this.plateNr = plateNr;
        this.vin = vin;
        this.color = color;
        this.pricePerDay = pricePerDay;
        this.beginRentPoint =beginRentPoint;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPlateNr() {
        return plateNr;
    }

    public void setPlateNr(String plateNr) {
        this.plateNr = plateNr;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public RentPoint getBeginRentPoint(){
        return beginRentPoint;
    }

    public void setBeginRentPoint(RentPoint beginRentPoint) {
        this.beginRentPoint = beginRentPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return carModel + " (" + plateNr+")";
    }
}
