package pl.team.carrent.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.model.RentPoint;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 03.11.2019 17:39
 * *
 * @className: RentPointRepositoryTest
 * *
 * *
 ******************************************************/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RentPointRepositoryTest {

    @Autowired
    private RentPointRepository rentPointRepository;

    @Test
    public void findByNameContains() {
        RentPoint rentPoint1 = new RentPoint("Punkt testowy", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint1);
        List<RentPoint> rentPoints = rentPointRepository.findByNameContains("unkt");

        assertEquals(1,rentPoints.size());
    }

    @Test
    public void findByAddressContains() {
        RentPoint rentPoint1 = new RentPoint("Punkt testowy", "testowa 1", "60-682", "Poznań");
        RentPoint rentPoint2 = new RentPoint("Punkt testowy 2", "testowa 2", "02-823", "Warszawa");
        rentPointRepository.saveAll(Arrays.asList(rentPoint1,rentPoint2));
        List<RentPoint> rentPoints = rentPointRepository.findByAddressContains("testowa");

        assertEquals(2,rentPoints.size());

    }

    @Test
    public void findByPostCode() {
        RentPoint rentPoint1 = new RentPoint("Punkt testowy", "testowa 1", "60-682", "Poznań");
        RentPoint rentPoint2 = new RentPoint("Punkt testowy 2", "testowa 2", "02-823", "Warszawa");
        rentPointRepository.saveAll(Arrays.asList(rentPoint1,rentPoint2));
        List<RentPoint> rentPoints = rentPointRepository.findByPostCode("02-823");

        assertEquals(1,rentPoints.size());
    }

    @Test
    public void findByCityContains() {
        RentPoint rentPoint1 = new RentPoint("Punkt testowy", "testowa 1", "60-682", "Poznań");
        RentPoint rentPoint2 = new RentPoint("Punkt testowy 2", "testowa 2", "02-823", "Warszawa");
        rentPointRepository.saveAll(Arrays.asList(rentPoint1,rentPoint2));
        List<RentPoint> rentPoints = rentPointRepository.findByCityContains("Poz");

        assertEquals(1,rentPoints.size());
    }
}