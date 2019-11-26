package pl.team.carrent.employee;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return employeeRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("Could not find user with username: " + s));
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void removeEmployee(Employee employee, LocalDate localDate) {
        employee.setReleaseDate(localDate);
    }

    public Set<Employee> getAllEmployees() {
        return new HashSet<>(employeeRepository.findAll());
    }

    public Employee getEmployeeByUsername(String username) {
        return employeeRepository.findByUsername(username)
                .orElseThrow(() -> new EmployeeNotExistException("username: " + username));
    }

    public Set<Employee> getActiveEmployees() {
        return employeeRepository.findByReleaseDateIsNull();
    }

    public Set<Employee> findEmployeesByFirstname (String firstname) {
        return employeeRepository.findByFirstnameContainsIgnoreCase(firstname);
    }

    public Set<Employee> findEmployeesBySurname (String surname) {
        return employeeRepository.findBySurnameContainsIgnoreCase(surname);
    }

    public Set<Employee> findEmployeesByRoleName (String name) {
        return employeeRepository.findByRoleAuthorityContainsIgnoreCase(name);
    }

    public Set<Employee> findEmployeesByRentPointName (String name) {
        return employeeRepository.findByRentPointNameContainsIgnoreCase(name);
    }

    public Set<Employee> findEmployeesByRentPointAddress (String address) {
        return employeeRepository.findByRentPointAddressContainsIgnoreCase(address);
    }

    public Set<Employee> findEmployeesByRentPointPostCode (String postCode) {
        return employeeRepository.findByRentPointPostCodeContainsIgnoreCase(postCode);
    }

    public Set<Employee>  findEmployeesByRentPointCity (String city) {
        return employeeRepository.findByRentPointCityContainsIgnoreCase(city);
    }

    public Set<Employee> findEmployeesByEmploymentDateAfter (LocalDate date) {
        return employeeRepository.findByEmploymentDateAfter(date);
    }

    public Set<Employee> findEmployeesByEmploymentDateBefore (LocalDate date) {
        return employeeRepository.findByEmploymentDateBefore(date);
    }

    public Set<Employee> findEmployeesByReleaseDateAfter (LocalDate date) {
        return employeeRepository.findByReleaseDateAfter(date);
    }

    public Set<Employee> findEmployeesByReleaseDateBefore (LocalDate date) {
        return employeeRepository.findByReleaseDateBefore(date);
    }
}