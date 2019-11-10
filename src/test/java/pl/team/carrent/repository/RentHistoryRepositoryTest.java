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
        CarModel myCarModel = new CarModel("Skoda", "Fabia","A","Combi", 1999, 30000);
        carModelRepository.save(myCarModel);

        Car car = new Car(myCarModel, localDate, "PO12345", "VIN1","czarny", 100.00);
        carRepository.save(car);

        Client client = new Client("King Julien XIII", "64th Street and Sixth Avenue", "10021", "New York", "0000000000", "cpzinfo@wcs.org", "(212) 439-6550");
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

        LocalDate rentTimeStart = LocalDate.of(2017, 5, 4);
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

        Promotion promotion = new Promotion("promo1",10,rentTimeStart.minusDays(2),rentTimeStart,cars,carModels,clients);
        promotionRepository.save(promotion);

        RentHistory rentHistory = new RentHistory(1,car,client,promotion,carRentPointStart,carRentPointEnd,employeeStart,employeeEnd,rentTimeStart,rentTimeEnd,counterStateStart,counterStateEnd,notesStart,notesEnd,invoice);
        rentHistoryRepository.save(rentHistory);
    }

    @Test
    public void shouldFindByCarModelMark() {
        //when
        List<RentHistory> rentHistoryList = rentHistoryRepository.findByCar_CarModelMarkContainsIgnoreCase("sko");
        //then
        Assert.assertEquals(rentHistoryList.get(0).getCar().getCarModel().getMark(), "Skoda");
    }

    @Test
    public void shouldFindByClientName() {
        //when
        List<RentHistory> rentHistoryList = rentHistoryRepository.findByClientNameContainsIgnoreCase("ki");
        //then
        Assert.assertEquals(rentHistoryList.get(0).getClient().getName(), "King Julien XIII");
    }

    @Test
    public void shouldFindByPromotionName() {
        //when
        List<RentHistory> rentHistoryList = rentHistoryRepository.findByPromotionNameContainsIgnoreCase("pr");
        //then
        Assert.assertEquals(rentHistoryList.get(0).getPromotion().getName(), "promo1");
    }

    @Test
    public void shouldFindByRentPointStartName() {
        //when
        List<RentHistory> rentHistoryList = rentHistoryRepository.findByRentPointStartNameContainsIgnoreCase("wy1");
        //then
        Assert.assertEquals(rentHistoryList.get(0).getRentPointStart().getName(), "Punkt testowy1");
    }

    @Test
    public void shouldFindByRentPointEndName() {
        //when
        List<RentHistory> rentHistoryList = rentHistoryRepository.findByRentPointEndNameContainsIgnoreCase("wy2");
        //then
        Assert.assertEquals(rentHistoryList.get(0).getRentPointEnd().getName(), "Punkt testowy2");
    }

    @Test
    public void shouldFindByEmployeeStartSurname() {
        //when
        List<RentHistory> rentHistoryList = rentHistoryRepository.findByEmployeeStartSurnameContainsIgnoreCase("up");
        //then
        Assert.assertEquals(rentHistoryList.get(0).getEmployeeStart().getSurname(), "Ciupek");
    }

    @Test
    public void shouldFindByEmployeeEndSurname() {
        //when
        List<RentHistory> rentHistoryList = rentHistoryRepository.findByEmployeeEndSurnameContainsIgnoreCase("yg");
        //then
        Assert.assertEquals(rentHistoryList.get(0).getEmployeeEnd().getSurname(), "Kryger");
    }

    @Test
    public void shouldFindByInvoiceNumber() {
        //when
        List<RentHistory> rentHistoryList = rentHistoryRepository.findByInvoiceNumberContainsIgnoreCase("y");
        //then
        Assert.assertEquals(rentHistoryList.get(0).getInvoice().getNumber(), "100XYZ");
    }

    @Test
    public void shouldFindByCarPlateNr() {
        //when
        List<RentHistory> rentHistoryList = rentHistoryRepository.findByCar_PlateNrContainsIgnoreCase("23");
        //then
        Assert.assertEquals(rentHistoryList.get(0).getCar().getPlateNr(), "PO12345");
    }

    @Test
    public void shouldFindByCarModel() {
        //when
        List<RentHistory> rentHistoryList = rentHistoryRepository.findByCar_CarModelModelContainsIgnoreCase("ia");
        //then
        Assert.assertEquals(rentHistoryList.get(0).getCar().getCarModel().getModel(), "Fabia");
    }

    @Test
    public void shouldFindByClientEmail() {
        //when
        List<RentHistory> rentHistoryList = rentHistoryRepository.findByClientEmailContainsIgnoreCase("inf");
        //then
        Assert.assertEquals(rentHistoryList.get(0).getClient().getEmail(), "cpzinfo@wcs.org");
    }

    @Test
    public void shouldFindByRentTimeStartAfter() {
        //when
        List<RentHistory> rentHistoryList = rentHistoryRepository.findByRentTimeStartAfter(LocalDate.of(2017, 4, 4));
        //then
        Assert.assertEquals(rentHistoryList.get(0).getRentTimeStart(), LocalDate.of(2017, 5, 4));
    }
}
