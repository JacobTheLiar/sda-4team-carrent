package pl.team.carrent.car_review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.team.carrent.car.CarService;

import java.time.LocalDate;

/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 17.11.2019 10:57
 * *
 * @className: CarReviewController
 * *
 * *
 ******************************************************/
@Controller
@RequestMapping("/carReview")
public class CarReviewController {

    private final CarReviewService carReviewService;
    private final CarService carService;

    public CarReviewController(CarReviewService carReviewService, CarService carService) {
        this.carReviewService = carReviewService;
        this.carService = carService;
    }

    @GetMapping("/{carId}")
    public ModelAndView getCarReview(@PathVariable int carId) {
        ModelAndView modelAndView = new ModelAndView("carReviewList");
        modelAndView.addObject("carId",carId);
        modelAndView.addObject("todayDate",LocalDate.now());
        modelAndView.addObject("carReviews", carReviewService.getCarReviewByCarId(carId));
        return modelAndView;
    }


    @GetMapping("/add/{carId}")
    public ModelAndView getCarReviewAdd(@PathVariable int carId) {
        ModelAndView modelAndView = new ModelAndView("carReviewDetail");
        modelAndView.addObject("todayDate",LocalDate.now());
        modelAndView.addObject("car", carService.getCarById(carId));
        CarReview carReview = new CarReview();
        carReview.setReviewDate(LocalDate.now());
        modelAndView.addObject("carReview", carReview);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getCarReviewEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("carReviewDetail");
        modelAndView.addObject("car",carReviewService.getCarById(id));
        modelAndView.addObject("todayDate",LocalDate.now());
        modelAndView.addObject("carReview", carReviewService.getCarReviewById(id));
        return modelAndView;
    }

    @PostMapping("/save")
    public String postCarReviewSave(@RequestParam int carId, @RequestParam(required = false) int id, @RequestParam int counterState, @RequestParam String reviewDate) {
        if (id != 0) {
            CarReview carReview = carReviewService.getCarReviewById(id);
            carReview.setCounterState(counterState);
            carReview.setReviewDate(LocalDate.parse(reviewDate));
            carReviewService.addOrUpdateCarReview(carReview);
        } else {
            carReviewService.addOrUpdateCarReview(new CarReview(carService.getCarById(carId), counterState, LocalDate.parse(reviewDate)));
        }
        return "redirect:/carReview/"+carId;
    }
}
