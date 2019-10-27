package pl.team.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.team.carrent.model.Employee;
import pl.team.carrent.model.RentPoint;
import pl.team.carrent.model.Role;

import java.time.LocalDate;
import java.util.Set;

/**
 * @author: Łukasz C.  [https://github.com/lukasz-ciupek]
 * @date : 2019-10-27 14:16
 * *
 * @className: EmployeeRepository
 * *
 * *
 ******************************************************/
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Set<Employee> findByFirstname(String firstname);
    Set<Employee> findBySurname(String surname);
    Set<Employee> findByEmploymentDate(LocalDate employmentDate);
    Set<Employee> findByReleaseDate(LocalDate releaseDate);
    @Query("select e from Employee e where e.role.authority = :name")
    Set<Employee> findByRoleName(String name);
    @Query("select e from Employee e where e.rentPoint.name = :name")
    Set<Employee> findByRentPointName(String name);

}
