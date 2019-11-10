package pl.team.carrent.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmployee")
    @SequenceGenerator(name = "seqEmployee", sequenceName = "seq_Employee", allocationSize = 1)
    private int id;
    private String firstname;
    private String surname;
    @ManyToOne(targetEntity = RentPoint.class)
    private RentPoint rentPoint;
    private String username;
    private String password;
    private LocalDate employmentDate;
    @Nullable
    private LocalDate releaseDate;

    @ManyToOne(targetEntity = Role.class)
    private Role role;

    public Employee(String firstname, String surname, RentPoint rentPoint, String username, LocalDate employmentDate, Role role) {
        this.firstname = firstname;
        this.surname = surname;
        this.rentPoint = rentPoint;
        this.username = username;
        this.employmentDate = employmentDate;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setUsername(String username) {
        this.username = username;
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
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", rentPoint=" + rentPoint +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employmentDate=" + employmentDate +
                ", releasetDate=" + releaseDate +
                ", role=" + role +
                '}';
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

    public Employee() {
    }
}
