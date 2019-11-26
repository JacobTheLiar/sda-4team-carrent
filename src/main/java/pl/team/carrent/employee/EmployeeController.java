package pl.team.carrent.employee;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.team.carrent.rent_point.RentPointService;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final RentPointService rentPointService;
    private final RoleService roleService;

    public EmployeeController(EmployeeService employeeService, RentPointService rentPointService, RoleService roleService) {
        this.employeeService = employeeService;
        this.rentPointService = rentPointService;
        this.roleService = roleService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       LocalDate.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping
    public ModelAndView getEmployeeList(@RequestParam(required = false) String searchWhat, @RequestParam(required = false) SearchEmployeeOption searchBy) {
        ModelAndView model = new ModelAndView("employeeList");
        if (searchWhat == null) {
            model.addObject("employees", employeeService.getAllEmployees());
        } else {
            model.addObject("employees", employeeService.searchEmployees(searchWhat,searchBy));
        }
        model.addObject("options", SearchEmployeeOption.values());
        return model;
    }

    @GetMapping("/{username}")
    public ModelAndView getEmployeeDetails(@PathVariable String username) {
        ModelAndView model = new ModelAndView("employeeDetail");
        model.addObject("employee", employeeService.getEmployeeByUsername(username));
        model.addObject("rentPoints",rentPointService.getAllRentPoints());
        model.addObject("roles", roleService.getAllRoles());
        return model;
    }

    @GetMapping("/add")
    public ModelAndView getAddEmployeeForm() {
        ModelAndView model = new ModelAndView("employeeDetail");
        model.addObject("rentPoints", rentPointService.getAllRentPoints());
        model.addObject("roles",roleService.getAllRoles());
        model.addObject("employee", new Employee());
        return model;
    }

    @PostMapping(value = {"/add", "/{username}"})
    public String saveEmployee(@ModelAttribute Employee employee, @PathVariable(required = false) String username) {
        if (username != null) {
            employee.setUsername(username);
        }

        employeeService.saveEmployee(employee);

        return "redirect:/employee";
    }
}
