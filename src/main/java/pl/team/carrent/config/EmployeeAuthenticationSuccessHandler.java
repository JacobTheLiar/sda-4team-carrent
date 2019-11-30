package pl.team.carrent.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pl.team.carrent.employee.Employee;
import pl.team.carrent.employee.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 29.11.2019 13:15
 * *
 * @className: AuthenticationSuccessHandler
 * *
 * *
 ******************************************************/
@Component
public class EmployeeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final EmployeeService employeeService;
    private final RedirectStrategy redirectStrategy;

    public EmployeeAuthenticationSuccessHandler(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.redirectStrategy = new DefaultRedirectStrategy();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String userName = authentication.getName();
        Employee employee = employeeService.getEmployeeByUsername(userName);

        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("employee", employee);

        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/");
    }
}
