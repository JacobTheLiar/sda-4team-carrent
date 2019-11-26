package pl.team.carrent.rent;

import org.junit.Test;
import pl.team.carrent.car.Car;
import pl.team.carrent.car_model.CarModel;
import pl.team.carrent.client.Client;
import pl.team.carrent.employee.Employee;
import pl.team.carrent.promotion.Promotion;
import pl.team.carrent.rent_point.RentPoint;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pl.team.carrent.rent.SearchRentOption.*;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 10.11.2019 12:29
 * *
 * @className: RentServiceTest
 * *
 * *
 ******************************************************/
public class RentServiceTest {

    Promotion prom1         = new Promotion();
    CarModel  opelCorsa2001 = new CarModel("Opel", "Corsa", "B", "hatchback", 2001, 30000);
    CarModel  operAstra2019 = new CarModel("Opel", "Astra", "C", "hatchback", 2019, 30000);
    Car       car1          = new Car(opelCorsa2001
            , LocalDate.of(2001, 9, 16), "PO11111", "VIN101", "red", 500);
    Car       car2          = new Car(operAstra2019
            , LocalDate.of(2019, 1, 6), "PO11112", "VIN102", "red", 500);
    Client    client1       = new Client("KRZAK COMPANY", "testowa 1", "02-823", "Warszawa", "777-777-77-77", "test@test.pl", "61 6666666");
    RentPoint rentPoint1    = new RentPoint();
    Employee  employee1     = new Employee();
    Rent      rent1         = new Rent(car1, client1, prom1, rentPoint1, LocalDate.now().plusDays(-30), employee1, 7000, "xyz");
    Rent      rent2         = new Rent(car2, client1, null, rentPoint1, LocalDate.now().plusDays(-10), employee1, 100000, "www111");
    Rent      rent3         = new Rent(car2, client1, prom1, rentPoint1, LocalDate.now().plusDays(-100), employee1, 80000, "nowy");
    Rent      rent4         = new Rent(car2, client1, prom1, rentPoint1, LocalDate.now().plusDays(-100), employee1, 80000, "nowy");

    public RentRepository getRentRepositoryMock() {
        RentRepository mock = mock(RentRepository.class);
        when(mock.findAll()).thenReturn(Arrays.asList(rent1, rent2));
        when(mock.findByCar_Vin("VIN")).thenReturn(rent1);
        when(mock.findByCar_PlateNr("PO11111")).thenReturn(rent1);
        when(mock.findByClient_Id(client1.getId())).thenReturn(Arrays.asList(rent1, rent2));
        when(mock.findByClient_NameContainsIgnoreCase("krzak")).thenReturn(Arrays.asList(rent2, rent1));
        when(mock.findByClient_EmailContainsIgnoreCase("@test.pl")).thenReturn(Arrays.asList(rent1, rent2));
        when(mock.findByClient_TelephoneNr("61 6666666")).thenReturn(Arrays.asList(rent1, rent2));
        when(mock.findByClient_TaxNumber("777-777-77-77")).thenReturn(Arrays.asList(rent1, rent2));
        when(mock.findByPromotion_Id(1)).thenReturn(Arrays.asList(rent1));
        when(mock.findByPromotion_NameContainsIgnoreCase("promo")).thenReturn(Arrays.asList(rent1));
        when(mock.findByRentPointStart_Id(1)).thenReturn(Arrays.asList(rent1, rent2));
        when(mock.findByRentPointStart_NameIgnoreCase(null)).thenReturn(Arrays.asList(rent1, rent2));
        when(mock.findByRentTimeStartBetween(LocalDate.now().plusDays(-14), LocalDate.now())).thenReturn(Arrays.asList(rent2));
        when(mock.findByEmployeeStart_UsernameIgnoreCase("snowyman")).thenReturn(Arrays.asList(rent1, rent2));
        when(mock.findByNotesContainsIgnoreCase("www")).thenReturn(Arrays.asList(rent2));
        when(mock.save(rent3)).thenReturn(rent3);
        return mock;
    }

    private RentService rentService = new RentService(getRentRepositoryMock());

    @Test
    public void shouldGetAllRents() {
        List<Rent> rents = rentService.getAllRents();
        assertEquals(2, rents.size());
    }

    @Test
    public void shouldSearchRentsByPlateNr() {
        List<Rent> rents = rentService.searchRents("PO11111", BY_CAR_PLATE_NR);
        assertEquals(1, rents.size());
    }

    @Test
    public void shouldSearchRentsByCarVin() {
        List<Rent> rents = rentService.searchRents("VIN", BY_CAR_VIN);
        assertEquals(1, rents.size());
    }

    @Test
    public void shouldSearchRentsByClientName() {
        List<Rent> rents = rentService.searchRents("krzak", BY_CLIENT_NAME);
        assertEquals(2, rents.size());
    }

    @Test
    public void shouldSearchRentsByClientId() {
        int id = client1.getId();
        List<Rent> rents = rentService.searchRents(String.valueOf(id), BY_CLIENT_ID);
        assertEquals(2, rents.size());
    }

    @Test
    public void shouldSearchRentsByClientEmail() {
        List<Rent> rents = rentService.searchRents("@test.pl", BY_CLIENT_EMAIL);
        assertEquals(2, rents.size());
    }


    @Test
    public void shouldSearchRentsByClientPhone() {
        List<Rent> rents = rentService.searchRents("61 6666666", BY_CLIENT_PHONE);
        assertEquals(2, rents.size());
    }

    @Test
    public void shouldSearchRentsByClientTaxNumber() {
        List<Rent> rents = rentService.searchRents("777-777-77-77", BY_CLIENT_TAX_NUMBER);
        assertEquals(2, rents.size());
    }

    @Test
    public void shouldSearchRentsByPromotionId() {
        List<Rent> rents = rentService.searchRents("1", BY_PROMOTION_ID);
        assertEquals(1, rents.size());
    }

    @Test
    public void shouldSearchRentsByPromotionName() {
        List<Rent> rents = rentService.searchRents("promo", BY_PROMOTION_NAME);
        assertEquals(1, rents.size());
    }

    @Test
    public void shouldSearchRentsByRentPointStartId() {
        List<Rent> rents = rentService.searchRents("1", BY_RENT_POINT_START_ID);
        assertEquals(2, rents.size());
    }

    @Test
    public void shouldSearchRentsByRentPointStartName() {
        List<Rent> rents = rentService.searchRents(null, BY_RENT_POINT_START_NAME);
        assertEquals(2, rents.size());
    }

    @Test
    public void shouldSearchRentsByRentNumbersOfWeeks() {
        List<Rent> rents = rentService.searchRents("2", BY_RENT_NUMBER_OF_WEEKS);
        assertEquals(1, rents.size());
    }

    @Test
    public void shouldSearchRentsByEmployeeUsernameStart() {
        List<Rent> rents = rentService.searchRents("snowyman", BY_EMPLOYEE_USERNAME_START);
        assertEquals(2, rents.size());
    }

    @Test
    public void shouldSearchRentsByNotesStart() {
        List<Rent> rents = rentService.searchRents("www", BY_NOTES_START);
        assertEquals(1, rents.size());
    }


    @Test
    public void shouldAddRent() {
        Rent actual = rentService.addOrUpdateRent(rent3);
        assertEquals(rent3, actual);
    }

    @Test
    public void shouldUpdateRent() {
        rent3.setNotes("poprawiony");
        Rent actual = rentService.addOrUpdateRent(rent3);
        assertNotEquals(rent4.getNotes(), actual.getNotes());
    }
}