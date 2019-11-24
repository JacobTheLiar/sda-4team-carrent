package pl.team.carrent.employee;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.team.carrent.service.EmployeeService;

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


    @GetMapping("")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
}
