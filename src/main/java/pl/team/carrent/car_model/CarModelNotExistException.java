package pl.team.carrent.car_model;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 16.11.2019 10:02
 * *
 * @className: CarModelNotExistException
 * *
 * *
 ******************************************************/
public class CarModelNotExistException extends RuntimeException {
    public CarModelNotExistException(String message) {
        super(message);
    }
}
