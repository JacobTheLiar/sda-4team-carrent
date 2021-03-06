package pl.team.carrent.config;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.team.carrent.employee.Employee;
import pl.team.carrent.employee.EmployeeService;

import java.security.Principal;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-10 14:39
 * *
 * @className: CheckController
 * *
 * *
 ******************************************************/
@Controller
@RequestMapping("/test")
public class CheckController{
    

    private final EmployeeService employeeService;

    public CheckController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ModelAndView getTest(){
        return new ModelAndView("check");
    }

    @GetMapping("/user")
    @ResponseBody
    public String getUserName(Principal principal){
        String userName = principal.getName();

        Employee employee = employeeService.getEmployeeByUsername(userName);
        return employee.getFullUserName();
    }

}
