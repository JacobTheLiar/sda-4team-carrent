package pl.team.carrent.repository;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.car.Car;

import javax.transaction.Transactional;
import java.util.*;

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
@Transactional
public class CarRepositoryTest {


    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarModelRepository carModelRepository;



    @Test
    public void shouldFindByPlateNr() {
        Optional<Car> car = carRepository.findByPlateNr("PO00003");

        Assert.assertTrue("Optional Car should be present", car.isPresent());
    }

    @Test
    public void shouldDontFindByPlateNr() {
        Optional<Car> car = carRepository.findByPlateNr("PO10003");

        Assert.assertFalse("Optional Car should not find any plate nr", car.isPresent());
    }

    @Test
    public void shouldFindByVin() {
        Optional<Car> car = carRepository.findByVin("VIN3");

        Assert.assertTrue("Optional Car should be present", car.isPresent());
    }

    @Test
    public void shouldDontFindByVin() {
        Optional<Car> car = carRepository.findByVin("VIN13");

        Assert.assertFalse("Optional car should not find any VIN", car.isPresent());
    }
}