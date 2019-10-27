package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.team.carrent.model.*;

import java.time.LocalDate;
import java.util.Optional;
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

    @Query("select r from RentHistory r where r.car.carModel.mark = :name")
    Set<RentHistory> findByCarModelName(String name);
    @Query("select r from RentHistory r where r.client.name = :name")
    Set<RentHistory> findByClientName(String name);
    @Query("select r from RentHistory r where r.promotion.name = :name")
    Set<RentHistory> findByPromotionName(String name);
    @Query("select r from RentHistory r where r.rentPointStart.name = :name")
    Set<RentHistory> findByRentPointStartName(String name);
    @Query("select r from RentHistory r where r.rentPointEnd.name = :name")
    Set<RentHistory> findByRentPointEndName(String name);
    @Query("select r from RentHistory r where r.employeeStart.surname = :surname")
    Set<RentHistory> findByEmployeeStartSurname(String surname);
    @Query("select r from RentHistory r where r.employeeEnd = :surname")
    Set<RentHistory> findByEmployeeEndSurname(String surname);
    @Query("select r from RentHistory r where r.invoice.number = :number")
    Optional<RentHistory> findByInvoiceNumber(String number);

    Set<RentHistory> findByRentTimeStart(LocalDate rentTimeStart);
    Set<RentHistory> findByRentTimeEnd(LocalDate rentTimeEnd);

}
