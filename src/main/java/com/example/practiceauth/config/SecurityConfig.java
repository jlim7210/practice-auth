package com.example.practiceauth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
              .cors(Customizer.withDefaults())
              .httpBasic(Customizer.withDefaults())
              .csrf(Customizer.withDefaults())
              .logout(Customizer.withDefaults())
              .sessionManagement(Customizer.withDefaults())
              .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                      .requestMatchers("/").permitAll()
                      .requestMatchers("/login**").permitAll()
                      .requestMatchers("/error**").permitAll()
                      .requestMatchers("/callback/**").permitAll()
                      .requestMatchers("/webjars/**").permitAll()
                      .requestMatchers("/oauth2/**").permitAll()
                      .requestMatchers("/account/**").hasAuthority("SCOPE_openid")
                      .requestMatchers("/test/**").hasAuthority("SCOPE_openid")
                      .anyRequest().authenticated()
              )
              .oauth2Login(oauth2Login -> oauth2Login
                      .loginPage("/oauth2/authorization/google")
                      .authorizedClientRepository(authorizedClientRepository())
                      .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint.oidcUserService(oidcUserService())) // 회원 정보를 처리하기 위한 클래스 설정
                      .defaultSuccessUrl("/test")
                      .failureUrl("/loginFailure")
//                      .redirectionEndpoint(redirection -> redirection
//                              .baseUri("http://localhost:8090/login/oauth2/code/google")
//                      )
              );
        return http.build();
  }
}