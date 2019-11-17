package pl.team.carrent.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-17 10:06
 * *
 * @className: ExceptionControllerAdvice
 * *
 * *
 ******************************************************/
@ControllerAdvice
public class ExceptionControllerAdvice{
    
    @ExceptionHandler
    public ModelAndView getExceptionForm(Exception exception){
        ModelAndView exceptionModel = new ModelAndView("exception");
        exceptionModel.addObject("message", exception.getMessage());
        exceptionModel.addObject("className", exception.getClass().getSimpleName());
        return exceptionModel;
    }
    
}
