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

    List<RentHistory> findByCar_CarModelMarkContainsIgnoreCase(String mark);
    List<RentHistory> findByCar_PlateNrContainsIgnoreCase(String plateNr);
    List<RentHistory> findByCar_CarModelModelContainsIgnoreCase(String model);
    List<RentHistory> findByClientNameContainsIgnoreCase(String name);
    List<RentHistory> findByClientEmailContainsIgnoreCase(String email);
    List<RentHistory> findByPromotionNameContainsIgnoreCase(String name);
    List<RentHistory> findByRentPointStartNameContainsIgnoreCase(String name);
    List<RentHistory> findByRentPointEndNameContainsIgnoreCase(String name);
    List<RentHistory> findByEmployeeStartSurnameContainsIgnoreCase(String surname);
    List<RentHistory> findByEmployeeEndSurnameContainsIgnoreCase(String surname);
    List<RentHistory> findByInvoiceNumberContainsIgnoreCase(String number);
    List<RentHistory> findByRentTimeStartAfter(LocalDate rentTimeStart);
    List<RentHistory> findByRentTimeEnd(LocalDate rentTimeEnd);

}
