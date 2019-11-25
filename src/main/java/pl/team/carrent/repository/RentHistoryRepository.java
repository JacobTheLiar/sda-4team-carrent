package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.team.carrent.model.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author: Łukasz C.  [https://github.com/lukasz-ciupek]
 * @date : 2019-10-27 14:41
 * *
 * @className: RentHistoryRepository
 * *
 * *
 ******************************************************/
public interface RentHistoryRepository extends JpaRepository<RentHistory, Integer> {

    Set<RentHistory> findByCar_CarModelMarkContainsIgnoreCase(String mark);
    Set<RentHistory> findByCar_PlateNrContainsIgnoreCase(String plateNr);
    Set<RentHistory> findByCar_CarModelModelContainsIgnoreCase(String model);
    Set<RentHistory> findByClientNameContainsIgnoreCase(String name);
    Set<RentHistory> findByClientEmailContainsIgnoreCase(String email);
    Set<RentHistory> findByPromotionNameContainsIgnoreCase(String name);
    Set<RentHistory> findByRentPointStartNameContainsIgnoreCase(String name);
    Set<RentHistory> findByRentPointEndNameContainsIgnoreCase(String name);
    Set<RentHistory> findByEmployeeStartSurnameContainsIgnoreCase(String surname);
    Set<RentHistory> findByEmployeeEndSurnameContainsIgnoreCase(String surname);
    Set<RentHistory> findByInvoiceNumberContainsIgnoreCase(String number);
    Set<RentHistory> findByRentTimeStartAfter(LocalDate rentTimeStart);
    Set<RentHistory> findByRentTimeEnd(LocalDate rentTimeEnd);

}
