package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.team.carrent.car_model.CarModel;

import java.util.List;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 27.10.2019 14:17
 * *
 * @className: CarModelRepository
 * *
 * *
 ******************************************************/
public interface CarModelRepository extends JpaRepository<CarModel, Integer> {

    List<CarModel> findByMarkContainsIgnoreCase(String mark);

    List<CarModel> findByMarkIgnoreCase(String mark);

    List<CarModel> findByModelContainsIgnoreCase(String model);

    List<CarModel> findByProductionYear(int year);

    List<CarModel> findByProductionYearBetween(int year1, int year2);

    List<CarModel> findBySegmentContains(String segment);

    List<CarModel> findByTypeContainsIgnoreCase(String type);
}
