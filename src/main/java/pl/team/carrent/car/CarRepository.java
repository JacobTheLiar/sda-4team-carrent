package pl.team.carrent.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;


/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 27.10.2019 14:15
 * *
 * @className: CarRepository
 * *
 * *
 ******************************************************/
public interface CarRepository extends JpaRepository<Car, Integer> {


    Optional<Car> findByPlateNr(String plateNr);

    List<Car> findByPlateNrContainsIgnoreCase(String plateNr);

    List<Car> findByPlateNrContainsIgnoreCaseAndActiveIs(String plateNr, boolean active);

    Optional<Car> findByVin(String vin);

    List<Car> findByVinContainsIgnoreCase(String vin);

    List<Car> findByVinContainsIgnoreCaseAndActiveIs(String vin, boolean active);

    List<Car> findByActiveEquals(boolean active);

    List<Car> findByColorContainsIgnoreCase(String color);

    List<Car> findByColorContainsIgnoreCaseAndActiveIs(String color, boolean active);

    List<Car> findByCarModelTypeContainsIgnoreCase(String type);

    List<Car> findByCarModelTypeContainsIgnoreCaseAndActiveIs(String type, boolean active);

    List<Car> findByCarModelSegmentContains(String segment);

    List<Car> findByCarModelSegmentContainsIgnoreCaseAndActiveIs(String segment, boolean active);

    List<Car> findByCarModel_ModelContainsIgnoreCase(String model);

    @Query(value = "select c.*, rh.rent_time_end, rh.rent_point_end_id, r.rent_time_start, r.rent_point_start_id " +
            "from car c " +
            "left join rent_history rh on rh.car_id=c.id " +
            "left join rent r on r.car_id=c.id " +
            "where (EXISTS(select rh.rent_point_end_id,  rh.rent_time_end from rent_history rh where c.id=rh.car_id and rh.rent_point_end_id=:rentPointId) " +
            "or NOT EXISTS(select rh.rent_point_end_id,  rh.rent_time_end from rent_history rh where c.id=rh.car_id and c.begin_rent_point_id=:rentPointId)) " +
            "and NOT EXISTS(select r.rent_point_start_id from rent r where c.id=r.car_id) and c.active=true", nativeQuery = true)
    Set<Car> findByActualRentPoint(int rentPointId);
}