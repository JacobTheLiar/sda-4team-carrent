package pl.team.carrent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 27.10.2019 12:20
 * *
 * @className: CarModel
 * *
 * *
 ******************************************************/

@Entity
public class CarModel {

    @Id
    @GeneratedValue(generator = "carModelSeq")
    @SequenceGenerator(name = "carModelSeq", sequenceName = "car_model_seq", allocationSize = 1)
    private int id;
    private String mark;
    private String model;
    private String segment;
    private String type;
    private int productionYear;
    private int reviewInterval;

    public CarModel() {
    }

    public CarModel(String mark, String model, String segment, String type, int productionYear, int reviewInterval) {
        this.mark = mark;
        this.model = model;
        this.segment = segment;
        this.type = type;
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

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getReviewInterval() {
        return reviewInterval;
    }

    public void setReviewInterval(int reviewInterval) {
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
