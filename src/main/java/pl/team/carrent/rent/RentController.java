package pl.team.carrent.rent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.team.carrent.car.CarService;
import pl.team.carrent.model.Employee;
import pl.team.carrent.model.Rent;
import pl.team.carrent.rent_point.RentPointService;
import pl.team.carrent.service.ClientService;
import pl.team.carrent.service.EmployeeService;
import pl.team.carrent.service.PromotionService;

import javax.jws.WebParam;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 17.11.2019 14:02
 * *
 * @className: RentController
 * *
 * *
 ******************************************************/
@Controller
@RequestMapping("/rent")
public class RentController {

    private final RentService rentService;
    private final CarService carService;
    private final ClientService clientService;
    private final PromotionService promotionService;
    private final RentPointService rentPointService;
    private final EmployeeService employeeService;

    public RentController(RentService rentService, CarService carService, ClientService clientService, PromotionService promotionService,
                          RentPointService rentPointService, EmployeeService employeeService) {
        this.rentService = rentService;
        this.carService = carService;
        this.clientService = clientService;
        this.promotionService = promotionService;
        this.rentPointService=rentPointService;
        this.employeeService=employeeService;
    }

    @GetMapping("")
    public ModelAndView getRentView(){
        ModelAndView modelAndView = new ModelAndView("rentList");
        modelAndView.addObject("searchByOptions",SearchRentOption.values());
        return modelAndView;
    }

    @GetMapping("/borrow")
    public ModelAndView getRentBorrow(){
        ModelAndView modelAndView = new ModelAndView("rentDetail");
        modelAndView.addObject("rent",new Rent());
        modelAndView.addObject("rents",rentService.getAllRents());
        modelAndView.addObject("rentPoints",rentPointService.getAllRentPoints());
        modelAndView.addObject("cars",carService.getAllActiveCars());
        modelAndView.addObject("clients",clientService.getAllClients());
        modelAndView.addObject("promotions",promotionService.getAllPromotions());
        modelAndView.addObject("employees",employeeService.getAllEmployees());
        return modelAndView;
    }

    @PostMapping("/borrow")
    public String postRentBorrow(@ModelAttribute Rent rent){
        rentService.addOrUpdateRent(rent);
        return "redirect:/borrow";
    }
}
