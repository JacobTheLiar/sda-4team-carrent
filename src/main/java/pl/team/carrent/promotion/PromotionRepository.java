package pl.team.carrent.promotion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.team.carrent.car.Car;
import pl.team.carrent.client.Client;
import pl.team.carrent.promotion.Promotion;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


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

    List<Promotion> findByClients(Client client);

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

    @Query(value = "select p.* from promotion p" +
            " join promotion_clients pcli on pcli.promotion_id=p.id" +
            " join client c on c.id=pcli.clients_id " +
            " where UPPER(c.name) = UPPER(:name)", nativeQuery = true)
    List<Promotion> findPromotionByClientName(String name);

    @Query(value = "select p.* from promotion p" +
            " left join promotion_cars pca on p.id=pca.promotion_id" +
            " left join promotion_clients pcli on p.id=pcli.promotion_id" +
            " where (pca.cars_id=:carId or pcli.clients_id=:clientId) and (:date between p.promo_start and p.promo_end);", nativeQuery = true)
    List<Promotion> findAllMatchedPromotions(LocalDate date, int carId, int clientId);

    @Query(value = "select p.* from promotion p" +
            " left join promotion_cars pca on p.id=pca.promotion_id" +
            " where (pca.cars_id=:carId) and (:date between p.promo_start and p.promo_end);", nativeQuery = true)
    List<Promotion> findAllMatchedPromotionsByCarId(LocalDate date, int carId);

    @Query(value = "select p.* from promotion p" +
            " left join promotion_clients pcli on p.id=pcli.promotion_id" +
            " where (pcli.clients_id=:clientId) and (:date between p.promo_start and p.promo_end);", nativeQuery = true)
    List<Promotion> findAllMatchedPromotionsByClientId(LocalDate date, int clientId);

}
