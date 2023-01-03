package com.example.demosogetisecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

// avant de charger le projet, on charge les configurations présentes la ou se trouve l'annotation @Configuration
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.csrf().disable()
              .authorizeHttpRequests()
              .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
              .requestMatchers("/myNotices", "/myContact", "/register").permitAll()
              .and().formLogin()
              .and().httpBasic();
//empecher tout acces
        /*http.authorizeHttpRequests().anyRequest().denyAll()
                .and().formLogin()
                .and().httpBasic();*/
//autoriser tout acces
        /*http.authorizeHttpRequests().anyRequest().permitAll()
                .and().formLogin()
                .and().httpBasic();*/
      return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        /*return NoOpPasswordEncoder.getInstance();*/
        return new BCryptPasswordEncoder();
    }

    // determine user and pass and add user authorities here
    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails admin = User.withUsername("user")
                .password("12345")
                .authorities("read").build();
        return new InMemoryUserDetailsManager();
    }*/

    // load user+pass list with its authorities from MYSQL table
    /*@Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/

}
