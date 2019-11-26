package pl.team.carrent.promotion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.team.carrent.car.Car;
import pl.team.carrent.promotion.Promotion;

import java.util.List;


/******************************************************
 * @author: Michal S.  
 * [https://github.com/DreamDoer86]
 * @date : 27.10.2019 14:19
 * *
 * @className: PromotionRepository
 * *
 ******************************************************/
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    List<Promotion> findByNameContainsIgnoreCase(String name);

    List<Promotion> findByPromoEndIsNull();

    List<Promotion> findByDiscountPercentage(int discountPercentage);

    List<Promotion> findByCars(Car car);

   @Query(value = "select distinct p.* from promotion p" +
           " join promotion_cars pc on pc.promotion_id=p.id" +
           " join car c on c.id=pc.cars_id " +
           " join car_model cm on cm.id = c.car_model_id" +
           " where UPPER(cm.mark) = UPPER(:mark)", nativeQuery = true)
    List<Promotion> findPromotionByCarMark(String mark);

    @Query(value = "select distinct p.* from promotion p" +
            " join promotion_cars pc on pc.promotion_id=p.id" +
            " join car c on c.id=pc.cars_id " +
            " join car_model cm on cm.id = c.car_model_id" +
            " where UPPER(cm.model) = UPPER(:model)", nativeQuery = true)
    List<Promotion> findPromotionByCarModel(String model);

    @Query(value = "select p.* from promotion p" +
            " join promotion_cars pc on pc.promotion_id=p.id" +
            " join car c on c.id=pc.cars_id " +
            " join car_model cm on cm.id = c.car_model_id" +
            " where UPPER(cm.segment) = UPPER(:segment)", nativeQuery = true)
    List<Promotion> findPromotionByCarSegment(String segment);

}
