package pl.team.carrent.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.model.CarModel;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 30.10.2019 19:44
 * *
 * @className: CarModelRepositoryTest
 * *
 * *
 ******************************************************/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CarModelRepositoryTest {

    @Autowired
    private CarModelRepository carModelRepository;


    @Test
    public void shouldFindByMarkContains() {
        CarModel carModel = new CarModel("test", "test", 1000, 100);
        carModelRepository.save(carModel);
        List<CarModel> carModels = carModelRepository.findByMarkContains("est");
        Assert.assertEquals(carModels.size(), 1);
    }

    @Test
    public void shouldDontFindByMarkContains() {
        List<CarModel> carModels = carModelRepository.findByMarkContains("BMW");
        Assert.assertNotEquals("should find 0 BMW in the Base", 2, carModels.size());
    }

    @Test
    public void shouldFindByModelContains() {
        List<CarModel> carModels = carModelRepository.findByModelContains("orsa");
        Assert.assertEquals("should find one Opel Corsa in the base", 1, carModels.size());
    }

    @Test
    public void shouldDontFindByModelContains() {
        List<CarModel> carModels = carModelRepository.findByModelContains("Polo");
        Assert.assertNotEquals("Should don't find any model VW Polo", 1, carModels.size());
    }

    @Test
    public void shouldFindByProductionYear() {
        List<CarModel> carModels = carModelRepository.findByProductionYear(2019);
        Assert.assertEquals("should find one car from 2019 year in the base", 1, carModels.size());
    }

    @Test
    public void shouldDontFindByProductionYear() {
        List<CarModel> carModels = carModelRepository.findByProductionYear(1900);
        Assert.assertEquals("Should don't find any model form 1900", 0, carModels.size());
    }

    @Test
    public void findByMark() {
        List<CarModel> models = carModelRepository.findByMark("Opel");
        Assert.assertEquals("", models.size(), 2);
    }
}