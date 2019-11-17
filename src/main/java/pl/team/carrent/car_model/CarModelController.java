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

    @GetMapping(value = "")
    public ModelAndView getCarModelPage(@RequestParam(required = false) String searchWhat, @RequestParam(required = false) String searchBy) {
        ModelAndView modelAndView = new ModelAndView("carModelList");
        modelAndView.addObject("searchByOptions", SearchCarModelOption.values());
        if (searchWhat == null || searchBy == null || searchWhat.isEmpty() || searchBy.isEmpty()) {
            modelAndView.addObject("isFiltered", false);
            modelAndView.addObject("carModels", carModelService.getAllCarModels());
        } else {
            modelAndView.addObject("isFiltered", true);
            modelAndView.addObject("carModels", carModelService.searchCarModels(searchWhat, SearchCarModelOption.valueOf(searchBy)));
        }
        return modelAndView;
    }


    @GetMapping(value = "/add")
    public ModelAndView getCarModelAddNewModel() {
        ModelAndView modelAndViewToAddAndEdit = new ModelAndView("carModelDetail");
        modelAndViewToAddAndEdit.addObject("update", false);
        return modelAndViewToAddAndEdit;
    }


    @GetMapping(value = "/{id}")
    public ModelAndView postCarModelEditModel(@PathVariable int id) {
        ModelAndView modelAndViewToAddAndEdit = new ModelAndView("carModelDetail");
        modelAndViewToAddAndEdit.addObject("update", true);
        modelAndViewToAddAndEdit.addObject("carModel", carModelService.getCarModelById(id));
        return modelAndViewToAddAndEdit;
    }

    @PostMapping(value = "/save")
    public String postCarModelSaveModel(@ModelAttribute CarModel carModel) {
        carModelService.updateCarModel(carModel);
        return "redirect:/car/model/";
    }
}

