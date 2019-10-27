package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.team.carrent.model.Car;
import pl.team.carrent.model.CarReview;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 27.10.2019 14:18
 * *
 * @className: CarReviewRepository
 * *
 * *
 ******************************************************/
public interface CarReviewRepository extends JpaRepository<CarReview, String> {

    Car findByCar_PlateNr(String plateNr);
    Car findByCar_VinAnd(String vin);
    List<Car> findByReviewDateBetween(LocalDate date1, LocalDate date2);
    List<Car> findByReviewDateBefore(LocalDate date);
    List<Car> findByReviewDateAfter(LocalDate date);
}
