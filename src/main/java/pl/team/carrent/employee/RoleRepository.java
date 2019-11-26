package pl.team.carrent.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.team.carrent.employee.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findByAuthority(String authority);
}
