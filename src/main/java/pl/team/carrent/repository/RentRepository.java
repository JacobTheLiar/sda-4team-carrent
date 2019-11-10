package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.team.carrent.model.Rent;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 05.11.2019 18:32
 * *
 * @className: RentRepository
 * *
 * *
 ******************************************************/
public interface RentRepository extends JpaRepository<Rent, Integer> {


    List<Rent> findByCar_PlateNr(String plateNr);

    List<Rent> findByCar_Vin(String vin);

    List<Rent> findByClient_NameContainsIgnoreCases(String name);

    List<Rent> findByClient_Id(int id);

    List<Rent> findByClient_EmailContainsIgnoreCases(String email);

    List<Rent> findByClient_TelephoneNr(String phone);

    List<Rent> findByClient_TaxNumber(String taxNumber);

    List<Rent> findByPromotion_Id(int id);

    List<Rent> findByPromotion_NameContainsIgnoreCases(String name);

    List<Rent> findByRentPointStart_Id(int id);

    List<Rent> findByRentPointStart_NameIgnoreCases(String name);

    List<Rent> findByRentTimeStartBetween(LocalDate date1, LocalDate date2);

    List<Rent> findByEmployeeStart_UsernameIgnoreCases(String username);

    List<Rent> findByNotesContainsIgnoreCases(String note);

}
