package pl.team.carrent.service;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.Test;
import pl.team.carrent.employee.EmployeeNotExistException;
import pl.team.carrent.model.Employee;
import pl.team.carrent.model.RentPoint;
import pl.team.carrent.model.Role;
import pl.team.carrent.repository.EmployeeRepository;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeServiceTest {

    private static String FIND_NONE = "zxcvbnm567ko";
    private static String FIND_FIRSTNAME = "uka";
    private static String FIND_SURNAME = "iup";
    private static String FIND_ROLE1 = "dmin";
    private static String FIND_ROLE2 = "erow";
    private static String FIND_RENTPOINT_NAME = "oz";
    private static String FIND_RENTPOINT_ADDRESS = "bulga";
    private static String FIND_RENTPOINT_POST_CODE = "24";
    private static String FIND_RENTPOINT_CITY = "NAN";
    private static LocalDate FIND_EMPLOYMENT_DATE = LocalDate.of(1999, 9, 1);
    private static LocalDate FIND_EMPLOYMENT_DATE1 = LocalDate.of(1999, 8, 11);
    private static LocalDate FIND_EMPLOYMENT_DATE2 = LocalDate.of(1999, 10, 12);
    private static LocalDate FIND_RELEASE_DATE = LocalDate.of(2009, 8, 11);
    private static LocalDate FIND_RELEASE_DATE1 = LocalDate.of(2004, 8, 11);
    private static LocalDate FIND_RELEASE_DATE2 = LocalDate.of(2019, 8, 11);
    private Role role1 = new Role("admin");
    private Role role2 = new Role("kierownik");
    private LocalDate employmentDate = LocalDate.of(1999, 9, 1);
    private RentPoint rentPoint = new RentPoint("POZ", "Zmigrodzka", "61-244", "Poznan");
    private RentPoint rentPoint2 = new RentPoint("WAW", "Bulgarska", "61-200", "Warszawa");
    private Employee employee1 = new Employee("Lukasz", "Ciupek", rentPoint, "ciupas", employmentDate, role2);
    private Employee employee2 = new Employee("Bartosz", "Ciupek", rentPoint, "badzo", employmentDate, role1);
    private Employee employee3 = new Employee("Maciej", "Kryger", rentPoint2, "snowyman", employmentDate, role1);
    private Employee employee4 = new Employee("Jakub", "Ossowski", rentPoint2, "kuba", employmentDate, role1);

    private EmployeeRepository getEmployeeRepositoryMock() {
        EmployeeRepository mock = mock(EmployeeRepository.class);

        employee2.setReleaseDate(LocalDate.of(2009, 8, 11));

        when(mock.findByFirstnameContainsIgnoreCase(FIND_FIRSTNAME)).thenReturn(Sets.newLinkedHashSet(employee1));
        when(mock.findBySurnameContainsIgnoreCase(FIND_SURNAME)).thenReturn(Sets.newLinkedHashSet(employee1, employee2));
        when(mock.findByRoleAuthorityContainsIgnoreCase(FIND_ROLE1)).thenReturn(Sets.newLinkedHashSet(employee2,employee3));
        when(mock.findByRoleAuthorityContainsIgnoreCase(FIND_ROLE2)).thenReturn(Sets.newLinkedHashSet(employee1));
        when(mock.findByRentPointNameContainsIgnoreCase(FIND_RENTPOINT_NAME)).thenReturn(Sets.newLinkedHashSet(employee1,employee2));
        when(mock.findByRentPointAddressContainsIgnoreCase(FIND_RENTPOINT_ADDRESS)).thenReturn(Sets.newLinkedHashSet(employee3,employee4));
        when(mock.findByRentPointPostCodeContainsIgnoreCase(FIND_RENTPOINT_POST_CODE)).thenReturn(Sets.newLinkedHashSet(employee1,employee2));
        when(mock.findByRentPointCityContainsIgnoreCase(FIND_RENTPOINT_CITY)).thenReturn(Sets.newLinkedHashSet(employee1,employee2));
        when(mock.findByEmploymentDate(FIND_EMPLOYMENT_DATE)).thenReturn(Lists.newArrayList(employee1,employee2,employee3));
        when(mock.findByEmploymentDateAfter(FIND_EMPLOYMENT_DATE1)).thenReturn(Sets.newLinkedHashSet(employee1,employee2,employee3,employee4));
        when(mock.findByEmploymentDateBefore(FIND_EMPLOYMENT_DATE2)).thenReturn(Sets.newLinkedHashSet(employee1,employee2,employee3,employee4));
        when(mock.findByEmploymentDateBetween(FIND_EMPLOYMENT_DATE1,FIND_EMPLOYMENT_DATE2)).thenReturn(Lists.newArrayList(employee1,employee2,employee3));
        when(mock.findByReleaseDate(FIND_RELEASE_DATE)).thenReturn(Lists.newArrayList(employee2));
        when(mock.findByReleaseDateAfter(FIND_RELEASE_DATE1)).thenReturn(Sets.newLinkedHashSet(employee2));
        when(mock.findByReleaseDateBefore(FIND_RELEASE_DATE2)).thenReturn(Sets.newLinkedHashSet(employee2));
        when(mock.findByReleaseDateBetween(FIND_RELEASE_DATE1,FIND_RELEASE_DATE2)).thenReturn(Lists.newArrayList(employee2));
        when(mock.findAll()).thenReturn(Arrays.asList(employee1, employee2, employee3));
        when(mock.findByUsername("ciupas")).thenReturn(Optional.of(employee1));
        when(mock.save(employee4)).thenReturn(employee4);

        return mock;
    }

    private EmployeeService employeeService = new EmployeeService(getEmployeeRepositoryMock());

    @Test
    public void shouldReturnAllEmployees() {
        Set<Employee> actual = employeeService.getAllEmployees();
        assertThat(actual).containsExactlyInAnyOrder(employee1,employee2,employee3);
    }

    @Test
    public void shouldReturnOneEmployeeByUsernameSearch() {
        Employee actual = employeeService.getEmployeeByUsername("ciupas");
        assertThat(actual).isEqualTo(employee1);
    }

    @Test
    public void shouldAddEmployee() {
        Employee actual = employeeService.addEmployee(employee4);
        assertThat(actual).isEqualTo(employee4);
    }

    @Test(expected = EmployeeNotExistException.class)
    public void shouldThrowExceptionByEmployeeUsernameSearch() {
        employeeService.getEmployeeByUsername("test");
    }

    @Test
    public void shouldReturnTwoEmployeesBySurnameSearch() {
        Set<Employee> actual = employeeService.findEmployeesBySurname(FIND_SURNAME);
        assertThat(actual).containsExactly(employee1, employee2);
    }

    @Test
    public void shouldReturnOneEmployeeByFirstameSearch() {
        Set<Employee> actual = employeeService.findEmployeesByFirstname(FIND_FIRSTNAME);
        assertThat(actual).containsExactly(employee1);
    }

    @Test
    public void shouldReturnOneEmployeeByRoleSearch() {
        Set<Employee> actual = employeeService.findEmployeesByRoleName(FIND_ROLE2);
        assertThat(actual).containsExactly(employee1);
    }

    @Test
    public void shouldReturnTwoEmployeesByRoleSearch() {
        Set<Employee> actual = employeeService.findEmployeesByRoleName(FIND_ROLE1);
        assertThat(actual).containsExactly(employee2, employee3);
    }

    @Test
    public void shouldReturnTwoEmployeesByRentpointNameSearch() {
        Set<Employee> actual = employeeService.findEmployeesByRentPointName(FIND_RENTPOINT_NAME);
        assertThat(actual).containsExactly(employee1, employee2);
    }

    @Test
    public void shouldNotFindAnyEmployeesByRentpointNameSearch() {
        Set<Employee> actual = employeeService.findEmployeesByRentPointName(FIND_NONE);
        assertThat(actual).isEmpty();
    }

    @Test
    public void shouldReturnTwoEmployeesByRentpointAddressSearch() {
        Set<Employee> actual = employeeService.findEmployeesByRentPointAddress(FIND_RENTPOINT_ADDRESS);
        assertThat(actual).containsExactly(employee3, employee4);
    }

    @Test
    public void shouldNotFindAnyEmployeesByRentpointAddressSearch() {
        Set<Employee> actual = employeeService.findEmployeesByRentPointAddress(FIND_NONE);
        assertThat(actual).isEmpty();
    }

    @Test
    public void shouldReturnTwoEmployeesByRentpointPostcodeSearch() {
        Set<Employee> actual = employeeService.findEmployeesByRentPointPostCode(FIND_RENTPOINT_POST_CODE);
        assertThat(actual).containsExactly(employee1, employee2);
    }

    @Test
    public void shouldReturnTwoEmployeesByRentpointCitySearch() {
        Set<Employee> actual = employeeService.findEmployeesByRentPointCity(FIND_RENTPOINT_CITY);
        assertThat(actual).containsExactly(employee1, employee2);
    }

    @Test
    public void shouldReturnFourEmployeesByEmploymentDateAfter() {
        Set<Employee> actual = employeeService.findEmployeesByEmploymentDateAfter(FIND_EMPLOYMENT_DATE1);
        assertThat(actual).containsExactly(employee1, employee2, employee3, employee4);
    }

    @Test
    public void shouldReturnFourEmployeesByEmploymentDateBefore() {
        Set<Employee> actual = employeeService.findEmployeesByEmploymentDateBefore(FIND_EMPLOYMENT_DATE2);
        assertThat(actual).containsExactly(employee1, employee2, employee3, employee4);
    }

    @Test
    public void shouldReturnFourEmployeesByReleaseDateAfter() {
        Set<Employee> actual = employeeService.findEmployeesByReleaseDateAfter(FIND_RELEASE_DATE1);
        assertThat(actual).containsExactly(employee2);
    }

    @Test
    public void shouldReturnFourEmployeesByReleaseDateBefore() {
        Set<Employee> actual = employeeService.findEmployeesByReleaseDateBefore(FIND_RELEASE_DATE2);
        assertThat(actual).containsExactly(employee2);
    }
}
