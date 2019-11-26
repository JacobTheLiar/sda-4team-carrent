package pl.team.carrent.rent;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 10.11.2019 11:40
 * *
 * @className: RentService
 * *
 * *
 ******************************************************/
@Service
public class RentService {

    private final RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    public List<Rent> searchRents(String findWhat, SearchRentOption findBy) {
        switch (findBy) {
            case BY_CAR_PLATE_NR:
                return Arrays.asList(rentRepository.findByCar_PlateNr(findWhat));
            case BY_CAR_VIN:
                return Arrays.asList(rentRepository.findByCar_Vin(findWhat));
            case BY_CLIENT_NAME:
                return rentRepository.findByClient_NameContainsIgnoreCase(findWhat);
            case BY_CLIENT_ID:
                return rentRepository.findByClient_Id(Integer.valueOf(findWhat));
            case BY_CLIENT_EMAIL:
                return rentRepository.findByClient_EmailContainsIgnoreCase(findWhat);
            case BY_CLIENT_PHONE:
                return rentRepository.findByClient_TelephoneNr(findWhat);
            case BY_CLIENT_TAX_NUMBER:
                return rentRepository.findByClient_TaxNumber(findWhat);
            case BY_PROMOTION_ID:
                return rentRepository.findByPromotion_Id(Integer.valueOf(findWhat));
            case BY_PROMOTION_NAME:
                return rentRepository.findByPromotion_NameContainsIgnoreCase(findWhat);
            case BY_RENT_POINT_START_ID:
                return rentRepository.findByRentPointStart_Id(Integer.valueOf(findWhat));
            case BY_RENT_POINT_START_NAME:
                return rentRepository.findByRentPointStart_NameIgnoreCase(findWhat);
            case BY_RENT_NUMBER_OF_WEEKS:
                LocalDate dateFrom = LocalDate.now().plusWeeks(-Integer.parseInt(findWhat));
                return rentRepository.findByRentTimeStartBetween(dateFrom,LocalDate.now());
            case BY_EMPLOYEE_USERNAME_START:
                return rentRepository.findByEmployeeStart_UsernameIgnoreCase(findWhat);
            case BY_NOTES_START:
                return rentRepository.findByNotesContainsIgnoreCase(findWhat);
        }
        return Collections.emptyList();
    }

    public Rent addOrUpdateRent(Rent rent){
        return rentRepository.save(rent);
    }

    public Rent getRentById(Integer id) {
        return rentRepository.findById(id).orElseThrow(()->new RentNotExistException("Brak wypożyczenia o numerze id: "+id));
    }

    public Rent getRentByPlateNr(String plateNr) {
        return rentRepository.findByCar_PlateNr(plateNr);
    }
}
