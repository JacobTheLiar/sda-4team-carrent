package pl.team.carrent.rent_point;


import org.junit.Test;
import pl.team.carrent.repository.RentPointRepository;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-10 11:22
 * *
 * @className: RentPointServiceTest
 * *
 * *
 ******************************************************/
public class RentPointServiceTest{
    
    private RentPoint rentPoint1 = new RentPoint("HQ", "City Center 1", "00-001", "MasterCity");
    private RentPoint rentPoint2 = new RentPoint("Secondary", "Moby 3", "00-003", "SlaveCity");
    private RentPoint rentPoint3 = new RentPoint("Third", "Moby 33", "00-003", "SlaveCity");
    
    private RentPointRepository getRentRepositoryMock(){
        RentPointRepository mock = mock(RentPointRepository.class);
    
        when(mock.save(rentPoint1)).thenReturn(rentPoint1);
        when(mock.save(rentPoint2)).thenReturn(rentPoint2);
        when(mock.save(rentPoint3)).thenReturn(rentPoint3);
        when(mock.findAll()).thenReturn(Arrays.asList(rentPoint1, rentPoint2));
        when(mock.findById(1)).thenReturn(Optional.of(rentPoint1));
        
        return mock;
    }
    
    private RentPointService rentPointService = new RentPointService(getRentRepositoryMock());
    
    
    @Test
    public void shouldReturnAllRentPoints(){
        Set<RentPoint> actual = rentPointService.getAllRentPoints();
        assertThat(actual).containsExactlyInAnyOrder(rentPoint1, rentPoint2);
    }
    
    
    @Test
    public void shouldAddRentPoint(){
        RentPoint actual = rentPointService.saveOrUpdateRentPoint(rentPoint3);
        assertThat(actual).isEqualTo(rentPoint3);
    }
    
    
    @Test
    public void shouldUpdateRentPoint(){
        rentPoint3.setCity("abra cadabra");
        RentPoint actual = rentPointService.saveOrUpdateRentPoint(rentPoint3);
        assertThat(actual).isEqualTo(rentPoint3);
    }
    
    
    @Test
    public void shouldFindRentPoint(){
        RentPoint actual = rentPointService.getRentPointById(1);
        assertThat(actual).isEqualTo(rentPoint1);
    }
    
    
    @Test(expected = RentPointNotExistException.class)
    public void shouldRaiseExceptionByIdSearch(){
        rentPointService.getRentPointById(10);
    }
}