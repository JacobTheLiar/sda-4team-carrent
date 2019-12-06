package pl.team.carrent.service;

import org.assertj.core.util.Sets;
import org.junit.Test;
import pl.team.carrent.car.Car;
import pl.team.carrent.car_model.CarModel;
import pl.team.carrent.client.Client;
import pl.team.carrent.employee.Employee;
import pl.team.carrent.employee.Role;
import pl.team.carrent.invoice.Invoice;
import pl.team.carrent.promotion.Promotion;
import pl.team.carrent.rent_history.RentHistory;
import pl.team.carrent.rent_history.RentHistoryService;
import pl.team.carrent.rent_point.RentPoint;
import pl.team.carrent.rent_history.RentHistoryRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RentHistoryServiceTest {

    private static String FIND_MARK = "oda";
    private static String FIND_PLATE = "123";
    private static String FIND_MODEL = "bia";
    private static String FIND_CLIENTNAME = "ing";
    private static String FIND_CLIENTEMAIL = "wcs";
    private static String FIND_PROMOTIONNAME = "omo1";
    private static String FIND_RENTPOINTSTARTNAME = "1";
    private static String FIND_RENTPOINTENDNAME = "POZ2";
    private static String FIND_EMPLOYEESTARTSURNAME = "pek";
    private static String FIND_EMPLOYEEENDSURNAME = "kry";
    private static String FIND_INVOICENUMBER = "100XYZ";
    private static LocalDate FIND_RENTTIMESTART = LocalDate.of(2017, 5, 4);
    private static LocalDate FIND_RENTTIMEEND = LocalDate.of(2017, 8, 13);

    private CarModel     carModel      = new CarModel("Skoda", "Fabia", "A", "Combi", 1999, 30000);
    private LocalDate    localDate     = LocalDate.of(1999, 9, 1);
    private RentPoint rentPoint= new RentPoint();
    private Car          car           = new Car(carModel, localDate, "PO12345", "VIN1", "brown", 100.00,rentPoint);
    private Client       client        = new Client("King Julien XIII", "64th Street and Sixth Avenue", "10021", "New York", "0000000000", "cpzinfo@wcs.org", "(212) 439-6550");
    private LocalDate    rentTimeStart = LocalDate.of(2017, 5, 4);
    private LocalDate    rentTimeEnd   = LocalDate.of(2017, 8, 13);
    private List<Car>    cars          = Collections.singletonList(car);
    private List<Client> clients       = Collections.singletonList(client);
    private Promotion    promotion     = new Promotion("promo1", 10, rentTimeStart.minusDays(2), rentTimeStart, cars, clients);
    private RentPoint    employeeRentPoint  = new RentPoint("POZ1", "Zmigrodzka", "61-244", "Poznan");
    private RentPoint employeeRentPoint2 = new RentPoint("POZ2", "Bulgarska", "61-244", "Poznan");
    private Role      role               = new Role("admin");
    private LocalDate employmentDate     = LocalDate.of(1999, 9, 1);
    private Employee  employeeStart      = new Employee("Lukasz", "Ciupek", employeeRentPoint, "ciupas", employmentDate, role);
    private Employee  employeeEnd        = new Employee("Maciej", "Kryger", employeeRentPoint2, "snowyman", employmentDate, role);
    private Invoice   invoice            = new Invoice("100XYZ", BigDecimal.valueOf(800), rentTimeEnd, rentTimeEnd.plusDays(1), rentTimeEnd.plusDays(2));
    private int       counterStateStart  = 8000;
    private int       counterStateEnd    = 8600;
    private String    notesStart         = "Odbiór 9 rano";
    private String    notesEnd           = "Wszystko ok";

    private RentHistory rentHistory1 = new RentHistory(1, car, client, promotion, employeeRentPoint, employeeRentPoint2, employeeStart, employeeEnd, rentTimeStart, rentTimeEnd, counterStateStart, counterStateEnd, notesStart, notesEnd, invoice);
    private RentHistory rentHistory2 = new RentHistory(2,car,client,promotion,employeeRentPoint,employeeRentPoint2,employeeStart,employeeEnd,rentTimeStart,rentTimeEnd,counterStateStart,counterStateEnd,notesStart,notesEnd,invoice);

    private RentHistoryRepository getRentHistoryRepositoryMock() {
        RentHistoryRepository mock = mock(RentHistoryRepository.class);

        when(mock.findByCar_CarModelMarkContainsIgnoreCase(FIND_MARK)).thenReturn(Sets.newLinkedHashSet(rentHistory1));
        when(mock.findByCar_PlateNrContainsIgnoreCase(FIND_PLATE)).thenReturn(Sets.newLinkedHashSet(rentHistory1));
        when(mock.findByCar_CarModelModelContainsIgnoreCase(FIND_MODEL)).thenReturn(Sets.newLinkedHashSet(rentHistory1));
        when(mock.findByClientNameContainsIgnoreCase(FIND_CLIENTNAME)).thenReturn(Sets.newLinkedHashSet(rentHistory1));
        when(mock.findByClientEmailContainsIgnoreCase(FIND_CLIENTEMAIL)).thenReturn(Sets.newLinkedHashSet(rentHistory1));
        when(mock.findByPromotionNameContainsIgnoreCase(FIND_PROMOTIONNAME)).thenReturn(Sets.newLinkedHashSet(rentHistory1));
        when(mock.findByRentPointStartNameContainsIgnoreCase(FIND_RENTPOINTSTARTNAME)).thenReturn(Sets.newLinkedHashSet(rentHistory1));
        when(mock.findByRentPointEndNameContainsIgnoreCase(FIND_RENTPOINTENDNAME)).thenReturn(Sets.newLinkedHashSet(rentHistory1));
        when(mock.findByEmployeeStartSurnameContainsIgnoreCase(FIND_EMPLOYEESTARTSURNAME)).thenReturn(Sets.newLinkedHashSet(rentHistory1));
        when(mock.findByEmployeeEndSurnameContainsIgnoreCase(FIND_EMPLOYEEENDSURNAME)).thenReturn(Sets.newLinkedHashSet(rentHistory1));
        when(mock.findByInvoiceNumberContainsIgnoreCase(FIND_INVOICENUMBER)).thenReturn(Sets.newLinkedHashSet(rentHistory1));
        when(mock.findByRentTimeStartAfter(FIND_RENTTIMESTART)).thenReturn(Sets.newLinkedHashSet(rentHistory1));
        when(mock.findByRentTimeEnd(FIND_RENTTIMEEND)).thenReturn(Sets.newLinkedHashSet(rentHistory1));
        when(mock.findAll()).thenReturn(Arrays.asList(rentHistory1));
        when(mock.save(rentHistory2)).thenReturn(rentHistory2);

        return mock;
    }

    private RentHistoryService rentHistoryService = new RentHistoryService(getRentHistoryRepositoryMock());

    @Test
    public void shouldReturnOneRentHistoryByCarMarkSearch() {
        Set<RentHistory> actual = rentHistoryService.getRentHistoryByCarMark(FIND_MARK);
        assertThat(actual).containsExactly(rentHistory1);
    }

    @Test
    public void shouldReturnOneRentHistoryByPlateNrSearch() {
        Set<RentHistory> actual = rentHistoryService.getRentHistoryByPlateNr(FIND_PLATE);
        assertThat(actual).containsExactlyInAnyOrder(rentHistory1);
    }

    @Test
    public void shouldReturnOneRentHistoryByModelSearch() {
        Set<RentHistory> actual = rentHistoryService.getRentHistoryByModel(FIND_MODEL);
        assertThat(actual).containsExactlyInAnyOrder(rentHistory1);
    }

    @Test
    public void shouldReturnOneRentHistoryByClientNameSearch() {
        Set<RentHistory> actual = rentHistoryService.getRentHistoryByClientName(FIND_CLIENTNAME);
        assertThat(actual).containsExactlyInAnyOrder(rentHistory1);
    }

    @Test
    public void shouldReturnOneRentHistoryByClientEmailSearch() {
        Set<RentHistory> actual = rentHistoryService.getRentHistoryByClientEmail(FIND_CLIENTEMAIL);
        assertThat(actual).containsExactlyInAnyOrder(rentHistory1);
    }

    @Test
    public void shouldReturnOneRentHistoryByPromotionNameSearch() {
        Set<RentHistory> actual = rentHistoryService.getRentHistoryByPromotionName(FIND_PROMOTIONNAME);
        assertThat(actual).containsExactlyInAnyOrder(rentHistory1);
    }

    @Test
    public void shouldReturnOneRentHistoryByRentPointStartNameSearch() {
        Set<RentHistory> actual = rentHistoryService.getRentHistoryByRentPointStartName(FIND_RENTPOINTSTARTNAME);
        assertThat(actual).containsExactlyInAnyOrder(rentHistory1);
    }

    @Test
    public void shouldReturnOneRentHistoryByRentPointEndNameSearch() {
        Set<RentHistory> actual = rentHistoryService.getRentHistoryByRentPointEndName(FIND_RENTPOINTENDNAME);
        assertThat(actual).containsExactlyInAnyOrder(rentHistory1);
    }

    @Test
    public void shouldReturnOneRentHistoryByEmployeeStartSurnameSearch() {
        Set<RentHistory> actual = rentHistoryService.getRentHistoryByEmployeeStartSurname(FIND_EMPLOYEESTARTSURNAME);
        assertThat(actual).containsExactlyInAnyOrder(rentHistory1);
    }

    @Test
    public void shouldReturnOneRentHistoryByEmployeeEndSurnameSearch() {
        Set<RentHistory> actual = rentHistoryService.getRentHistoryByEmployeeEndSurname(FIND_EMPLOYEEENDSURNAME);
        assertThat(actual).containsExactlyInAnyOrder(rentHistory1);
    }

    @Test
    public void shouldReturnOneRentHistoryByInvoiceNumberSearch() {
        Set<RentHistory> actual = rentHistoryService.getRentHistoryByInvoiceNumber(FIND_INVOICENUMBER);
        assertThat(actual).containsExactlyInAnyOrder(rentHistory1);
    }

    @Test
    public void shouldReturnOneRentHistoryByRentTimeStartAfterSearch() {
        Set<RentHistory> actual = rentHistoryService.getRentHistoryByRentTimeStartAfter(FIND_RENTTIMESTART);
        assertThat(actual).containsExactlyInAnyOrder(rentHistory1);
    }

    @Test
    public void shouldReturnOneRentHistoryByRentTimeEndSearch() {
        Set<RentHistory> actual = rentHistoryService.getRentHistoryByRentTimeEnd(FIND_RENTTIMEEND);
        assertThat(actual).containsExactlyInAnyOrder(rentHistory1);
    }

    @Test
    public void shouldReturnAllRentHistory() {
        Set<RentHistory> actual = rentHistoryService.getAllRentHistory();
        assertThat(actual).containsExactlyInAnyOrder(rentHistory1);
    }

    @Test
    public void shouldAddRentHistory() {
        RentHistory actual = rentHistoryService.addRentHistory(rentHistory2);
        assertThat(actual).isEqualTo(rentHistory2);
    }
}