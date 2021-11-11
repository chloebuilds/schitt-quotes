package com.practice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // ! This class will be used to configure our application with security features.
    @EnableWebSecurity // ! Spring Security annotation. Allows spring to configure the security for our app.
    @ReguiredArgsConstructor //
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
        private final UserDetailsService userDetailsService;
        private final BCryptPasswordEncoder bCryptPasswordEncoder;

// ! WebSecurityConfigureAdapter: provides a set of methods we can use to override
// ! the behaviour of Spring Security.

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
            //super.configure(auth);
        }

        // ! With this method, we can configure which routes are authorized, which security
        // ! method we use.
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();
            http.authorizeRequests().anyRequest.permitAll();
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http.addFilter(null);
//            http.authorizeRequests().antMatchers("/register").permitAll();
//            http // ! Provides a DSL (Domain specific language) to describe your security.
//                    .authorizeRequests() // ! Call this to start 'describing' which routes are secured vs. which are not secured.
//                    // ! antMatchers allows us to match specific routes to be secured.
//                    .antMatchers("/quotes")
//                    .authenticated() // ! Only comments rocdutes are authenticated.
//                    .antMatchers("/**")
//                    .permitAll() // ! Everything not matched yet will not need login.
//                    .and().formLogin(); // ! We're saying we want to login using a login form.
        }

    }

