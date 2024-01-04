package com.example.practiceauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http
//        .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//            .requestMatchers("/home")
//            .permitAll()
//            .requestMatchers("/account/**")
//            .hasAuthority("SCOPE_openid")
//            .anyRequest().authenticated()
//        )
//        .formLogin(formLogin -> formLogin
//            .loginPage("/login") // custom login page URL
//            .successForwardUrl("/home")
//            .permitAll() // allow all users to view login page
//        );

//    http
//        .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//            .requestMatchers("/account/**")
//            .hasAuthority("SCOPE_openid")
//            .anyRequest().permitAll()
//        )
//            .formLogin(formLogin -> formLogin
//            .loginPage("/login") // custom login page URL
//            .successForwardUrl("/")
//            .permitAll() // allow all users to view login page
//        );
//    return http.build();

      http
              .authorizeRequests()
              .antMatchers("/login/oauth2/code/google").permitAll()
              .anyRequest().authenticated()
              .and()
              .oauth2Login();
        return http.build();
  }
}