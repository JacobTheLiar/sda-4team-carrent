package pl.team.carrent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CarModel {

    @Id
    @GeneratedValue(generator = "carModelSeq")
    @SequenceGenerator(name = "carModelSeq", sequenceName = "car_model_seq",allocationSize = 1)
    int idCarModel;
    String mark;
    String model;
    String productionYear;
    String reviewInterval;

    public CarModel() {
    }

    public CarModel(String mark, String model, String productionYear, String reviewInterval) {
        this.mark = mark;
        this.model = model;
        this.productionYear = productionYear;
        this.reviewInterval = reviewInterval;
    }

    public int getIdCarModel() {
        return idCarModel;
    }

    public void setIdCarModel(int idCarModel) {
        this.idCarModel = idCarModel;
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
}
