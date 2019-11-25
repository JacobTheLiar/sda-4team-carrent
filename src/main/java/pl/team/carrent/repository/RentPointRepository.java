package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.team.carrent.rent_point.RentPoint;

import java.util.List;


/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 03.11.2019 17:34
 * *
 * @className: RentPointRepository
 * *
 * *
 ******************************************************/
public interface RentPointRepository extends JpaRepository<RentPoint, Integer> {

    List<RentPoint> findByNameContains(String name);

    List<RentPoint> findByAddressContains(String address);

    List<RentPoint> findByPostCode(String postcode);

    List<RentPoint> findByCityContains(String city);
}
