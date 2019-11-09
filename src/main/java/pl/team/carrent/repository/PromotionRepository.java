package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.team.carrent.model.Car;
import pl.team.carrent.model.CarModel;
import pl.team.carrent.model.Promotion;

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

    List<Promotion> findByCarModels(CarModel carModel);

    List<Promotion> findAllByCars(Car car);





    /**
     *Czy potrzebna jest jeszcze jakś metoda?
     * **/
}
