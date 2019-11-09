package pl.team.carrent.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.model.CarModel;
import pl.team.carrent.model.Promotion;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/******************************************************
 * @author: Michal S.  
 * [https://github.com/DreamDoer86]
 * @date : 09.11.2019 11:07
 * *
 * @className: PromotionRepositoryTest
 * *
 ******************************************************/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PromotionRepositoryTest {

    @Autowired
    private CarModelRepository carModelRepository;

    @Autowired
    private PromotionRepository subject;

    @Test
    public void shouldBeAddedPromotionByCarModel() {
        //given
        CarModel opelCorsa2001 = new CarModel("Opel", "Corsa", 2001, 30000);
        CarModel renualtClio2019 = new CarModel("Reanualt", "Clio", 2019, 30000);
        carModelRepository.saveAll(Arrays.asList(opelCorsa2001, renualtClio2019));
        Promotion addedPromotion = new Promotion("Male 30%", 30,
                LocalDate.now(), LocalDate.now().plusDays(30),
                null, Arrays.asList(opelCorsa2001, renualtClio2019), null);
        subject.save(addedPromotion);

        //when
        List<Promotion> byCarModels = subject.findByCarModels(opelCorsa2001);

        //then
        Assert.assertEquals("Male 30%", byCarModels.get(0).getName());
    }

}
