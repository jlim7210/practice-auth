package com.example.practiceauth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountRestController {

  @GetMapping("/oidc-principal")
  public OidcUser getOidcUserPrincipal(@AuthenticationPrincipal OidcUser principal) {
    return principal;
  }
}
