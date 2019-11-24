package pl.team.carrent.rent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.team.carrent.car.CarService;
import pl.team.carrent.model.Rent;
import pl.team.carrent.rent_point.RentPointService;
import pl.team.carrent.service.ClientService;
import pl.team.carrent.service.EmployeeService;
import pl.team.carrent.service.PromotionService;

import java.time.LocalDate;

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
//    private final RentHistoryService rentHistoryService;

    public RentController(RentService rentService, CarService carService, ClientService clientService, PromotionService promotionService,
                          RentPointService rentPointService, EmployeeService employeeService) {
        this.rentService = rentService;
        this.carService = carService;
        this.clientService = clientService;
        this.promotionService = promotionService;
        this.rentPointService = rentPointService;
        this.employeeService = employeeService;
//        this.rentHistoryService=rentHistoryService;
    }

    @GetMapping("")
    public ModelAndView getRentView() {
        ModelAndView modelAndView = new ModelAndView("rentList");
        modelAndView.addObject("rents", rentService.getAllRents());
        modelAndView.addObject("searchByOptions", SearchRentOption.values());
        return modelAndView;
    }

    @GetMapping("/borrow")
    public ModelAndView getRentBorrow(@PathVariable(required = false) Integer id) {
        Rent rent = new Rent();
        rent.setRentTimeStart(LocalDate.now());
        if (id != null) {
            rent.setId(id);
        }
        ModelAndView modelAndView = new ModelAndView("rentDetail");
        modelAndView.addObject("todayDate", LocalDate.now());
        modelAndView.addObject("rent", rent);
        modelAndView.addObject("rentPoints", rentPointService.getAllRentPoints());
        modelAndView.addObject("cars", carService.getAllActiveCars());
        modelAndView.addObject("clients", clientService.getAllClients());
        modelAndView.addObject("promotions", promotionService.getAllPromotions());
        modelAndView.addObject("employees", employeeService.getAllEmployees());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getRentEdit(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("rentDetail");
        modelAndView.addObject("todayDate", LocalDate.now());
        modelAndView.addObject("rent", rentService.getRentById(id));
        modelAndView.addObject("rentPoints", rentPointService.getAllRentPoints());
        modelAndView.addObject("cars", carService.getAllActiveCars());
        modelAndView.addObject("clients", clientService.getAllClients());
        modelAndView.addObject("promotions", promotionService.getAllPromotions());
        modelAndView.addObject("employees", employeeService.getAllEmployees());
        return modelAndView;
    }

    @PostMapping("/borrow")
    public String postRentBorrow(@ModelAttribute Rent rent, @RequestParam(required = false) Integer id) {
        if (id != null) {
            rent.setId(id);
        }
        rentService.addOrUpdateRent(rent);
        return "redirect:/rent/";
    }

    @GetMapping("/return")
    public ModelAndView getRentReturn() {
        return new ModelAndView("rentReturnByPlate");
    }

    @GetMapping("/return/{id}")
    public ModelAndView getRentReturnById(@PathVariable(required = false) Integer id) {
        ModelAndView modelAndView = new ModelAndView("rentReturnDetail");
      if (id != null) {
            modelAndView.addObject("rent", rentService.getRentById(id));
        } else  {
            modelAndView.addObject("rents", rentService.getAllRents());
        }
        return modelAndView;
    }

    @PostMapping("/return")
    public ModelAndView postRentReturn(@RequestParam(required = false) String plateNr) {
        ModelAndView modelAndView = new ModelAndView("rentReturnDetail");
        if (plateNr != null ) {
            modelAndView.addObject("rent", rentService.getRentByPlateNr(plateNr));
        }
        return modelAndView;
    }
}
