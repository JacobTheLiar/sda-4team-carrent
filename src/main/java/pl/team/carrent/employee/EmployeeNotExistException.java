package pl.team.carrent.employee;

public class EmployeeNotExistException extends RuntimeException {
    public EmployeeNotExistException(String message) {
        super(message);
    }
}
