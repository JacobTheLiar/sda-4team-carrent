package pl.team.carrent.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


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
    
    
    @GetMapping
    public ModelAndView getTest(){
        return new ModelAndView("check");
    }
}
