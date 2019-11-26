package pl.team.carrent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import pl.team.carrent.employee.EmployeeService;


/**
 * @author: Maciej Kryger  [https://github.com/maciejkryger]
 * @date : 23.11.2019 10:41
 * *
 * @className: SecurityConfig
 * *
 * *
 ******************************************************/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final EmployeeService employeeService;

    public SecurityConfig(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/").hasAnyAuthority("ADMIN", "SUPERUSER", "USER")
                .antMatchers("/client").hasAnyAuthority("ADMIN", "SUPERUSER", "USER")
                .antMatchers("/rent").hasAnyAuthority("ADMIN", "SUPERUSER", "USER")
                .antMatchers("/rent/history").hasAnyAuthority("ADMIN", "SUPERUSER", "USER")
                .antMatchers("/invoice").hasAnyAuthority("ADMIN", "SUPERUSER", "USER")
                .antMatchers("/car").hasAnyAuthority("ADMIN", "SUPERUSER")
                .antMatchers("/car/model").hasAnyAuthority("ADMIN", "SUPERUSER")
                .antMatchers("/promotion").hasAnyAuthority("ADMIN", "SUPERUSER")
                .antMatchers("/employee").hasAuthority("ADMIN")
                .antMatchers("/rentPoint").hasAuthority("ADMIN")
                .antMatchers("/**").authenticated()
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(successHandler())
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied")
                .and()
                .headers().frameOptions().disable()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(employeeService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Bean
    AuthenticationSuccessHandler successHandler() {
        return new SavedRequestAwareAuthenticationSuccessHandler();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
