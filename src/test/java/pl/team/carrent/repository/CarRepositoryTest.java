package pl.team.carrent.repository;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.model.Car;
import pl.team.carrent.model.CarModel;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 27.10.2019 15:13
 * *
 * @className: CarRepositoryTest
 * *
 * *
 ******************************************************/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CarRepositoryTest {


    @Autowired
    CarRepository carRepository;

    @Test
    public void findByCarModel() {

        LocalDate localDate = LocalDate.of(1999,9,01);
        CarModel myCarModel1 = new CarModel("Skoda","Fabia",1999,30000);
        CarModel myCarModel2 = new CarModel("Renault","Megane",1999,30000);
        Car car1 = new Car(myCarModel1,localDate,"PO12345","VIN1",100.00);
        Car car2 = new Car(myCarModel2,localDate,"PO12346","VIN2",100.00);


        List<Car> listCar = carRepository.findByCarModel(myCarModel1);

        assertThat(listCar).containsExactlyInAnyOrder(car1);
    }
//
//    @Test
//    public void findByPlateNr() {
//    }
//
//    @Test
//    public void findByVin() {
//    }
}