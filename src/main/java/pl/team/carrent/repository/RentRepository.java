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


    Rent findByCar_PlateNr(String plateNr);

    Rent findByCar_Vin(String vin);

    List<Rent> findByClient_NameContainsIgnoreCase(String name);

    List<Rent> findByClient_Id(int id);

    List<Rent> findByClient_EmailContainsIgnoreCase(String email);

    List<Rent> findByClient_TelephoneNr(String phone);

    List<Rent> findByClient_TaxNumber(String taxNumber);

    List<Rent> findByPromotion_Id(int id);

    List<Rent> findByPromotion_NameContainsIgnoreCase(String name);

    List<Rent> findByRentPointStart_Id(int id);

    List<Rent> findByRentPointStart_NameIgnoreCase(String name);

    List<Rent> findByRentTimeStartBetween(LocalDate date1, LocalDate date2);

    List<Rent> findByEmployeeStart_UsernameIgnoreCase(String username);

    List<Rent> findByNotesContainsIgnoreCase(String note);

}
