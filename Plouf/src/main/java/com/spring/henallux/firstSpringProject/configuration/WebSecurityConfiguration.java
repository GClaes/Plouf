package com.spring.henallux.firstSpringProject.configuration;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import static org.hibernate.criterion.Restrictions.and;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final String LOGIN_REQUEST = "/connection";
    private static final String AUTHORIZED_REQUESTS_AUTHENTIFIED = "/panier/commander";

    private final UserDataAccess userDataAccess;

    @Autowired
    public WebSecurityConfiguration(UserDataAccess userDataAccess) {
        this.userDataAccess = userDataAccess;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers(AUTHORIZED_REQUESTS_AUTHENTIFIED).authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
                .loginPage(LOGIN_REQUEST)
                .defaultSuccessUrl("/welcome")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/welcome")
                .permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDataAccess).passwordEncoder(new BCryptPasswordEncoder());
    }
}
