package pl.team.carrent.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.model.Car;
import pl.team.carrent.model.CarModel;
import pl.team.carrent.model.Promotion;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/******************************************************
 * @author: Michal S.  
 * [https://github.com/DreamDoer86]
 * @date : 09.11.2019 11:07
 * *
 * @className: PromotionRepositoryTest
 * *
 ******************************************************/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PromotionRepositoryTest {

    @Autowired
    private CarModelRepository carModelRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PromotionRepository subject;


    private CarModel opelCorsa2001 = new CarModel("Opel", "Corsa",
            "B","null", 2001, 30000);
    private CarModel renualtClio2019 = new CarModel("Reanualt", "Clio",
            "B","null",2019, 30000);
    private CarModel opelAstra2005 = new CarModel("Opel", "Astra",
            "C","null", 2010, 30000);

    private Car newCar1 = new Car(opelCorsa2001,LocalDate.of(2001,6,22),
            "ZDR55555","WAUZZZ8E343453","Red",20);
    private Car newCar2 = new Car(renualtClio2019,LocalDate.of(2005,11,22),
            "ZDR55654","WAUZZZ8E356466","Blue",20);
    private Car newCar3 = new Car(opelAstra2005,LocalDate.of(2005,11,22),
            "ZDR20250","WAUZZZ8E3466","Blue",20);

    @Before
    public void setUp() throws Exception {
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, renualtClio2019, opelAstra2005));
        carRepository.saveAll(Arrays.asList(newCar1,newCar2, newCar3));
    }

    @Test
    public void shouldFindPromotionByName() {
        //given
        Promotion addedPromotion = new Promotion("Srednie 30%", 30,
                LocalDate.now(), LocalDate.now().plusDays(30),
                Arrays.asList(newCar3, newCar2), null);
        subject.save(addedPromotion);

        //when
        String name = "Srednie 30%";
        List<Promotion> byPromotionName = subject.findByNameContainsIgnoreCase(name);

        //then
        Assert.assertEquals("Srednie 30%", byPromotionName.get(0).getName());
    }

    @Test
    public void shouldFindPromotionByCar() {
        //given
        Promotion addedPromotion = new Promotion("Male 30%", 30,
                LocalDate.now(), LocalDate.now().plusDays(30),
                Arrays.asList(newCar1,newCar2, newCar3), null);
        subject.save(addedPromotion);

        //when
        List<Promotion> byCars = subject.findByCars(newCar1);

        //then
        Assert.assertEquals("Male 30%", byCars.get(0).getName());
    }

    @Test
    public void shouldFindPromotionByCarMark() {
        //given
        Promotion addedPromotion = new Promotion("Ople 30%", 30,
                LocalDate.now(), LocalDate.now().plusDays(30),
                Arrays.asList(newCar1, newCar3), null);
        subject.save(addedPromotion);

        //when
        String mark = "Opel";
        List<Promotion> byCarMark = subject.findPromotionByCarMark(mark);

        //then
        Assert.assertEquals("Ople 30%", byCarMark.get(0).getName());
    }

    @Test
    public void shouldFindPromotionByCarModel() {
        Promotion addedPromotion = new Promotion("Corsa 30%", 30,
                LocalDate.now(), LocalDate.now().plusDays(30),
                Arrays.asList(newCar1), null);
        subject.save(addedPromotion);

        //when
        String model = "Corsa";
        List<Promotion> byCarModel = subject.findPromotionByCarModel(model);

        //then
        Assert.assertEquals("Corsa 30%", byCarModel.get(0).getName());
    }

    @Test
    public void shouldFindPromotionByCarSegment() {
        Promotion addedPromotion = new Promotion("Opel 30%", 30,
                LocalDate.now(), LocalDate.now().plusDays(30),
                Arrays.asList(newCar3), null);
        subject.save(addedPromotion);

        //when
        String segment = "C";
        List<Promotion> byCarSegment = subject.findPromotionByCarSegment(segment);

        //then
        Assert.assertEquals("Opel 30%", byCarSegment.get(0).getName());
    }

}
