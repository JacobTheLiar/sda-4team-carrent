package pl.team.carrent.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 27.10.2019 12:45
 * *
 * @className: RentPoint
 * *
 * *
 ******************************************************/

public class RentPoint {


    @Id
    @GeneratedValue(generator = "carRentPointSeq")
    @SequenceGenerator(name = "carRentPointSeq", sequenceName = "car_rent_point_seq",allocationSize = 1)
    private int id;

    private String name;
    private String address;
    private String postCode;
    private String city;

    public RentPoint() {
    }

    public RentPoint(String name, String address, String postCode, String city) {
        this.name = name;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentPoint rentPoint = (RentPoint) o;
        return id == rentPoint.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
