package pl.team.carrent.car;

import com.sun.jndi.ldap.LdapCtxFactory;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import org.springframework.stereotype.Service;
import pl.team.carrent.model.Car;
import pl.team.carrent.repository.CarRepository;

import javax.smartcardio.CardNotPresentException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 09.11.2019 10:12
 * *
 * @className: CarService
 * *
 * *
 ******************************************************/
@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllActiveCars() {
        return carRepository.findByActiveEquals(true);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> searchActiveCars(String searchWhat, SearchCarOption searchCarOption) {
        switch (searchCarOption) {
            case BY_PLATE_NR:
                return carRepository.findByPlateNrContainsIgnoreCaseAndActiveContains(searchWhat, true);
            case BY_VIN:
                return carRepository.findByVinContainsIgnoreCaseAndActiveContains(searchWhat, true);
            case BY_SEGMENT:
                return carRepository.findByCarModelSegmentContainsIgnoreCaseAndActiveEquals(searchWhat, true);
            case BY_TYPE:
                return carRepository.findByCarModelTypeContainsIgnoreCaseAndActiveEquals(searchWhat, true);
            case BY_COLOR:
                return carRepository.findByColorContainsIgnoreCaseAndActiveEquals(searchWhat, true);
            default:
                return new ArrayList<Car>();
        }
    }

    public List<Car> searchCars(String searchWhat, SearchCarOption searchCarOption) {
        switch (searchCarOption) {
            case BY_PLATE_NR:
                return carRepository.findByPlateNrContainsIgnoreCase(searchWhat);
            case BY_VIN:
                return carRepository.findByVinContainsIgnoreCase(searchWhat);
            case BY_SEGMENT:
                return carRepository.findByCarModelSegmentContains(searchWhat);
            case BY_TYPE:
                return carRepository.findByCarModelTypeContainsIgnoreCase(searchWhat);
            case BY_COLOR:
                return carRepository.findByColorContainsIgnoreCase(searchWhat);
            default:
                return new ArrayList<Car>();
        }
    }


    public Car getCarByPlateNr(String plateNr) {
        return carRepository.findByPlateNr(plateNr).orElseThrow(() -> new CarNotExistException("carPlateNr" + plateNr));
    }


    public Car getCarByVin(String vin) {
        return carRepository.findByVin(vin).orElseThrow(() -> new CarNotExistException("carVin" + vin));
    }


    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public void removeCar(int id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            car.setActive(false);
        }
    }

}
