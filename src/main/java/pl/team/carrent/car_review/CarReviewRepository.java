package pl.team.carrent.car_review;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.team.carrent.car_review.CarReview;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 27.10.2019 14:18
 * *
 * @className: CarReviewRepository
 * *
 * *
 ******************************************************/
public interface CarReviewRepository extends JpaRepository<CarReview, Integer> {

    Optional<CarReview> findByCar_PlateNr(String plateNr);

    Optional<CarReview> findByCar_Vin(String vin);

    List<CarReview> findByReviewDateBetween(LocalDate date1, LocalDate date2);

    List<CarReview> findByReviewDateBefore(LocalDate date);

    List<CarReview> findByReviewDateAfter(LocalDate date);

    List<CarReview> findByCar_Id(int carId);
}
