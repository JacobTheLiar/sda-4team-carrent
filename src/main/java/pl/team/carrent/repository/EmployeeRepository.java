package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    //@Query("select e from Employee e where e.role.authority = :name")
    List<Employee> findByRoleAuthorityContainsIgnoreCase(String name);
    //@Query("select e from Employee e where e.rentPoint.name = :name")
    List<Employee> findByRentPointNameContainsIgnoreCase(String name);
    //@Query("select e from Employee e where e.rentPoint.address = :address")
    List<Employee> findByRentPointAddressContainsIgnoreCase(String address);
    //@Query("select e from Employee e where e.rentPoint.postCode = :postCode")
    List<Employee> findByRentPointPostCodeContainsIgnoreCase(String postCode);
    //@Query("select e from Employee e where e.rentPoint.city = :city")
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
