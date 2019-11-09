package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.team.carrent.model.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: Łukasz C.  [https://github.com/lukasz-ciupek]
 * @date : 2019-10-27 14:41
 * *
 * @className: RentHistoryRepository
 * *
 * *
 ******************************************************/
public interface RentHistoryRepository extends JpaRepository<RentHistory, Integer> {

    //@Query("select r from RentHistory r where r.car.carModel.mark = :name")
    List<RentHistory> findByCar_CarModelMarkContainsIgnoreCase(String mark);
    List<RentHistory> findByCar_PlateNrContainsIgnoreCase(String plateNr);
    List<RentHistory> findByCar_CarModelModelContainsIgnoreCase(String model);
    //@Query("select r from RentHistory r where r.client.name = :name")
    List<RentHistory> findByClientNameContainsIgnoreCase(String name);
    List<RentHistory> findByClientEmailContainsIgnoreCase(String email);
    //@Query("select r from RentHistory r where r.promotion.name = :name")
    List<RentHistory> findByPromotionNameContainsIgnoreCase(String name);
    //@Query("select r from RentHistory r where r.rentPointStart.name = :name")
    List<RentHistory> findByRentPointStartNameContainsIgnoreCase(String name);
    //@Query("select r from RentHistory r where r.rentPointEnd.name = :name")
    List<RentHistory> findByRentPointEndNameContainsIgnoreCase(String name);
    //@Query("select r from RentHistory r where r.employeeStart.surname = :surname")
    List<RentHistory> findByEmployeeStartSurnameContainsIgnoreCase(String surname);
    //@Query("select r from RentHistory r where r.employeeEnd = :surname")
    List<RentHistory> findByEmployeeEndSurnameContainsIgnoreCase(String surname);
    //@Query("select r from RentHistory r where r.invoice.number = :number")
    List<RentHistory> findByInvoiceNumberContainsIgnoreCase(String number);

    List<RentHistory> findByRentTimeStartAfter(LocalDate rentTimeStart);
    List<RentHistory> findByRentTimeEnd(LocalDate rentTimeEnd);

}
