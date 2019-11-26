package pl.team.carrent.rent_history;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Łukasz C.  [https://github.com/lukasz-ciupek]
 * @date : 2019-11-16 10:11
 * *
 * @className: RentHistoryService
 * *
 * *
 ******************************************************/
@Service
public class RentHistoryService {

    private final RentHistoryRepository rentHistoryRepository;

    public RentHistoryService(RentHistoryRepository rentHistoryRepository) {
        this.rentHistoryRepository = rentHistoryRepository;
    }

    public RentHistory addRentHistory (RentHistory rentHistory) {
        return rentHistoryRepository.save(rentHistory);
    }

    public Set<RentHistory> getAllRentHistory() {
        return new HashSet<>(rentHistoryRepository.findAll());
    }

    public Set<RentHistory> getRentHistoryByCarMark(String mark) {
        return rentHistoryRepository.findByCar_CarModelMarkContainsIgnoreCase(mark);
    }

    public Set<RentHistory> getRentHistoryByPlateNr(String plateNr) {
        return rentHistoryRepository.findByCar_PlateNrContainsIgnoreCase(plateNr);
    }

    public Set<RentHistory> getRentHistoryByModel(String model) {
        return rentHistoryRepository.findByCar_CarModelModelContainsIgnoreCase(model);
    }

    public Set<RentHistory> getRentHistoryByClientName(String clientName) {
        return rentHistoryRepository.findByClientNameContainsIgnoreCase(clientName);
    }

    public Set<RentHistory> getRentHistoryByClientEmail(String clientEmail) {
        return rentHistoryRepository.findByClientEmailContainsIgnoreCase(clientEmail);
    }

    public Set<RentHistory> getRentHistoryByPromotionName(String promotionName) {
        return rentHistoryRepository.findByPromotionNameContainsIgnoreCase(promotionName);
    }

    public Set<RentHistory> getRentHistoryByRentPointStartName(String rentPointStartName) {
        return rentHistoryRepository.findByRentPointStartNameContainsIgnoreCase(rentPointStartName);
    }

    public Set<RentHistory> getRentHistoryByRentPointEndName(String rentPointEndName) {
        return rentHistoryRepository.findByRentPointEndNameContainsIgnoreCase(rentPointEndName);
    }

    public Set<RentHistory> getRentHistoryByEmployeeStartSurname(String surname) {
        return rentHistoryRepository.findByEmployeeStartSurnameContainsIgnoreCase(surname);
    }

    public Set<RentHistory> getRentHistoryByEmployeeEndSurname(String surname) {
        return rentHistoryRepository.findByEmployeeEndSurnameContainsIgnoreCase(surname);
    }

    public Set<RentHistory> getRentHistoryByInvoiceNumber(String invoiceNumber) {
        return rentHistoryRepository.findByInvoiceNumberContainsIgnoreCase(invoiceNumber);
    }

    public Set<RentHistory> getRentHistoryByRentTimeStartAfter(LocalDate rentTimeStart) {
        return rentHistoryRepository.findByRentTimeStartAfter(rentTimeStart);
    }

    public Set<RentHistory> getRentHistoryByRentTimeEnd(LocalDate rentTimeEnd) {
        return rentHistoryRepository.findByRentTimeEnd(rentTimeEnd);
    }
}
