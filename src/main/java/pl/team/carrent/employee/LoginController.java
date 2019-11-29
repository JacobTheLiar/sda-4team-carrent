package pl.team.carrent.employee;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.team.carrent.config.SessionInfo;


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
