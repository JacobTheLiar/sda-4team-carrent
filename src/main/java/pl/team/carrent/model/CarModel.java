package pl.team.carrent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
public class CarModel {

    @Id
    @GeneratedValue(generator = "carModelSeq")
    @SequenceGenerator(name = "carModelSeq", sequenceName = "car_model_seq",allocationSize = 1)
    private int id;
    private String mark;
    private String model;
    private String productionYear;
    private String reviewInterval;

    public CarModel() {
    }

    public CarModel(String mark, String model, String productionYear, String reviewInterval) {
        this.mark = mark;
        this.model = model;
        this.productionYear = productionYear;
        this.reviewInterval = reviewInterval;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public String getReviewInterval() {
        return reviewInterval;
    }

    public void setReviewInterval(String reviewInterval) {
        this.reviewInterval = reviewInterval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return id == carModel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
