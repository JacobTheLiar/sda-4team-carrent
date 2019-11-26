package pl.team.carrent.rent_point;


import org.springframework.stereotype.Service;
import pl.team.carrent.repository.RentPointRepository;

import java.util.HashSet;
import java.util.Set;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-10 11:12
 * *
 * @className: RentPointService
 * *
 * *
 ******************************************************/
@Service
public class RentPointService {

    private final RentPointRepository rentPointRepository;


    public RentPointService(RentPointRepository rentPointRepository) {
        this.rentPointRepository = rentPointRepository;
    }


    public Set<RentPoint> getAllRentPoints() {
        return new HashSet<>(rentPointRepository.findAll());
    }


    public RentPoint getRentPointById(int rentPointId) {

        return rentPointRepository.findById(rentPointId)
                .orElseThrow(() -> new RentPointNotExistException("rentPointId:" + rentPointId));
    }


    public RentPoint saveOrUpdateRentPoint(RentPoint rentPoint) {
        return rentPointRepository.save(rentPoint);
    }
}
