package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.team.carrent.model.Employee;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: Łukasz C.  [https://github.com/lukasz-ciupek]
 * @date : 2019-10-27 14:16
 * *
 * @className: EmployeeRepository
 * *
 * *
 ******************************************************/
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByFirstnameContainsIgnoreCase(String firstname);
    List<Employee> findBySurnameContainsIgnoreCase(String surname);
    List<Employee> findByRoleAuthorityContainsIgnoreCase(String name);
    List<Employee> findByRentPointNameContainsIgnoreCase(String name);
    List<Employee> findByRentPointAddressContainsIgnoreCase(String address);
    List<Employee> findByRentPointPostCodeContainsIgnoreCase(String postCode);
    List<Employee> findByRentPointCityContainsIgnoreCase(String city);
    List<Employee> findByEmploymentDate(LocalDate employmentDate);
    List<Employee> findByEmploymentDateAfter(LocalDate employmentDate);
    List<Employee> findByEmploymentDateBefore(LocalDate employmentDate);
    List<Employee> findByEmploymentDateBetween(LocalDate employmentDate1, LocalDate employmentDate2);
    List<Employee> findByReleaseDate(LocalDate releaseDate);
    List<Employee> findByReleaseDateAfter(LocalDate releaseDate);
    List<Employee> findByReleaseDateBefore(LocalDate releaseDatee);
    List<Employee> findByReleaseDateBetween(LocalDate releaseDate1, LocalDate releaseDate2);

}
