package pl.team.carrent.car;

import org.junit.Test;
import pl.team.carrent.model.Car;
import pl.team.carrent.model.CarModel;
import pl.team.carrent.repository.CarRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pl.team.carrent.car.SearchCarOption.*;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 09.11.2019 14:05
 * *
 * @className: CarServiceTest
 * *
 * *
 ******************************************************/
public class CarServiceTest {

    private LocalDate localDate = LocalDate.of(1999, 9, 01);
    private CarModel myCarModel1 = new CarModel("Skoda", "Fabia", "A", "hatchback", 1999, 30000);
    private CarModel myCarModel2 = new CarModel("Renault", "Megane", "A", "hatchback", 1999, 30000);
    private Car car1 = new Car(myCarModel1, localDate, "PO12345", "VIN1", "white", 100.00);
    private Car car2 = new Car(myCarModel2, localDate, "PO12346", "VIN2", "black", 100.00);
    private Car car3 = new Car(myCarModel2, localDate, "PO12347", "VIN3", "black", 100.00);

    private CarRepository getCarRepositoryMock() {
        car2.setActive(false);
        CarRepository mock = mock(CarRepository.class);
        when(mock.findAll()).thenReturn(Arrays.asList(car1, car2));
        when(mock.findByActiveEquals(true)).thenReturn(Arrays.asList(car1));
        when(mock.findByPlateNr("PO12345")).thenReturn(Optional.of(car1));
        when(mock.findByPlateNrContainsIgnoreCase("PO1234")).thenReturn(Arrays.asList(car1, car2));
        when(mock.findByPlateNrContainsIgnoreCaseAndActiveIs("PO1234", true)).thenReturn(Arrays.asList(car1));
        when(mock.findByVin("VIN1")).thenReturn(Optional.of(car1));
        when(mock.findByVinContainsIgnoreCase("VIN")).thenReturn(Arrays.asList(car1, car2));
        when(mock.findByVinContainsIgnoreCaseAndActiveIs("VIN", true)).thenReturn(Arrays.asList(car1));
        when(mock.findByActiveEquals(false)).thenReturn(Arrays.asList(car2));
        when(mock.findByColorContainsIgnoreCase("black")).thenReturn(Arrays.asList(car2));
        when(mock.findByColorContainsIgnoreCaseAndActiveIs("black", true)).thenReturn(Arrays.asList());
        when(mock.findByCarModelTypeContainsIgnoreCase("hatchback")).thenReturn(Arrays.asList(car1, car2));
        when(mock.findByCarModelTypeContainsIgnoreCaseAndActiveIs("hatchback", true)).thenReturn(Arrays.asList(car1));
        when(mock.findByCarModelSegmentContains("A")).thenReturn(Arrays.asList(car1, car2));
        when(mock.findByCarModelSegmentContainsIgnoreCaseAndActiveIs("A", true)).thenReturn(Arrays.asList(car1));
        when(mock.save(car3)).thenReturn(car3);
        when(mock.findById(3)).thenReturn(Optional.of(car3));
        return mock;
    }

    private CarService carService = new CarService(getCarRepositoryMock());

    @Test
    public void shouldGetAllActiveCars() {
        //when
        List<Car> actual = carService.getAllActiveCars();
        //then
        assertEquals(1, actual.size());
    }

    @Test
    public void shoutGetAllCars() {
        //when
        List<Car> actual = carService.getAllCars();
        //then
        assertEquals(2, actual.size());
    }

    @Test
    public void shouldSearchCarsByPlateNr() {
        //when
        List<Car> actual = carService.searchCars("PO1234", BY_PLATE_NR);
        //then
        assertEquals(2, actual.size());
    }

    @Test
    public void shouldSearchCarsByVin() {
        //when
        List<Car> actual = carService.searchCars("VIN", BY_VIN);
        //then
        assertEquals(2, actual.size());
    }

    @Test
    public void shouldSearchCarsBySegment() {
        //when
        List<Car> actual = carService.searchCars("A", BY_SEGMENT);
        //then
        assertEquals(2, actual.size());
    }

    @Test
    public void shouldSearchCarsByType() {
        //when
        List<Car> actual = carService.searchCars("hatchback", BY_TYPE);
        //then
        assertEquals(2, actual.size());
    }

    @Test
    public void shouldSearchCarsByColor() {
        //when
        List<Car> actual = carService.searchCars("black", BY_COLOR);
        //then
        assertEquals(1, actual.size());
    }

    @Test
    public void shouldSearchActiveCarsByPlateNr() {
        //when
        List<Car> actual = carService.searchActiveCars("PO1234", BY_PLATE_NR);
        //then
        assertEquals(1, actual.size());
    }

    @Test
    public void shouldSearchActiveCarsByVin() {
        //when
        List<Car> actual = carService.searchActiveCars("VIN", BY_VIN);
        //then
        assertEquals(1, actual.size());
    }

    @Test
    public void shouldSearchActiveCarsBySegment() {
        //when
        List<Car> actual = carService.searchActiveCars("A", BY_SEGMENT);
        //then
        assertEquals(1, actual.size());
    }

    @Test
    public void shouldSearchActiveCarsByType() {
        //when
        List<Car> actual = carService.searchActiveCars("hatchback", BY_TYPE);
        //then
        assertEquals(1, actual.size());
    }

    @Test
    public void shouldSearchActiveCarsByColor() {
        //when
        List<Car> actual = carService.searchActiveCars("black", BY_COLOR);
        //then
        assertEquals(0, actual.size());
    }

    @Test
    public void shouldGetCarByPlateNr() {
        //when
        Car actual = carService.getCarByPlateNr("PO12345");
        //then
        assertThat(actual).isEqualTo(car1);
    }

    @Test
    public void shouldGetCarByVin() {
        //when
        Car actual = carService.getCarByVin("VIN1");
        //then
        assertThat(actual).isEqualTo(car1);
    }

    @Test
    public void shouldAddCar() {
        //when
        Car actual = carService.addOrUpdateCar(car3);
        //then
        assertThat(actual).isEqualTo(car3);
    }

    @Test
    public void shouldRemoveCar() {
        //when
        carService.removeCar(3);
        //then
        assertThat(car3.isActive()).isEqualTo(false);
    }
}