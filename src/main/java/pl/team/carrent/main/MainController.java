package pl.team.carrent.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.team.carrent.employee.Employee;
import pl.team.carrent.employee.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-17 11:07
 * *
 * @className: MainController
 * *
 * *
 ******************************************************/
@Controller
@RequestMapping("/")
public class MainController {

    private final EmployeeService employeeService;

    public MainController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ModelAndView getMainForm(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        System.out.println("***************************************************************************************");
        System.out.println("logged as "+employee.getFullUserName());
        System.out.println("***************************************************************************************");
        return new ModelAndView("main");
    }

    @GetMapping("/accessDenied")
    public ModelAndView getAccessDeniedPage() {
        return new ModelAndView("accessDenied");
    }

}
