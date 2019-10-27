package pl.team.carrent.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmployee")
    @SequenceGenerator(name = "seqEmployee", sequenceName = "seq_Employee")
    private Long id;
    private String firstname;
    private String surname;
    private Integer rentPointId;
    private String username;
    private String password;
    private LocalDate employmentDate;
    private LocalDate releaseDate;

    @ManyToOne(targetEntity = Role.class)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getRentPointId() {
        return rentPointId;
    }

    public void setRentPointId(Integer rentPointId) {
        this.rentPointId = rentPointId;
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
                ", rentPointId=" + rentPointId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employmentDate=" + employmentDate +
                ", releasetDate=" + releaseDate +
                ", role=" + role +
                '}';
    }

    public Employee(String firstname, String surname, Integer rentPointId, String username, String password, LocalDate employmentDate, LocalDate releaseDate, Role role) {
        this.firstname = firstname;
        this.surname = surname;
        this.rentPointId = rentPointId;
        this.username = username;
        this.password = password;
        this.employmentDate = employmentDate;
        this.releaseDate = releaseDate;
        this.role = role;
    }
}