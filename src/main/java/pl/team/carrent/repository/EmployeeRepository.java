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

    List<Employee> findByFirstnameContains(String firstname);
    List<Employee> findBySurnameContains(String surname);
    List<Employee> findByEmploymentDate(LocalDate employmentDate);
    List<Employee> findByReleaseDate(LocalDate releaseDate);
    @Query("select e from Employee e where e.role.authority = :name")
    List<Employee> findByRoleName(String name);
    @Query("select e from Employee e where e.rentPoint.name = :name")
    List<Employee> findByRentPointName(String name);
    @Query("select e from Employee e where e.rentPoint.address = :address")
    List<Employee> findByRentPointAddress(String address);
    @Query("select e from Employee e where e.rentPoint.postCode = :postCode")
    List<Employee> findByRentPointPostCode(String postCode);
    @Query("select e from Employee e where e.rentPoint.city = :city")
    List<Employee> findByRentPointCity(String city);
}
