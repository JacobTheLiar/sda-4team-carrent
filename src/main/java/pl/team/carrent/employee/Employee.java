package pl.team.carrent.employee;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.team.carrent.rent_point.RentPoint;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Entity
public class Employee implements UserDetails {

    private String firstname;
    private String surname;

    @ManyToOne(targetEntity = RentPoint.class)
    private RentPoint rentPoint;

    @Id
    @NotNull
    private String username;

    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate employmentDate;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @ManyToOne(targetEntity = Role.class)
    private Role role;

    public Employee() {
    }

    public Employee(String firstname, String surname, RentPoint rentPoint, String username, LocalDate employmentDate, Role role) {
        this.firstname = firstname;
        this.surname = surname;
        this.rentPoint = rentPoint;
        this.username = username;
        this.employmentDate = employmentDate;
        this.role = role;
    }

    public Employee(String firstname, String surname, RentPoint rentPoint, String username, String password, LocalDate employmentDate, LocalDate releaseDate, Role role) {
        this.firstname = firstname;
        this.surname = surname;
        this.rentPoint = rentPoint;
        this.username = username;
        this.password = password;
        this.employmentDate = employmentDate;
        this.releaseDate = releaseDate;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullUserName(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.firstname).append(" ").append(this.surname).append(" [").append(this.username).append("]");
        return sb.toString();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public RentPoint getRentPoint() {
        return rentPoint;
    }

    public void setRentPoint(RentPoint rentPoint) {
        this.rentPoint = rentPoint;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(username, employee.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", rentPoint=" + rentPoint +
                ", username='" + username + '\'' +
                ", employmentDate=" + employmentDate +
                ", releaseDate=" + releaseDate +
                ", role=" + role +
                '}';
    }
}
