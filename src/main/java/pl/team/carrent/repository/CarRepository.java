package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.team.carrent.model.Car;
import pl.team.carrent.model.CarModel;

import java.util.List;
import java.util.Optional;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 27.10.2019 14:15
 * *
 * @className: CarRepository
 * *
 * *
 ******************************************************/
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByCarModel(CarModel carModel);

    Optional<Car> findByPlateNr(String plateNr);

    Optional<Car> findByVin(String vin);
}
