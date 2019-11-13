package pl.team.carrent.car_model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.team.carrent.model.CarModel;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 10.11.2019 15:10
 * *
 * @className: CarModelController
 * *
 * *
 ******************************************************/
@Controller
@RequestMapping("/car/model")
public class CarModelController {

    private final CarModelService carModelService;

    public CarModelController(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    ModelAndView modelAndView = new ModelAndView("carModel");
    ModelAndView modelAndViewToAddAndEdit = new ModelAndView("carModelAddUpdate");

    @GetMapping(value = "/")
    public ModelAndView getCarModelPage() {
        modelAndView.addObject("carModels", carModelService.getAllCarModels());
        return modelAndView;
    }

    @PostMapping(value = "/")
    public ModelAndView postSearchCarModels(@RequestParam String searchWhat, @RequestParam String searchBy) {
        modelAndView.addObject("carModels", carModelService.searchCarModels(searchWhat, SearchCarModelOption.valueOf(searchBy)));
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView getCarModelAddNewModel() {
        modelAndViewToAddAndEdit.addObject("update",false);
        return modelAndViewToAddAndEdit;
    }

    @PostMapping(value = "/add")
    public ModelAndView postCarModelAddNewModel(@RequestParam String mark, @RequestParam String model,
                                                @RequestParam String segment, @RequestParam String type,
                                                @RequestParam String productionYear, @RequestParam String reviewInterval) {
        carModelService.addCarModel(new CarModel(mark, model, segment, type, Integer.valueOf(productionYear), Integer.valueOf(reviewInterval)));
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView postCarModelEditModel(@RequestParam int id) {
        modelAndViewToAddAndEdit.addObject("update",true);
        modelAndViewToAddAndEdit.addObject("carModel", carModelService.getCarModelById(id));
        return modelAndViewToAddAndEdit;
    }

    @PostMapping(value = "/save")
    public ModelAndView postCarModelSaveModel(@ModelAttribute CarModel carModel) {
        carModelService.updateCarModel(carModel);
        return modelAndView;
    }
}

