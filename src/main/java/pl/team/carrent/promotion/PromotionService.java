package pl.team.carrent.promotion;

import org.springframework.stereotype.Service;
import pl.team.carrent.promotion.Promotion;
import pl.team.carrent.promotion.PromotionNotExistException;
import pl.team.carrent.promotion.SearchPromotionOption;
import pl.team.carrent.repository.PromotionRepository;

import java.util.*;

/******************************************************
 * @author: Michal S.  
 * [https://github.com/DreamDoer86]
 * @date : 09.11.2019 14:13
 * *
 * @className: PromotionService
 * *
 ******************************************************/

@Service
public class PromotionService {

    private final PromotionRepository promotionRepository;

    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public List<Promotion> getAllPromotions() { return promotionRepository.findAll(); }

    public List<Promotion> searchPromotions(String byWhat, SearchPromotionOption searchPromotionOption) {
        switch(searchPromotionOption) {
            case BY_PROMOTION_NAME:
                return promotionRepository.findByNameContainsIgnoreCase(byWhat);
            case BY_MARK:
                return promotionRepository.findPromotionByCarMark(byWhat);
            case BY_MODEL:
                return promotionRepository.findPromotionByCarModel(byWhat);
            case BY_SEGMENT:
                return promotionRepository.findPromotionByCarSegment(byWhat);
        }
        return Collections.emptyList();
    }

    public Promotion getPromotion(int promotionId){
        return promotionRepository.findById(promotionId)
                .orElseThrow(()-> new PromotionNotExistException("promotionID: " + promotionId));
    }

    public Promotion savePromotion(Promotion promotion) {return promotionRepository.save(promotion);}







}
