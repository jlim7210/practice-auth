//package com.example.practiceauth.config;
//
//import java.net.URI;
//import java.util.HashSet;
//import java.util.Set;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
//import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
//@Configuration
//public class OAuth2LoginSecurityConfig {
//
//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    Set<String> googleScopes = new HashSet<>();
//    googleScopes.add("https://www.googleapis.com/auth/userinfo.email");
//    googleScopes.add("https://www.googleapis.com/auth/userinfo.profile");
//
//    OidcUserService googleUserService = new OidcUserService();
//    googleUserService.setAccessibleScopes(googleScopes);
//
//    http
//        .authorizeHttpRequests(authorizeRequests ->
//            authorizeRequests
//                .requestMatchers("/home")
//                .permitAll()
//                .requestMatchers("/account/go/**")
//                .permitAll()
//                .requestMatchers("/test/**")
//        .authenticated()
//                .anyRequest()
//                .authenticated())
//        .oauth2Login(OidcUserServiceConfig -> OidcUserServiceConfig
//            .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
//                .oidcUserService(googleUserService)))
//        .logout(logout -> logout
//            .logoutSuccessHandler(oidcLogoutSuccessHandler()));
//    return http.build();
//  }
//
//  private LogoutSuccessHandler oidcLogoutSuccessHandler() {
//    OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler =
//        new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository());
//
//    oidcLogoutSuccessHandler.setPostLogoutRedirectUri("http://localhost:8090/");
//
//    return oidcLogoutSuccessHandler;
//  }
//
//  private ClientRegistrationRepository clientRegistrationRepository() {
//    return new InMemoryClientRegistrationRepository();
//  }
//}
