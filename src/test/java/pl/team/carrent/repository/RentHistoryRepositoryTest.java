package pl.team.carrent.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.model.*;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@SpringBootTest
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class RentHistoryRepositoryTest {

    @Autowired
    private RentHistoryRepository rentHistoryRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarModelRepository carModelRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private RentPointRepository rentPointRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void setUp() throws Exception {
        LocalDate localDate = LocalDate.of(1999, 9, 1);
        CarModel myCarModel = new CarModel("Skoda", "Fabia", "A", "Combi", 1999, 30000);
        carModelRepository.save(myCarModel);

        Car car = new Car(myCarModel, localDate, "PO12345", "VIN1","brown",  100.00);
        carRepository.save(car);

        Client client = new Client("King Julien XIII", "64th Street and Sixth Avenue", "10021", "New York", "0000000000", "cipsoft@wcs.org", "(212) 439-6550");
        clientRepository.save(client);

        RentPoint carRentPointStart = new RentPoint("Punkt testowy1", "testowa 1", "60-682", "Poznań");
        RentPoint carRentPointEnd = new RentPoint("Punkt testowy2", "testowa 1", "60-682", "Poznań");

        Role role = new Role("admin");
        roleRepository.save(role);

        LocalDate employmentDate = LocalDate.of(1999, 9, 1);
        RentPoint employeeRentPoint = new RentPoint("POZ", "Zmigrodzka", "61-244", "Poznan");
        RentPoint employeeRentPoint2 = new RentPoint("POZ", "Bulgarska", "61-244", "Poznan");
        rentPointRepository.saveAll(Arrays.asList(carRentPointStart,carRentPointEnd,employeeRentPoint,employeeRentPoint2));

        Employee employeeStart = new Employee("Lukasz", "Ciupek", employeeRentPoint, "ciupas", employmentDate, role);
        Employee employeeEnd = new Employee("Maciej", "Kryger", employeeRentPoint2, "snowyman", employmentDate, role);
        employeeRepository.saveAll(Arrays.asList(employeeStart,employeeEnd));

        LocalDate rentTimeStart = LocalDate.of(2019, 10, 14);
        LocalDate rentTimeEnd = LocalDate.of(2017, 8, 13);

        int counterStateStart = 8000;
        int counterStateEnd = 8600;

        String notesStart = "Odbiór 9 rano";
        String notesEnd = "Wszystko ok";

        Invoice invoice = new Invoice("100XYZ", BigDecimal.valueOf(800),rentTimeEnd,rentTimeEnd.plusDays(1),rentTimeEnd.plusDays(2));
        invoiceRepository.save(invoice);

        List<Car> cars = Collections.singletonList(car);
        List<CarModel> carModels = Collections.singletonList(myCarModel);
        List<Client> clients = Collections.singletonList(client);

        Promotion promotion = new Promotion("promo1",10,rentTimeStart.minusDays(2),rentTimeStart,cars,clients);
        promotionRepository.save(promotion);

        RentHistory rentHistory = new RentHistory(1,car,client,promotion,carRentPointStart,carRentPointEnd,employeeStart,employeeEnd,rentTimeStart,rentTimeEnd,counterStateStart,counterStateEnd,notesStart,notesEnd,invoice);
        rentHistoryRepository.save(rentHistory);
    }

    @Test
    public void shouldFindByCarModelMark() {
        //when
        Set<RentHistory> rentHistoryList = rentHistoryRepository.findByCar_CarModelMarkContainsIgnoreCase("sko");
        //then
        Assert.assertEquals(1, rentHistoryList.size());
    }

    @Test
    public void shouldFindByClientName() {
        //when
        Set<RentHistory> rentHistoryList = rentHistoryRepository.findByClientNameContainsIgnoreCase("king");
        //then
        Assert.assertEquals(1, rentHistoryList.size());
    }

    @Test
    public void shouldFindByPromotionName() {
        //when
        Set<RentHistory> rentHistoryList = rentHistoryRepository.findByPromotionNameContainsIgnoreCase("pr");
        //then
        Assert.assertEquals(1, rentHistoryList.size());
    }

    @Test
    public void shouldFindByRentPointStartName() {
        //when
        Set<RentHistory> rentHistoryList = rentHistoryRepository.findByRentPointStartNameContainsIgnoreCase("wy1");
        //then
        Assert.assertEquals(1, rentHistoryList.size());
    }

    @Test
    public void shouldFindByRentPointEndName() {
        //when
        Set<RentHistory> rentHistoryList = rentHistoryRepository.findByRentPointEndNameContainsIgnoreCase("wy2");
        //then
        Assert.assertEquals(1, rentHistoryList.size());
    }

    @Test
    public void shouldFindByEmployeeStartSurname() {
        //when
        Set<RentHistory> rentHistoryList = rentHistoryRepository.findByEmployeeStartSurnameContainsIgnoreCase("up");
        //then
        Assert.assertEquals(1, rentHistoryList.size());
    }

    @Test
    public void shouldFindByEmployeeEndSurname() {
        //when
        Set<RentHistory> rentHistoryList = rentHistoryRepository.findByEmployeeEndSurnameContainsIgnoreCase("yg");
        //then
        Assert.assertEquals(1, rentHistoryList.size());
    }

    @Test
    public void shouldFindByInvoiceNumber() {
        //when
        Set<RentHistory> rentHistoryList = rentHistoryRepository.findByInvoiceNumberContainsIgnoreCase("y");
        //then
        Assert.assertEquals(1, rentHistoryList.size());
    }

    @Test
    public void shouldFindByCarPlateNr() {
        //when
        Set<RentHistory> rentHistoryList = rentHistoryRepository.findByCar_PlateNrContainsIgnoreCase("23");
        //then
        Assert.assertEquals(1, rentHistoryList.size());
    }

    @Test
    public void shouldFindByCarModel() {
        //when
        Set<RentHistory> rentHistoryList = rentHistoryRepository.findByCar_CarModelModelContainsIgnoreCase("ia");
        //then
        Assert.assertEquals(1, rentHistoryList.size());
    }

    @Test
    public void shouldFindByClientEmail() {
        //when
        Set<RentHistory> rentHistoryList = rentHistoryRepository.findByClientEmailContainsIgnoreCase("soft");
        //then
        Assert.assertEquals(1, rentHistoryList.size());
    }

    @Test
    public void shouldFindByRentTimeStartAfter() {
        //when
        Set<RentHistory> rentHistoryList = rentHistoryRepository.findByRentTimeStartAfter(LocalDate.of(2019, 4, 4));
        //then
        Assert.assertEquals(1, rentHistoryList.size());
    }
}
