package pl.team.carrent.rent_history;

public class RentHistoryNotExistException extends RuntimeException {
    public RentHistoryNotExistException(String message) {
        super(message);
    }
}
