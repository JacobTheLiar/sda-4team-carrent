package pl.team.carrent.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.team.carrent.employee.Employee;
import pl.team.carrent.employee.EmployeeService;

import javax.servlet.http.HttpSession;
import java.security.Principal;


/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 23.11.2019 11:21
 * *
 * @className: LoginController
 * *
 * *
 ******************************************************/
@Controller
@RequestMapping("/login")
public class LoginController {


    private final EmployeeService employeeService;

    public LoginController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

}
