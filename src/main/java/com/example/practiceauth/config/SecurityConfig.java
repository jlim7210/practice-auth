package com.example.practiceauth.config;

import com.example.practiceauth.service.impl.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final CustomOAuth2UserService service;

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
    http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
        .requestMatchers("/", "/login", "/oauth/**").permitAll()
        .anyRequest().authenticated()
    )
        .formLogin(formLogin -> formLogin.permitAll())
        .oauth2Login(oauth2 -> oauth2.loginPage("/login")
            .userInfoEndpoint(userInfo -> userInfo.userService(this.service))
            .defaultSuccessUrl("/home", true)
            .successHandler((request, response, authentication) -> {
              System.out.println("successHandler");
              System.out.println(authentication);
            })
        );
    return http.build();
  }
}
