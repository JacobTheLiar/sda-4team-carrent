package pl.team.carrent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Date;

@Entity
public class Car {

    @Id
    @GeneratedValue(generator = "carSeq")
    @SequenceGenerator(name = "carSeq", sequenceName = "car_seq",allocationSize = 1)
    int idCar;
    int carModelId;
    Date registrationDate;
    String plateNr;
    String vin;
    double pricePerDay;

    public Car() {
    }

    public Car(int carModelId, Date registrationDate, String plateNr, String vin, double pricePerDay) {
        this.carModelId = carModelId;
        this.registrationDate = registrationDate;
        this.plateNr = plateNr;
        this.vin = vin;
        this.pricePerDay = pricePerDay;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(int carModelId) {
        this.carModelId = carModelId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
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

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
