package pl.team.carrent.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


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
public class MainController{
    
    @GetMapping
    public ModelAndView getMainForm(){
        return new ModelAndView("main");
    }
    
    
}
