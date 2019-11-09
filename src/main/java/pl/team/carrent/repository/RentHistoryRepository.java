package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.team.carrent.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author: Łukasz C.  [https://github.com/lukasz-ciupek]
 * @date : 2019-10-27 14:41
 * *
 * @className: RentHistoryRepository
 * *
 * *
 ******************************************************/
public interface RentHistoryRepository extends JpaRepository<RentHistory, Integer> {

    @Query("select r from RentHistory r where r.car.carModel.mark = :name")
    List<RentHistory> findByCarModelName(String name);
    @Query("select r from RentHistory r where r.client.name = :name")
    List<RentHistory> findByClientName(String name);
    @Query("select r from RentHistory r where r.promotion.name = :name")
    List<RentHistory> findByPromotionName(String name);
    @Query("select r from RentHistory r where r.rentPointStart.name = :name")
    List<RentHistory> findByRentPointStartName(String name);
    @Query("select r from RentHistory r where r.rentPointEnd.name = :name")
    List<RentHistory> findByRentPointEndName(String name);
    @Query("select r from RentHistory r where r.employeeStart.surname = :surname")
    List<RentHistory> findByEmployeeStartSurname(String surname);
    @Query("select r from RentHistory r where r.employeeEnd = :surname")
    List<RentHistory> findByEmployeeEndSurname(String surname);
    @Query("select r from RentHistory r where r.invoice.number = :number")
    Optional<RentHistory> findByInvoiceNumber(String number);

    List<RentHistory> findByRentTimeStart(LocalDate rentTimeStart);
    List<RentHistory> findByRentTimeEnd(LocalDate rentTimeEnd);

}
