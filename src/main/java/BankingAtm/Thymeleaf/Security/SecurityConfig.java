package BankingAtm.Thymeleaf.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//
//            authenticationManagerBuilder
//                    .inMemoryAuthentication()
//                    .withUser("bob")
//                    .password("john")
//                    .authorities("ROLE_USER")
//                    .and()
//                    .withUser("steve")
//                    .password("harvey")
//                    .authorities("admin");
//        }
//    }


    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        List<UserDetails>users = new ArrayList<>();
        users.add(User.withDefaultPasswordEncoder().username("john").password("cena").roles("USER").build());
        return new InMemoryUserDetailsManager(users);
    }
}