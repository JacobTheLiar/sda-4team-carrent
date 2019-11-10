package pl.team.carrent.car;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 09.11.2019 12:28
 * *
 * @className: CarNotExistException
 * *
 * *
 ******************************************************/
public class CarNotExistException extends RuntimeException {

    public CarNotExistException(String message) {
        super(message);
    }
}
