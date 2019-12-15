package pl.team.carrent.company;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-12-15 17:37
 * *
 * @className: CompanyController
 * *
 * *
 ******************************************************/
@Controller
@RequestMapping("/company")
public class CompanyController{
    
    private final CompanyService companyService;
    
    
    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }
    
    
    @GetMapping
    private ModelAndView getCompanyDetail(@RequestParam(required = false) Boolean saved){
        ModelAndView companyView = new ModelAndView("company");
        Boolean wasSaved = saved==null ? false : saved;
        companyView.addObject("company", companyService.getCompanyDetail());
        companyView.addObject("saved", wasSaved);
        return companyView;
    }
    
    @PostMapping
    private String setCompanyDetail(@ModelAttribute Company company){
        companyService.setCompanyData(company);
        return "redirect:/company?saved=true";
    }
}
