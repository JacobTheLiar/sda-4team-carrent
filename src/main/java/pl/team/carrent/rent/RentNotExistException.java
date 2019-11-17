package pl.team.carrent.rent;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 17.11.2019 17:53
 * *
 * @className: RentNotExistException
 * *
 * *
 ******************************************************/
public class RentNotExistException extends RuntimeException {
    public RentNotExistException(String message) {
        super(message);
    }
}
