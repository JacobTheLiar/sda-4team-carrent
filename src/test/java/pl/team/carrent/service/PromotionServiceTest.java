package pl.team.carrent.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.model.Car;
import pl.team.carrent.model.CarModel;
import pl.team.carrent.model.Promotion;
import pl.team.carrent.promotion.PromotionNotExistException;
import pl.team.carrent.promotion.SearchPromotionOption;
import pl.team.carrent.repository.CarModelRepository;
import pl.team.carrent.repository.CarRepository;
import pl.team.carrent.repository.ClientRepository;
import pl.team.carrent.repository.PromotionRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static pl.team.carrent.promotion.SearchPromotionOption.*;

/******************************************************
 * @author: Michal S.  
 * [https://github.com/DreamDoer86]
 * @date : 10.11.2019 10:01
 * *
 * @className: PromotionServiceTest
 * *
 ******************************************************/

public class PromotionServiceTest {

    private static String FIND_BY_NAME = "Opel 30%";
    private static String FIND_BY_MARK = "Opel";
    private static String FIND_BY_MODEL = "Astra";
    private static String FIND_BY_SEGMENT = "B";
    private static String FIND_EMPTY = "";
    private static int DISCOUNT = 30;

    private CarModel opelCorsa2001 = new CarModel("Opel", "Corsa",
            "B","null", 2001, 30000);
    private CarModel renualtClio2019 = new CarModel("Reanualt", "Clio",
            "B","null",2019, 30000);
    private CarModel opelAstra2005 = new CarModel("Opel", "Astra",
            "C","null", 2010, 30000);

    private Car newCar1 = new Car(opelCorsa2001,LocalDate.of(2001,6,22),
            "ZDR55555","WAUZZZ8E343453","Red",20);
    private Car newCar2 = new Car(renualtClio2019,LocalDate.of(2005,11,22),
            "ZDR55654","WAUZZZ8E356466","Blue",20);
    private Car newCar3 = new Car(opelAstra2005,LocalDate.of(2005,11,22),
            "ZDR20250","WAUZZZ8E3466","Blue",20);

    private Promotion promoOpel30 = new Promotion("Opel 30%", 30,
            LocalDate.now(), LocalDate.now().plusDays(30),
            Arrays.asList(newCar1,newCar3), null );
    private Promotion promoSegmentB20 = new Promotion("Segment B 20%", 30,
            LocalDate.now(), LocalDate.now().plusDays(30),
            Arrays.asList(newCar1, newCar2), null);
    private Promotion promoAstra25 = new Promotion("Astra 25%", 30,
            LocalDate.now(), null,
            Arrays.asList(newCar3), null);
    private Promotion newPromo = new Promotion("Astra 35", 35,
            LocalDate.now(), null,
            Arrays.asList(newCar3), null);


    private PromotionRepository getPromotionRepositoryMock(){
        PromotionRepository mock = mock(PromotionRepository.class);

        when(mock.findByNameContainsIgnoreCase(FIND_BY_NAME))
                .thenReturn(Arrays.asList(promoOpel30));
        when(mock.findPromotionByCarMark(FIND_BY_MARK))
                .thenReturn(Arrays.asList(promoOpel30,promoAstra25));
        when(mock.findPromotionByCarModel(FIND_BY_MODEL))
                .thenReturn(Arrays.asList(promoAstra25));
        when(mock.findPromotionByCarSegment(FIND_BY_SEGMENT))
                .thenReturn(Arrays.asList(promoOpel30,promoSegmentB20));
        when(mock.findAll())
                .thenReturn(Arrays.asList(promoOpel30,promoSegmentB20, promoAstra25));
        when(mock.findById(1))
                .thenReturn(Optional.of(promoOpel30));
        when(mock.findByPromoEndIsNull())
                .thenReturn(Arrays.asList(promoAstra25));
        when(mock.findByDiscountPercentage(DISCOUNT))
                .thenReturn(Arrays.asList(promoOpel30));
        when(mock.save(newPromo))
                .thenReturn(newPromo);

        return mock;
    }

    private PromotionService promotionService = new PromotionService(getPromotionRepositoryMock());

    @Test
    public void shouldReturnAllPromotions() {
        List<Promotion> actual = promotionService.getAllPromotions();
        assertThat(actual).containsExactlyInAnyOrder(promoOpel30, promoSegmentB20, promoAstra25);
    }

    @Test
    public void shouldReturnOnePromotionByNameSearch(){
        List<Promotion> actual = promotionService.searchPromotions(FIND_BY_NAME, BY_PROMOTION_NAME);
        assertThat(actual).containsExactlyInAnyOrder(promoOpel30);
    }

    @Test
    public void shouldReturnTwoPromotionsByMarkSearch(){
        List<Promotion> actual = promotionService.searchPromotions(FIND_BY_MARK, BY_MARK);
        assertThat(actual).containsExactlyInAnyOrder(promoOpel30, promoAstra25);
    }

    @Test
    public void shouldReturnOnePromotionByModelSearch(){
        List<Promotion> actual = promotionService.searchPromotions(FIND_BY_MODEL,BY_MODEL);
        assertThat(actual).containsExactlyInAnyOrder(promoAstra25);
    }

    @Test
    public void shouldReturnTwoPromotionBySegmentSearch(){
        List<Promotion> actual = promotionService.searchPromotions(FIND_BY_SEGMENT, BY_SEGMENT);
        assertThat(actual).containsExactlyInAnyOrder(promoOpel30, promoSegmentB20);
    }

    @Test
    public void shouldReturnPromotionByIdSearch(){
        Promotion actual = promotionService.getPromotion(1);
        assertThat(actual).isEqualTo(promoOpel30);
    }

    @Test(expected = PromotionNotExistException.class)
    public void shouldGiveExceptionByIdSearch(){
        promotionService.getPromotion(7);
    }

    @Test
    public void shouldNotFindAnyPromotionByNameSearch(){
        List<Promotion> actual = promotionService.searchPromotions(FIND_EMPTY, BY_PROMOTION_NAME);
        assertThat(actual).isEmpty();
    }

    @Test
    public void shouldNotFindAnyPromotionByMarkSearch(){
        List<Promotion> actual = promotionService.searchPromotions(FIND_EMPTY, BY_MARK);
        assertThat(actual).isEmpty();
    }

    @Test
    public void shouldNotFindAnyPromotionByModelSearch(){
        List<Promotion> actual = promotionService.searchPromotions(FIND_EMPTY, BY_MODEL);
        assertThat(actual).isEmpty();
    }

    @Test
    public void shouldNotFindAnyPromotionBySegmentSearch(){
        List<Promotion> actual = promotionService.searchPromotions(FIND_EMPTY, BY_SEGMENT);
        assertThat(actual).isEmpty();
    }

    @Test
    public void shouldAddPromotion(){
        Promotion actual = promotionService.savePromotion(newPromo);
        assertThat(actual).isEqualTo(newPromo);
    }

}
