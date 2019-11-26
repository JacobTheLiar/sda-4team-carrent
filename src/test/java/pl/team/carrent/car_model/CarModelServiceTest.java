package pl.team.carrent.car_model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pl.team.carrent.car_model.SearchCarModelOption.*;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 10.11.2019 10:12
 * *
 * @className: CarModelServiceTest
 * *
 * *
 ******************************************************/
public class CarModelServiceTest {

    private CarModel carModel1 = new CarModel("Ford", "Ka", "A", "hatchback", 2000, 30000);
    private CarModel carModel2 = new CarModel("Ford", "Fiesta", "B", "hatchback", 1998, 30000);
    private CarModel carModel3 = new CarModel("Ford", "Focus", "C", "combi", 2000, 30000);
    private CarModel carModel4 = new CarModel("Ford", "Focus", "C", "combi", 2000, 30000);
    private CarModel carModel5 = new CarModel("Ford", "Focus", "C", "combi", 2000, 30000);

    private CarModelRepository getCarModelRepository() {
        CarModelRepository mock = mock(CarModelRepository.class);
        when(mock.findAll()).thenReturn(Arrays.asList(carModel1, carModel2, carModel3));
        when(mock.findByMarkContainsIgnoreCase("Ford")).thenReturn(Arrays.asList(carModel1, carModel2, carModel3));
        when(mock.findByModelContainsIgnoreCase("Ka")).thenReturn(Arrays.asList(carModel1));
        when(mock.findByProductionYear(2000)).thenReturn(Arrays.asList(carModel1, carModel3));
        when(mock.findBySegmentContains("B")).thenReturn(Arrays.asList(carModel2));
        when(mock.findByTypeContainsIgnoreCase("combi")).thenReturn(Arrays.asList(carModel3));
        when(mock.findByProductionYearBetween(2000, 2019)).thenReturn(Arrays.asList(carModel1, carModel3));
        when(mock.save(carModel4)).thenReturn(carModel4);
        return mock;
    }

    private CarModelService carModelService = new CarModelService(getCarModelRepository());

    @Test
    public void shouldGetAllCarModels() {
        //when
        List<CarModel> carModels = carModelService.getAllCarModels();
        //then
        Assert.assertEquals(3, carModels.size());
    }

    @Test
    public void shouldSearchCarModelsByMark() {
        //when
        List<CarModel> carModels = carModelService.searchCarModels("Ford", BY_MARK);
        //then
        Assert.assertEquals(3, carModels.size());
    }

    @Test
    public void shouldSearchCarModelsByModel() {
        //when
        List<CarModel> carModels = carModelService.searchCarModels("Ka", BY_MODEL);
        //then
        Assert.assertEquals(1, carModels.size());
    }

    @Test
    public void shouldSearchCarModelsBySegment() {
        //when
        List<CarModel> carModels = carModelService.searchCarModels("B", BY_SEGMENT);
        //then
        Assert.assertEquals(1, carModels.size());
    }

    @Test
    public void shouldSearchCarModelsByProductionYear() {
        //when
        List<CarModel> carModels = carModelService.searchCarModels("2000", BY_PRODUCTION_YEAR);
        //then
        Assert.assertEquals(2, carModels.size());
    }

    @Test
    public void shouldSearchCarModelsByAge() {
        //when
        List<CarModel> carModels = carModelService.searchCarModels("19", BY_AGE);
        //then
        Assert.assertEquals(2, carModels.size());
    }

    @Test
    public void shouldAddCarModel() {
        //when
        CarModel actual = carModelService.addCarModel(carModel4);
        //then
        Assert.assertEquals(carModel4, actual);
    }

    @Test
    public void shouldUpdateCarModel() {
        //when
        carModel4.setType("hatchback");
        CarModel actual = carModelService.updateCarModel(carModel4);
        //then
        Assert.assertNotEquals(carModel5.getType(), actual.getType());
    }
}