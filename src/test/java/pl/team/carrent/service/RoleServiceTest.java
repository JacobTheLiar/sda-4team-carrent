package pl.team.carrent.service;

import org.junit.Test;
import pl.team.carrent.employee.Role;
import pl.team.carrent.employee.RoleRepository;
import pl.team.carrent.employee.RoleService;
import java.util.Arrays;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RoleServiceTest {

    private Role role1 = new Role("admin");
    private Role role2 = new Role("kierownik");

    private RoleRepository getRoleRepositoryMock() {
        RoleRepository mock = mock(RoleRepository.class);

        when(mock.findAll()).thenReturn(Arrays.asList(role1,role2));

        return mock;
    }

    private RoleService roleService = new RoleService(getRoleRepositoryMock());

    @Test
    public void shouldReturnAllRoles() {
        Set<Role> actual = roleService.getAllRoles();
        assertThat(actual).containsExactlyInAnyOrder(role1,role2);
    }

}
