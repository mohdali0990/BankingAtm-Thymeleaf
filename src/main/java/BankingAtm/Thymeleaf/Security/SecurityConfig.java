package BankingAtm.Thymeleaf.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

            authenticationManagerBuilder
                    .inMemoryAuthentication()
                    .withUser("bob")
                    .password("john")
                    .authorities("ROLE_USER")
                    .and()
                    .withUser("steve")
                    .password("harvey")
                    .authorities("admin");
        }
    }

