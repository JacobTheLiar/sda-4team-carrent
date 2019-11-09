package pl.team.carrent.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.model.*;

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
    private RentRepository rentRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarModelRepository carModelRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RentPointRepository rentPointRepository;


    @Test
    public void findByCar_PlateNr() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Jan Kowalski", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByCar_PlateNr("PO11111");

        //then
        assertEquals(1, rents.size());
    }

    @Test
    public void findByCar_Vin() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", 500);
        carRepository.saveAll(Arrays.asList(car1, car2));
        RentPoint rentPoint = new RentPoint("Punkt Test", "testowa 1", "60-682", "Poznań");
        rentPointRepository.save(rentPoint);
        LocalDate rentDate = LocalDate.of(2019, 11, 11);
        Client client = new Client("Jan Kowalski", "OBCH 111/11", "60-682", "Poznań", "777-77-77-777", "kowalski@wp.pl", "666 777 888");
        clientRepository.save(client);
//        Employee employee = new Employee("Jan", "Nowak", 1, "jnowak", "qwerty123", LocalDate.of(2001, 9, 16), null, new Role());
        Rent rent1 = new Rent(car1, client, null, rentPoint, rentDate, null, 10000, "search test 1");
        Rent rent2 = new Rent(car2, client, null, rentPoint, rentDate, null, 15000, "search test 2");
        rentRepository.saveAll(Arrays.asList(rent1, rent2));

        //when
        List<Rent> rents = rentRepository.findByCar_Vin("VIN102");

        //then
        assertEquals(1, rents.size());
    }

    @Test
    public void findByClient_Name() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", 500);
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
        List<Rent> rents = rentRepository.findByClient_Name("Krzak");

        //then
        assertEquals(2, rents.size());
    }

    @Test
    public void findByClient_Id() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", 500);
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
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", 500);
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
        List<Rent> rents = rentRepository.findByClient_Email("kowalski@wp.pl");

        //then
        assertEquals(2, rents.size());
    }

    @Test
    public void findByClient_TelephoneNr() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", 500);
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
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", 500);
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

    }

    @Test
    public void findByPromotion_Name() {
    }

    @Test
    public void findByRentPointStart_Id() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", 500);
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
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", 500);
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
        List<Rent> rents = rentRepository.findByRentPointStart_Name("Punkt Test");

        //then
        assertEquals(2, rents.size());
    }

    @Test
    public void findByRentTimeStartBetween() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", 500);
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
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", 500);
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
        List<Rent> rents = rentRepository.findByEmployeeStart_Username("jnowak");

        //then
        assertEquals(0, rents.size());
    }

    @Test
    public void findByNotesContains() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", 2001, 30000);
        CarModel operAstra2019 = new CarModel("Opel", "Astra", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, operAstra2019));
        Car car1 = new Car(opelCorsa2001
                , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", 500);
        Car car2 = new Car(operAstra2019
                , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", 500);
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
        List<Rent> rents = rentRepository.findByNotesContains("search test 2");

        //then
        assertEquals(1, rents.size());
    }
}