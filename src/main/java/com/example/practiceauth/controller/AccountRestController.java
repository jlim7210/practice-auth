package com.example.practiceauth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountRestController {

//  @GetMapping("/oidc-principal")
//  public OidcUser getOidcUserPrincipal(@AuthenticationPrincipal OidcUser principal) {
//    return principal;
//  }
}
