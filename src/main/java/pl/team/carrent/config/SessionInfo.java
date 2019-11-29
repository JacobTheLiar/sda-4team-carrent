package pl.team.carrent.config;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.team.carrent.employee.Employee;
import pl.team.carrent.employee.EmployeeService;

import java.security.Principal;

/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 28.11.2019 13:32
 * *
 * @className: LoggedUser
 * *
 * *
 ******************************************************/
@Component
@Scope("session")
public class SessionInfo {

    private Employee employee;
    private EmployeeService employeeService;

    public SessionInfo(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getCurrentEmployee(Principal principal) {
        if (employee == null) {
            employee = employeeService.getEmployeeByUsername(principal.getName());
        }
        return employee;
    }

}
