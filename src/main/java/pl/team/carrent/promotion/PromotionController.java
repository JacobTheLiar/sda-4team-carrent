package pl.team.carrent.promotion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.team.carrent.model.Promotion;
import pl.team.carrent.service.PromotionService;

import javax.jws.WebParam;


/******************************************************
 * @author: Michal S.  
 * [https://github.com/DreamDoer86]
 * @date : 16.11.2019 14:43
 * *
 * @className: PromotionController
 * *
 ******************************************************/
@Controller
@RequestMapping("/promotion")
public class PromotionController {

    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public ModelAndView getPromotionList(@RequestParam(required = false) String searchWhat
            ,@RequestParam (required = false) SearchPromotionOption searchBy) {
        ModelAndView model = new ModelAndView("promotionList");
        if (searchWhat == null) {
            model.addObject("promotions", promotionService.getAllPromotions());
        } else {
            model.addObject("promotions", promotionService.searchPromotions(searchWhat, searchBy));
        }
        model.addObject("options", SearchPromotionOption.values());
        return model;
    }

    @GetMapping("/{id}")
    public ModelAndView getPromotionDetails(@PathVariable int id) {
        ModelAndView model = new ModelAndView("promotionDetail");
        model.addObject("promotion", promotionService.getPromotion(id));
        return model;
    }

    @GetMapping("/add")
    public ModelAndView getAddPromotionForm() {
        ModelAndView model = new ModelAndView("promotionDetail");
        model.addObject("promotion", new Promotion());
        return model;
    }

    @PostMapping(value = { "/add", "/{id}" })
    public String savePromotion(@ModelAttribute Promotion promotion, @PathVariable(required = false) Integer id) {
        if (id != null) {
            promotion.setId(id);
        }
        promotionService.savePromotion(promotion);
        return "redirect:/promotion";
    }
}
