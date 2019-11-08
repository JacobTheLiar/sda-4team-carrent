package pl.team.carrent.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.model.Car;
import pl.team.carrent.model.CarModel;
import pl.team.carrent.model.CarReview;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 30.10.2019 20:11
 * *
 * @className: CarReviewRepositoryTest
 * *
 * *
 ******************************************************/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CarReviewRepositoryTest {

    @Autowired
    CarReviewRepository carReviewRepository;

    @Autowired
    CarModelRepository carModelRepository;

    @Autowired
    CarRepository carRepository;

    @Test
    public void shouldFindByCar_PlateNr() {
        //given
        LocalDate localDate = LocalDate.of(1999, 9, 01);
        CarModel myCarModel1 = new CarModel("Skoda", "Fabia", 1999, 30000);
        carModelRepository.save(myCarModel1);
        Car car1 = new Car(myCarModel1, localDate, "PO12346", "VIN0", 100.00);
        carRepository.save(car1);
        CarReview carReview = new CarReview(car1, 30000, localDate);
        carReviewRepository.save(carReview);

        //when
        Optional<CarReview> carReview1 = carReviewRepository.findByCar_PlateNr("PO12346");

        //then
        Assert.assertTrue("could find by plate 1 car", carReview1.isPresent());
    }

    @Test
    public void shouldDontFindByCar_PlateNr() {
        Optional<CarReview> carReviewToFound = carReviewRepository.findByCar_PlateNr("PO00001");
        Assert.assertFalse("couldn't find by plate any car", carReviewToFound.isPresent());
    }

    @Test
    public void shouldFindByCar_Vin() {
        //given
        LocalDate localDate = LocalDate.of(1999, 9, 01);
        CarModel myCarModel1 = new CarModel("Skoda", "Fabia", 1999, 30000);
        carModelRepository.save(myCarModel1);
        Car car1 = new Car(myCarModel1, localDate, "PO1X345", "VIN10", 100.00);
        carRepository.save(car1);
        CarReview carReview = new CarReview(car1, 30000, localDate);
        carReviewRepository.save(carReview);

        //when
        Optional<CarReview> carReviewToFound = carReviewRepository.findByCar_Vin("VIN10");

        //then
        Assert.assertTrue("could find by plate 1 car", carReviewToFound.isPresent());
    }

    @Test
    public void shouldFindByReviewDateBetween() {
        //given
        LocalDate localDate = LocalDate.of(1900, 9, 01);
        LocalDate localDateReview = LocalDate.of(1910, 9, 01);
        LocalDate localDateFrom = LocalDate.of(1899, 9, 01);
        LocalDate localDateTo = LocalDate.of(1911, 9, 01);
        CarModel myCarModel1 = new CarModel("Skoda", "Fabia", 1999, 30000);
        carModelRepository.save(myCarModel1);
        Car car1 = new Car(myCarModel1, localDate, "PO12345", "VIN1", 100.00);
        carRepository.save(car1);
        CarReview carReview = new CarReview(car1, 30000, localDateReview);
        carReviewRepository.save(carReview);

        //when
        List<CarReview> carReviewToFound = carReviewRepository.findByReviewDateBetween(localDateFrom, localDateTo);

        //then
        Assert.assertEquals("could find by plate 1 car", 1, carReviewToFound.size());
    }

    @Test
    public void shouldFindByReviewDateBefore() {
        //given
        LocalDate localDate = LocalDate.of(1800, 9, 01);
        LocalDate localDateReview = LocalDate.of(1801, 9, 01);
        LocalDate localDateFrom = LocalDate.of(1850, 9, 01);
        CarModel myCarModel1 = new CarModel("Skoda", "Fabia", 1999, 30000);
        carModelRepository.save(myCarModel1);
        Car car1 = new Car(myCarModel1, localDate, "PO12345", "VIN1", 100.00);
        carRepository.save(car1);
        CarReview carReview = new CarReview(car1, 30000, localDateReview);
        carReviewRepository.save(carReview);

        //when
        List<CarReview> carReviewToFound = carReviewRepository.findByReviewDateBefore(localDateFrom);

        //then
        Assert.assertEquals("could find by plate 1 car", 1, carReviewToFound.size());
    }

    @Test
    public void shouldFindByReviewDateAfter() {
        //given
        LocalDate localDate = LocalDate.of(2017, 9, 01);
        LocalDate localDateReview = LocalDate.of(2018, 9, 01);
        LocalDate localDateAfter = LocalDate.of(2016, 9, 01);
        CarModel myCarModel1 = new CarModel("Skoda", "Fabia", 1999, 30000);
        carModelRepository.save(myCarModel1);
        Car car1 = new Car(myCarModel1, localDate, "PO12345", "VIN1", 100.00);
        carRepository.save(car1);
        CarReview carReview = new CarReview(car1, 30000, localDateReview);
        carReviewRepository.save(carReview);

        //when
        List<CarReview> carReviewToFound = carReviewRepository.findByReviewDateAfter(localDateAfter);

        //then
        Assert.assertEquals("could find by plate 1 car", carReviewToFound.size(), 1);
    }
}