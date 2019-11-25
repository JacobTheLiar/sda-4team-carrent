package pl.team.carrent.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.car.Car;
import pl.team.carrent.car_model.CarModel;
import pl.team.carrent.client.Client;
import pl.team.carrent.client.ClientRepository;
import pl.team.carrent.promotion.Promotion;
import pl.team.carrent.rent.Rent;
import pl.team.carrent.rent_point.RentPoint;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 05.11.2019 18:48
 * *
 * @className: RentRepositoryTest
 * *
 * *
 ******************************************************/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class RentRepositoryTest {

    @Autowired
    private RentRepository      rentRepository;
    @Autowired
    private CarRepository       carRepository;
    @Autowired
    private CarModelRepository  carModelRepository;
    @Autowired
    private ClientRepository    clientRepository;
    @Autowired
    private RentPointRepository rentPointRepository;
    @Autowired
    private PromotionRepository promotionRepository;


    @Test
    public void findByCar_PlateNr() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "yellow", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Jan Kowalski", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");

        rentRepository.save(rent1);

        //when
        Rent rent = rentRepository.findByCar_PlateNr("PO11111");

        //then
        assertEquals(rent1, rent);
    }

    @Test
    public void findByCar_Vin() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "red", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Jan Kowalski", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");
        rentRepository.save(rent1);

        //when
        Rent rent = rentRepository.findByCar_Vin("VIN101");

        //then
        assertEquals(rent1, rent);
    }

    @Test
    public void findByClient_Name() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "red", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Krzak", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByClient_NameContainsIgnoreCase("Krzak");

        //then
        assertEquals(2, rents.size());
    }

    @Test
    public void findByClient_Id() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "yellow", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Krzak", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByClient_Id(client.getId());

        //then
        assertEquals(2, rents.size());
    }

    @Test
    public void findByClient_Email() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "black", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "red", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Krzak", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByClient_EmailContainsIgnoreCase("kowalski@wp.pl");

        //then
        assertEquals(2, rents.size());
    }

    @Test
    public void findByClient_TelephoneNr() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "red", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Krzak", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByClient_TelephoneNr("666 777 888");

        //then
        assertEquals(2, rents.size());
    }

    @Test
    public void findByClient_TaxNumber() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "red", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Krzak", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByClient_TaxNumber("777-77-77-777");

        //then
        assertEquals(2, rents.size());
    }

    @Test
    public void findByPromotion_Id() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "red", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Krzak", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
        Promotion promotion = new Promotion("PROMO1", 30, rentDate, LocalDate.now(), Arrays.asList(car1), null);
        promotionRepository.save(promotion);
        Rent rent1 = new Rent(car1, client, promotion, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByPromotion_Id(promotion.getId());

        //then
        assertEquals(1, rents.size());
    }

    @Test
    public void findByPromotion_Name() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "red", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Krzak", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
        Promotion promotion = new Promotion("PROMO1",30,rentDate,LocalDate.now(),Arrays.asList(car1),null);
        promotionRepository.save(promotion);
        Rent rent1 = new Rent(car1, client, promotion, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByPromotion_NameContainsIgnoreCase("PROMO1");

        //then
        assertEquals(1, rents.size());
    }

    @Test
    public void findByRentPointStart_Id() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "red", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Krzak", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByRentPointStart_Id(rentPoint.getId());

        //then
        assertEquals(2, rents.size());
    }

    @Test
    public void findByRentPointStart_Name() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "red", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Krzak", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByRentPointStart_NameIgnoreCase("Punkt Test");

        //then
        assertEquals(2, rents.size());
    }

    @Test
    public void findByRentTimeStartBetween() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "red", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Krzak", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByRentTimeStartBetween(LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30));

        //then
        assertEquals(2, rents.size());
    }

    @Test
    public void findByEmployeeStart_Username() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "red", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Krzak", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByEmployeeStart_UsernameIgnoreCase("jnowak");

        //then
        assertEquals(0, rents.size());
    }

    @Test
    public void findByNotesContains() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "red", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Krzak", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByNotesContainsIgnoreCase("search test 2");

        //then
        assertEquals(1, rents.size());
    }
}