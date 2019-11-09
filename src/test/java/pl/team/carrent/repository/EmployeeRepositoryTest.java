package pl.team.carrent.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.model.Employee;
import pl.team.carrent.model.RentPoint;
import pl.team.carrent.model.Role;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RentPointRepository rentPointRepository;

    @Autowired
    private RoleRepository roleRepository;

    private Employee employee,employee2;

    private void init() {
        Role role = new Role("admin");
        LocalDate employmentDate = LocalDate.of(1999, 9, 1);
        LocalDate releaseDate = LocalDate.of(2015, 11, 28);
        RentPoint rentPoint = new RentPoint("POZ", "Zmigrodzka", "61-244", "Poznan");
        RentPoint rentPoint2 = new RentPoint("POZ", "Bulgarska", "61-244", "Poznan");
        employee = new Employee("Lukasz", "Ciupek", rentPoint, "ciupas", "qwerty", employmentDate, releaseDate, role);
        employee2 = new Employee("Maciej", "Kryger", rentPoint2, "snowyman", "uiop", employmentDate, releaseDate, role);
        roleRepository.save(role);
        rentPointRepository.saveAll(Arrays.asList(rentPoint,rentPoint2));
        employeeRepository.saveAll(Arrays.asList(employee,employee2));
    }

    @Test
    public void shouldFindByFirstname() {
        //given
        init();

        //when
        List<Employee> employeeList = employeeRepository.findByFirstnameContains("Luka");

        //then
        Assert.assertEquals(employeeList.get(0).getFirstname(), "Lukasz");
    }

    @Test
    public void shouldNotFindByFirstname() {
        //given
        init();

        //when
        List<Employee> employeeList = employeeRepository.findByFirstnameContains("Luki");

        //then
        Assert.assertEquals("employeeList size should be 0", 0, employeeList.size());
    }

    @Test
    public void shouldFindBySurname() {
        //given
        init();

        List<Employee> employeeList = employeeRepository.findBySurnameContains("Ciup");

        //then
        Assert.assertEquals(employeeList.get(0).getSurname(), "Ciupek");
    }

    @Test
    public void shouldFindByEmploymentDate() {
        //given
        init();

        List<Employee> employeeList = employeeRepository.findByEmploymentDate(LocalDate.of(1999, 9, 1));

        Assert.assertEquals(employeeList.get(0).getEmploymentDate(), LocalDate.of(1999, 9, 1));
    }

    @Test
    public void shouldNotFindByEmploymentDate() {
        //given
        init();

        List<Employee> employeeList = employeeRepository.findByEmploymentDate(LocalDate.of(1999, 9, 10));

        Assert.assertEquals("employeeList size should be 0", 0, employeeList.size());
    }

    @Test
    public void shouldFindByRoleName() {
        //given
        init();

        List<Employee> employeeList = employeeRepository.findByRoleName("admin");

        Assert.assertEquals(employeeList.get(0).getRole().getAuthority(), "admin");
    }

    @Test
    public void shouldFindByRentPointName() {
        //given
        init();

        List<Employee> employeeList = employeeRepository.findByRentPointName("POZ");

        Assert.assertEquals(employeeList.get(0).getRentPoint().getName(), "POZ");
    }

    @Test
    public void shouldFindByRentPointAddress() {
        //given
        init();

        List<Employee> employeeList = employeeRepository.findByRentPointAddress("Zmigrodzka");

        Assert.assertEquals(employeeList.get(0).getRentPoint().getAddress(), "Zmigrodzka");
    }

    @Test
    public void shouldFindByRentPointPostCode() {
        //given
        init();

        List<Employee> employeeList = employeeRepository.findByRentPointPostCode("61-244");

        Assert.assertEquals(employeeList.get(0).getRentPoint().getPostCode(), "61-244");
    }

    @Test
    public void shouldFindByRentPointCity() {
        //given
        init();

        List<Employee> employeeList = employeeRepository.findByRentPointCity("Poznan");

        Assert.assertEquals(employeeList.get(0).getRentPoint().getCity(), "Poznan");
        Assert.assertEquals(employeeList.get(1).getFirstname(), "Maciej");
    }



}
