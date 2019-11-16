package pl.team.carrent.client;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.team.carrent.service.ClientService;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-10 15:13
 * *
 * @className: ClientController
 * *
 * *
 ******************************************************/
@Controller
@RequestMapping("/client")
public class ClientController{
    
    
    private final ClientService clientService;
    
    
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }
    
    
    @GetMapping
    public ModelAndView getClientList(@RequestParam(required = false) String searchWhat, @RequestParam(required = false) SearchClientOption searchBy){
        ModelAndView model = new ModelAndView("clientList");
        if (searchWhat == null) {
            model.addObject("clients", clientService.getAllClients());
        } else {
            model.addObject("clients", clientService.searchClients(searchWhat, searchBy));
        }
        model.addObject("options", SearchClientOption.values());
        return model;
    }
    
    
    @GetMapping("/{id}")
    public ModelAndView getClientDetails(@PathVariable int id){
        ModelAndView model = new ModelAndView("clientDetail");
        model.addObject("client", clientService.getClient(id));
        return model;
    }
    
    
    @GetMapping("/add")
    public  ModelAndView geaAddClientForm(){
        ModelAndView model = new ModelAndView("clientDetail");
        return model;
    }
    
}
