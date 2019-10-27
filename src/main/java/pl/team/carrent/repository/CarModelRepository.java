package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.team.carrent.model.CarModel;

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

    List<CarModel> findByMarkContains(String mark);

    List<CarModel> findByModelContains(String model);

    List<CarModel> findByProductionYear(int year);
}
