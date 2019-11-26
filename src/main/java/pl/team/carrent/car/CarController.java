package pl.team.carrent.car;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.team.carrent.car_model.CarModelService;

import java.time.LocalDate;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 16.11.2019 12:15
 * *
 * @className: CarController
 * *
 * *
 ******************************************************/
@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    private final CarModelService carModelService;

    public CarController(CarService carService, CarModelService carModelService) {
        this.carService = carService;
        this.carModelService=carModelService;
    }

    @GetMapping("")
    public ModelAndView getCars(@RequestParam(required = false) String searchWhat, @RequestParam(required = false) String searchBy) {
        ModelAndView modelAndView = new ModelAndView("carList");
        modelAndView.addObject("searchByOptions", SearchCarOption.values());
        if (searchWhat == null || searchBy == null || searchWhat.isEmpty() || searchBy.isEmpty()) {
            modelAndView.addObject("isFiltered", false);
            modelAndView.addObject("cars", carService.getAllActiveCars());
        } else {
            modelAndView.addObject("isFiltered", true);
            modelAndView.addObject("cars", carService.searchActiveCars(searchWhat, SearchCarOption.valueOf(searchBy)));
        }
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView getCarDetailsToAdd() {
        ModelAndView modelAndViewDetails = new ModelAndView("carDetail");
        modelAndViewDetails.addObject("carModels",carModelService.getAllCarModels());
        modelAndViewDetails.addObject("update", false);
        return modelAndViewDetails;
    }

    @GetMapping("/{id}")
    public ModelAndView getCarDetailsToUpdate(@PathVariable int id) {
        ModelAndView modelAndViewDetails = new ModelAndView("carDetail");
        modelAndViewDetails.addObject("carModels",carModelService.getAllCarModels());
        modelAndViewDetails.addObject("update",true);
        modelAndViewDetails.addObject("car", carService.getCarById(id));
        return modelAndViewDetails;
    }

    @PostMapping("/save")
    public String saveCarDetails(@RequestParam int carModelId, @RequestParam String plateNr, @RequestParam String registrationDate,
                                 @RequestParam String vin, @RequestParam String color, @RequestParam double pricePerDay,
                                 @RequestParam(required = false) Integer id){
        Car car = new Car(carModelService.getCarModelById(carModelId), LocalDate.parse(registrationDate), plateNr, vin, color, pricePerDay);
        if(id!=null){
            car.setId(id);
        }
        carService.addOrUpdateCar(car);
        return "redirect:/car/";
    }

}
