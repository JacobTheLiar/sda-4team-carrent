package pl.team.carrent.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.employee.Role;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void shouldFindByAuthority()
    {
        Role role = new Role("admin");

        roleRepository.save(role);

        List<Role> listRole = roleRepository.findByAuthority("admin");

        assertThat(listRole).containsExactlyInAnyOrder(role);

    }

}
