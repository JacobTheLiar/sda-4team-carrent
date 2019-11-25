package pl.team.carrent.rent_point;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 17.11.2019 10:02
 * *
 * @className: RentPointController
 * *
 * *
 ******************************************************/
@Controller
@RequestMapping("/rentPoint")
public class RentPointController {

    private final RentPointService rentPointService;

    public RentPointController(RentPointService rentPointService){
        this.rentPointService=rentPointService;
    }

    @GetMapping("")
    public ModelAndView getRentPoint(){
        ModelAndView modelAndView = new ModelAndView("rentPointList");
        modelAndView.addObject("rentPoints",rentPointService.getAllRentPoints());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView getRentPointAddView(){
        ModelAndView modelAndView = new ModelAndView("rentPointDetail");
        modelAndView.addObject("rentPoint",new RentPoint());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getRentPointEditView(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("rentPointDetail");
        modelAndView.addObject("rentPoint",rentPointService.getRentPointById(id));
        return modelAndView;
    }

    @PostMapping("/save")
    public String postRentPointSave(@ModelAttribute RentPoint rentPoint){
        rentPointService.saveOrUpdateRentPoint(rentPoint);
        return "redirect:/rentPoint/";
    }

}
