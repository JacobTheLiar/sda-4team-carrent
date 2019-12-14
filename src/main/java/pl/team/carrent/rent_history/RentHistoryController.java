package pl.team.carrent.rent_history;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.team.carrent.car.CarService;
import pl.team.carrent.client.ClientService;
import pl.team.carrent.employee.EmployeeService;
import pl.team.carrent.invoice.InvoiceService;
import pl.team.carrent.promotion.PromotionService;
import pl.team.carrent.rent_point.RentPointService;

@Controller
@RequestMapping("/rent/history")
public class RentHistoryController {

    private final RentHistoryService rentHistoryService;
    private final CarService carService;
    private final ClientService clientService;
    private final PromotionService promotionService;
    private final RentPointService rentPointService;
    private final EmployeeService employeeService;
    private final InvoiceService invoiceService;

    public RentHistoryController(RentHistoryService rentHistoryService, CarService carService, ClientService clientService, PromotionService promotionService, RentPointService rentPointService, EmployeeService employeeService, InvoiceService invoiceService) {
        this.rentHistoryService = rentHistoryService;
        this.carService = carService;
        this.clientService = clientService;
        this.promotionService = promotionService;
        this.rentPointService = rentPointService;
        this.employeeService = employeeService;
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public ModelAndView getRentHistoryView(@RequestParam(required = false) String searchWhat, @RequestParam(required = false) SearchRentHistoryOption searchBy) {
        ModelAndView model = new ModelAndView("rentHistoryList");

        if (searchWhat == null){
            model.addObject("rentHistory",rentHistoryService.getAllRentHistory());
        } else {
            model.addObject("rentHistory", rentHistoryService.searchRentHistory(searchWhat,searchBy));
        }
        model.addObject("options", SearchRentHistoryOption.values());
        return model;
    }
}
