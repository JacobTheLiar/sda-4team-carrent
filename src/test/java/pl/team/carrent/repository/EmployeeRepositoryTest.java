package pl.team.carrent.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.model.Employee;
import pl.team.carrent.model.RentPoint;
import pl.team.carrent.model.Role;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Transactional
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RentPointRepository rentPointRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void setUp() throws Exception {
        Role role = new Role("admin");
        LocalDate employmentDate = LocalDate.of(1999, 9, 1);
        RentPoint rentPoint = new RentPoint("POZ", "Zmigrodzka", "61-244", "Poznan");
        RentPoint rentPoint2 = new RentPoint("POZ", "Bulgarska", "61-244", "Poznan");
        Employee employee = new Employee("Lukasz", "Ciupek", rentPoint, "ciupas", employmentDate, role);
        Employee employee2 = new Employee("Maciej", "Kryger", rentPoint2, "snowyman", employmentDate, role);
        roleRepository.save(role);
        employee.setReleaseDate(LocalDate.of(1999, 9, 22));
        rentPointRepository.saveAll(Arrays.asList(rentPoint,rentPoint2));
        employeeRepository.saveAll(Arrays.asList(employee, employee2));
    }

    @Test
    public void shouldFindByFirstname() {
        //when
        Set<Employee> employeeList = employeeRepository.findByFirstnameContainsIgnoreCase("luka");
        //then
        Assert.assertEquals(1, employeeList.size());
    }

    @Test
    public void shouldNotFindByFirstname() {
        //when
        Set<Employee> employeeList = employeeRepository.findByFirstnameContainsIgnoreCase("Luki");
        //then
        Assert.assertEquals(0, employeeList.size());
    }

    @Test
    public void shouldFindBySurname() {
        //when
        Set<Employee> employeeList = employeeRepository.findBySurnameContainsIgnoreCase("ciup");
        //then
        Assert.assertEquals(1, employeeList.size());
    }

    @Test
    public void shouldFindByEmploymentDate() {
        //when
        List<Employee> employeeList = employeeRepository.findByEmploymentDate(LocalDate.of(1999, 9, 1));
        //then
        Assert.assertEquals(employeeList.get(0).getEmploymentDate(), LocalDate.of(1999, 9, 1));
    }

    @Test
    public void shouldNotFindByEmploymentDate() {
        //when
        List<Employee> employeeList = employeeRepository.findByEmploymentDate(LocalDate.of(1999, 9, 10));
        //then
        Assert.assertEquals("employeeList size should be 0", 0, employeeList.size());
    }

    @Test
    public void shouldFindByRoleName() {
        //when
        Set<Employee> employeeList = employeeRepository.findByRoleAuthorityContainsIgnoreCase("ad");
        //then
        Assert.assertEquals(2, employeeList.size());
    }

    @Test
    public void shouldFindByRentPointName() {
        //when
        Set<Employee> employeeList = employeeRepository.findByRentPointNameContainsIgnoreCase("pOz");
        //then
        Assert.assertEquals(2, employeeList.size());
    }

    @Test
    public void shouldFindByRentPointAddress() {
        //when
        Set<Employee> employeeList = employeeRepository.findByRentPointAddressContainsIgnoreCase("zmigRodz");
        //then
        Assert.assertEquals(1, employeeList.size());
    }

    @Test
    public void shouldFindByRentPointPostCode() {
        //when
        Set<Employee> employeeList = employeeRepository.findByRentPointPostCodeContainsIgnoreCase("61-2");
        //then
        Assert.assertEquals(2, employeeList.size());
    }

    @Test
    public void shouldFindByRentPointCity() {
        //when
        Set<Employee> employeeList = employeeRepository.findByRentPointCityContainsIgnoreCase("Poznan");
        //then
        Assert.assertEquals(2, employeeList.size());
    }

    @Test
    public void shouldFindByEmploymentDateAfter() {
        //when
        Set<Employee> employeeList = employeeRepository.findByEmploymentDateAfter(LocalDate.of(1999, 8, 1));
        //then
        Assert.assertEquals(2, employeeList.size());
    }

    @Test
    public void shouldFindByEmploymentDateBefore() {
        //when
        Set<Employee> employeeList = employeeRepository.findByEmploymentDateBefore(LocalDate.of(1999, 10, 1));
        //then
        Assert.assertEquals(2, employeeList.size());
    }

    @Test
    public void shouldFindByEmploymentDateBetween() {
        //when
        List<Employee> employeeList = employeeRepository.findByEmploymentDateBetween(LocalDate.of(1999, 8, 1),LocalDate.of(1999,10, 1));
        //then
        Assert.assertEquals(employeeList.get(0).getFirstname(), "Lukasz");
        Assert.assertEquals(employeeList.get(1).getFirstname(), "Maciej");
    }

    @Test
    public void shouldFindByReleaseDateBetween() {
        //when
        List<Employee> employeeList = employeeRepository.findByReleaseDateBetween(LocalDate.of(1999, 8, 1),LocalDate.of(1999,10, 1));
        //then
        Assert.assertNotEquals("employeeList size should not be 0", 0, employeeList.size());
        Assert.assertEquals(employeeList.get(0).getFirstname(), "Lukasz");
    }

    @Test
    public void shouldNotFindByReleaseDateBetween() {
        //when
        List<Employee> employeeList = employeeRepository.findByReleaseDateBetween(LocalDate.of(1998, 8, 1),LocalDate.of(1998,10, 1));
        //then
        Assert.assertEquals("employeeList size should be 0", 0, employeeList.size());
    }
}
