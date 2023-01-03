package com.example.demosogetisecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// avant de charger le projet, on charge les configurations présentes la ou se trouve l'annotation @Configuration
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      /*http.authorizeHttpRequests()
              .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
              .requestMatchers("/myNotices", "/myContact").permitAll()
              .and().formLogin()
              .and().httpBasic();*/
//empecher tout acces
        /*http.authorizeHttpRequests().anyRequest().denyAll()
                .and().formLogin()
                .and().httpBasic();*/
//autoriser tout acces
        http.authorizeHttpRequests().anyRequest().permitAll()
                .and().formLogin()
                .and().httpBasic();
      return http.build();
    }
}
