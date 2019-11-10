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
        CarModel carModel = new CarModel("test", "test", "A","combi",1000, 100);
        carModelRepository.save(carModel);
        List<CarModel> carModels = carModelRepository.findByMarkContainsIgnoreCase("est");
        Assert.assertEquals(carModels.size(), 1);
    }

    @Test
    public void shouldDontFindByMarkContains() {
        List<CarModel> carModels = carModelRepository.findByMarkContainsIgnoreCase("BMW");
        Assert.assertNotEquals("should find 0 BMW in the Base", 2, carModels.size());
    }

    @Test
    public void shouldFindByModelContains() {
        List<CarModel> carModels = carModelRepository.findByModelContainsIgnoreCase("orsa");
        Assert.assertEquals("should find one Opel Corsa in the base", 1, carModels.size());
    }

    @Test
    public void shouldDontFindByModelContains() {
        List<CarModel> carModels = carModelRepository.findByModelContainsIgnoreCase("Polo");
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
        List<CarModel> models = carModelRepository.findByMarkIgnoreCase("Opel");
        Assert.assertEquals("",  2,models.size());
    }

    @Test
    public void findBySegmentContains() {
        List<CarModel> models = carModelRepository.findBySegmentContains("B");
        Assert.assertEquals(2,models.size());
    }

    @Test
    public void findByTypeContainsIgnoreCase() {
        List<CarModel> models = carModelRepository.findByTypeContainsIgnoreCase("hatchback");
        Assert.assertEquals(5,models.size());
    }
}